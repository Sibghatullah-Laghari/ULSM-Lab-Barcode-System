/**
 * Represents an individual laboratory sample records...
 */
public record LabSampleRecord(String patientId, String testCode, String sampleId) {

    // Validate and normalize each field during record creation.
    public LabSampleRecord {
        patientId = requireNonBlank(patientId, "patientId");
        testCode = requireNonBlank(testCode, "testCode");
        sampleId = requireNonBlank(sampleId, "sampleId");
    }

    private static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }

        // Remove leading and trailing whitespace before storing the field value.
        return value.trim();
    }
}
