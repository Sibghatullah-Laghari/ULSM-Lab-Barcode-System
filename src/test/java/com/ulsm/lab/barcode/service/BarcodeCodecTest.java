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
        LabSampleRecord original = new LabSampleRecord("P-1001", "CBC", "S-22001");

        String barcode = BarcodeCodec.encode(original);
        LabSampleRecord decoded = BarcodeCodec.decode(barcode);

        assertEquals(original, decoded);
    }

    @Test
    void decodeRejectsNonBase64Content() {
        assertThrows(IllegalArgumentException.class, () -> BarcodeCodec.decode("not-a-barcode$$$"));
    }

    @Test
    void repositoryStoresAndFindsBySampleId() {
        InMemorySampleRecordRepository repository = new InMemorySampleRecordRepository();
        LabSampleRecord record = new LabSampleRecord("P-1002", "LFT", "S-22002");

        repository.save(record);

        assertTrue(repository.findBySampleId("S-22002").isPresent());
        assertEquals(record, repository.findBySampleId("S-22002").orElseThrow());
    }
}
