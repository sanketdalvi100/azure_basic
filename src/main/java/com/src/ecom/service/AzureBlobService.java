package com.src.ecom.service;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.sas.BlobSasPermission;
import com.azure.storage.blob.sas.BlobServiceSasSignatureValues;
import com.azure.storage.common.sas.SasProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class AzureBlobService {

    @Value("${azure.storage.container-name}")
    private String containerName;

    private final BlobServiceClient blobServiceClient;

    public AzureBlobService(BlobServiceClient blobServiceClient) {
        this.blobServiceClient = blobServiceClient;
    }

    /**
     * Generate a secure, time-limited SAS URL for reading a blob
     */
    public String generateSasUrl(String blobName) {
        BlobClient blobClient = blobServiceClient
                .getBlobContainerClient(containerName)
                .getBlobClient(blobName);

        BlobSasPermission permission = new BlobSasPermission()
                .setReadPermission(true);

        OffsetDateTime expiry = OffsetDateTime.now().plusMinutes(30);

        BlobServiceSasSignatureValues values =
                new BlobServiceSasSignatureValues(expiry, permission)
                        .setProtocol(SasProtocol.HTTPS_ONLY);

        String sas = blobClient.generateSas(values);

        return blobClient.getBlobUrl() + "?" + sas;
    }

    /**
     * Upload a file to Azure Blob Storage
     */
    public String upload(MultipartFile file) throws IOException {
        String blobName = UUID.randomUUID() + "-" + file.getOriginalFilename();

        BlobClient blobClient = blobServiceClient
                .getBlobContainerClient(containerName)
                .getBlobClient(blobName);

        blobClient.upload(file.getInputStream(), file.getSize(), true);

        return blobName; // Save this in DB
    }

    /**
     * Delete a blob
     */
    public void delete(String blobName) {
        blobServiceClient
                .getBlobContainerClient(containerName)
                .getBlobClient(blobName)
                .deleteIfExists();
    }
}

