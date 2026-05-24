package com.ulsm.lab.barcode;

import com.ulsm.lab.barcode.model.LabSampleRecord;
import com.ulsm.lab.barcode.service.BarcodeCodec;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        if (args.length == 4 && "encode".equalsIgnoreCase(args[0])) {
            LabSampleRecord record = new LabSampleRecord(args[1], args[2], args[3]);
            System.out.println(BarcodeCodec.encode(record));
            return;
        }
        if (args.length == 2 && "decode".equalsIgnoreCase(args[0])) {
            LabSampleRecord record = BarcodeCodec.decode(args[1]);
            System.out.printf("patientId=%s, testCode=%s, sampleId=%s%n",
                    record.patientId(), record.testCode(), record.sampleId());
            return;
        }

        System.out.println("Usage:");
        System.out.println("  encode <patientId> <testCode> <sampleId>");
        System.out.println("  decode <barcodeValue>");
    }
}
