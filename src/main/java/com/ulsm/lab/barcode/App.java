package com.ulsm.lab.barcode;

import com.ulsm.lab.barcode.model.LabSampleRecord;
import com.ulsm.lab.barcode.service.BarcodeCodec;

/**
 * Command-line entry point for the barcode utility.
 */
public final class App {

    // Prevent instantiation.
    private App() {
    }

    public static void main(String[] args) {

        // Encode a laboratory record into a barcode.
        if (args.length == 4 && "encode".equalsIgnoreCase(args[0])) {
            LabSampleRecord record = new LabSampleRecord(args[1], args[2], args[3]);
            System.out.println(BarcodeCodec.encode(record));
            return;
        }

        // Decode a barcode into its original record.
        if (args.length == 2 && "decode".equalsIgnoreCase(args[0])) {
            LabSampleRecord record = BarcodeCodec.decode(args[1]);
            System.out.printf("patientId=%s, testCode=%s, sampleId=%s%n",
                    record.patientId(), record.testCode(), record.sampleId());
            return;
        }

        // Display usage instructions for invalid commands.
        System.out.println("Usage:");
        System.out.println("  encode <patientId> <testCode> <sampleId>");
        System.out.println("  decode <barcodeValue>");
    }
}
