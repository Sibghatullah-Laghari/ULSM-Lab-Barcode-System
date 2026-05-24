package com.ulsm.lab.barcode.repository;

import com.ulsm.lab.barcode.model.LabSampleRecord;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemorySampleRecordRepository {
    private final Map<String, LabSampleRecord> recordsBySampleId = new ConcurrentHashMap<>();

    public void save(LabSampleRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("record must not be null");
        }
        recordsBySampleId.put(record.sampleId(), record);
    }

    public Optional<LabSampleRecord> findBySampleId(String sampleId) {
        if (sampleId == null || sampleId.isBlank()) {
            throw new IllegalArgumentException("sampleId must not be blank");
        }
        return Optional.ofNullable(recordsBySampleId.get(sampleId.trim()));
    }
}
