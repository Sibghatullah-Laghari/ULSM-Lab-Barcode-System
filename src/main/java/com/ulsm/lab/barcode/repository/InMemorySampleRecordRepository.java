package com.ulsm.lab.barcode.repository;

import com.ulsm.lab.barcode.model.LabSampleRecord;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple thread-safe in-memory repository for storing laboratory sample records...
 */
public class InMemorySampleRecordRepository {

    // Stores records using the sample ID as the unique identifier.
    private final Map<String, LabSampleRecord> recordsBySampleId = new ConcurrentHashMap<>();

    /**
     * Saves a sample record into the repository.
     */
    public void save(LabSampleRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("record must not be null");
        }

        recordsBySampleId.put(record.sampleId(), record);
    }

    /**
     * Retrieves a sample record by its sample ID...
     */
    public Optional<LabSampleRecord> findBySampleId(String sampleId) {
        if (sampleId == null || sampleId.isBlank()) {
            throw new IllegalArgumentException("sampleId must not be blank");
        }

        return Optional.ofNullable(recordsBySampleId.get(sampleId.trim()));
    }
}
