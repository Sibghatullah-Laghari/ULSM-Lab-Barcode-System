package com.ulsm.lab.barcode.model;

public record LabSampleRecord(String patientId, String testCode, String sampleId) {
    public LabSampleRecord {
        patientId = requireNonBlank(patientId, "patientId");
        testCode = requireNonBlank(testCode, "testCode");
        sampleId = requireNonBlank(sampleId, "sampleId");
    }

    private static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
        return value.trim();
    }
}
