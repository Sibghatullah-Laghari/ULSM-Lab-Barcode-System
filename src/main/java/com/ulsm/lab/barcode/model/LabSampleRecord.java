/**
 * Represents a single laboratory sample record.
 */
public record LabSampleRecord(String patientId, String testCode, String sampleId) {

    // Validate and normalize all fields when creating a new record.
    public LabSampleRecord {
        patientId = requireNonBlank(patientId, "patientId");
        testCode = requireNonBlank(testCode, "testCode");
        sampleId = requireNonBlank(sampleId, "sampleId");
    }

    /**
     * Ensures the provided value is not null or blank.
     */
    private static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }

        // Trim leading and trailing whitespace before storing the value.
        return value.trim();
    }
}
