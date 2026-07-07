package com.ulsm.lab.barcode.service;

import com.ulsm.lab.barcode.model.LabSampleRecord;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Utility class for barcode encoding and decoding.
 */
public final class BarcodeCodec {

    // Separator used to combine record fields.
    private static final String DELIMITER = "|";

    // Prevent instantiation.
    private BarcodeCodec() {
    }

    /**
     * Encodes a laboratory sample record into a URL-safe Base64 barcode.
     */
    public static String encode(LabSampleRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("record must not be null");
        }

        // Build the payload before encoding.
        String payload = String.join(DELIMITER, record.patientId(), record.testCode(), record.sampleId());

        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(payload.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Decodes a barcode back into a laboratory sample record.
     */
    public static LabSampleRecord decode(String barcodeValue) {
        if (barcodeValue == null || barcodeValue.isBlank()) {
            throw new IllegalArgumentException("barcodeValue must not be blank");
        }

        byte[] decodedBytes;
        try {
            // Decode the Base64 barcode value.
            decodedBytes = Base64.getUrlDecoder().decode(barcodeValue.trim());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("barcodeValue is not a valid encoded payload", ex);
        }

        String decodedPayload = new String(decodedBytes, StandardCharsets.UTF_8);

        // Split the decoded payload into individual fields.
        String[] parts = decodedPayload.split("\\|", -1);

        if (parts.length != 3) {
            throw new IllegalArgumentException("decoded barcode must contain patientId, testCode, and sampleId");
        }

        return new LabSampleRecord(parts[0], parts[1], parts[2]);
    }
}
