package com.ulsm.lab.barcode.service;

import com.ulsm.lab.barcode.model.LabSampleRecord;
import com.ulsm.lab.barcode.repository.InMemorySampleRecordRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BarcodeCodecTest {

    @Test
    void encodeDecodeRoundTripKeepsFields() {
        // Create the original laboratory sample record.
        LabSampleRecord original = new LabSampleRecord("P-1001", "CBC", "S-22001");

        // Encode and decode the sample record.
        String barcode = BarcodeCodec.encode(original);
        LabSampleRecord decoded = BarcodeCodec.decode(barcode);

        assertEquals(original, decoded);
    }

    @Test
    void decodeRejectsNonBase64Content() {
        // Verify that invalid barcode content is rejected
        assertThrows(IllegalArgumentException.class, () -> BarcodeCodec.decode("not-a-barcode$$$"));
    }

    @Test
    void repositoryStoresAndFindsBySampleId() {
        // Initialize the repository and sample record
        InMemorySampleRecordRepository repository = new InMemorySampleRecordRepository();
        LabSampleRecord record = new LabSampleRecord("P-1002", "LFT", "S-22002");

        repository.save(record);

        // Confirm the stored record can be retrieved by sample ID
        assertTrue(repository.findBySampleId("S-22002").isPresent());
        assertEquals(record, repository.findBySampleId("S-22002").orElseThrow());
    }
}
