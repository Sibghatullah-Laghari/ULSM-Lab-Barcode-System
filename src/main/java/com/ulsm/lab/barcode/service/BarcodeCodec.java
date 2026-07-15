package com.ulsm.lab.barcode.service;

import com.ulsm.lab.barcode.model.LabSampleRecord;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Utility class used to encode and decode laboratory barcode information.
 */
public final class BarcodeCodec {

    // Separator used when combining laboratory record fields.
    private static final String DELIMITER = "|";

    // Prevent direct creation of utility class instances.
    private BarcodeCodec() {
    }

    /**
     * Encodes a laboratory sample record as a URL-safe Base64 barcode.
     */
    public static String encode(LabSampleRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("record must not be null");
        }

        // Build the record payload before applying Base64 encoding.
        String payload = String.join(DELIMITER, record.patientId(), record.testCode(), record.sampleId());

        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(payload.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Decodes a barcode value into a laboratory sample record.
     */
    public static LabSampleRecord decode(String barcodeValue) {
        if (barcodeValue == null || barcodeValue.isBlank()) {
            throw new IllegalArgumentException("barcodeValue must not be blank");
        }

        byte[] decodedBytes;
        try {
            // Decode the provided URL-safe Base64 barcode.
            decodedBytes = Base64.getUrlDecoder().decode(barcodeValue.trim());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("barcodeValue is not a valid encoded payload", ex);
        }

        String decodedPayload = new String(decodedBytes, StandardCharsets.UTF_8);

        // Separate the decoded payload into individual record fields.
        String[] parts = decodedPayload.split("\\|", -1);

        if (parts.length != 3) {
            throw new IllegalArgumentException("decoded barcode must contain patientId, testCode, and sampleId");
        }

        return new LabSampleRecord(parts[0], parts[1], parts[2]);
    }
}
