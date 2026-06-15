# ULSM Lab Barcode Management Utility

A lightweight Java application designed to generate, decode, and manage laboratory sample barcode information in a structured and reliable manner.

## Introduction

This project serves as a foundation for laboratory barcode processing by allowing users to:

* Generate barcode strings from laboratory sample information.
* Decode barcode values back into meaningful records.
* Store and retrieve sample records during runtime.
* Perform validation checks before processing data.

## Core Capabilities

* Base64 URL-safe barcode generation and decoding.
* Validation of patient identifiers, sample identifiers, and test codes.
* Runtime repository for managing sample records.
* Simple command-line interface for demonstration and testing.
* Maven build configuration with JUnit testing support.

## Technologies Used

* Java 17
* Apache Maven 3.9+
* JUnit 5

## Installation

### Prerequisites

* Java Development Kit (JDK) 17
* Maven 3.9 or newer

### Getting Started

Clone the repository and execute:

```bash
mvn test
```

This command compiles the project and runs all available unit tests.

## Running the Application

After building the project:

```bash
mvn -q package
```

### Create a Barcode

```bash
java -cp target/classes com.ulsm.lab.barcode.App encode P-1001 CBC S-22001
```

### Decode a Barcode

```bash
java -cp target/classes com.ulsm.lab.barcode.App decode <BARCODE>
```

## Example Usage

### Barcode Generation

Command:

```bash
java -cp target/classes com.ulsm.lab.barcode.App encode P-1001 CBC S-22001
```

Output:

```text
UC0xMDAxfENCQ3xTLTIyMDAx
```

### Barcode Decoding

Command:

```bash
java -cp target/classes com.ulsm.lab.barcode.App decode UC0xMDAxfENCQ3xTLTIyMDAx
```

Output:

```text
patientId=P-1001, testCode=CBC, sampleId=S-22001
```

## Directory Layout

```text
.
├── pom.xml
├── src
│   ├── main
│   │   └── java/com/ulsm/lab/barcode
│   │       ├── App.java
│   │       ├── model/LabSampleRecord.java
│   │       ├── repository/InMemorySampleRecordRepository.java
│   │       └── service/BarcodeCodec.java
│   └── test
│       └── java/com/ulsm/lab/barcode/service/BarcodeCodecTest.java
└── README.md
```

## Processing Workflow

1. User submits a patient ID, test code, and sample ID.
2. The record object validates the supplied information.
3. Barcode data is assembled into a pipe-separated format.
4. The payload is encoded using URL-safe Base64.
5. During decoding, the original values are reconstructed.
6. Records may be stored and accessed through the in-memory repository.

## Common Issues

### Maven Not Installed

Error:

```text
mvn: command not found
```

Solution:

Install Maven and verify it is available in your system PATH.

### Unsupported Java Version

Error:

```text
invalid target release: 17
```

Solution:

Verify that Java 17 is installed and selected as the active JDK.

### Invalid Barcode Exception

Cause:

The barcode value may not have been produced by this application or has been modified.

### No CLI Response

Ensure the correct syntax is used:

```text
encode <patientId> <testCode> <sampleId>
```

or

```text
decode <barcodeValue>
```
###Future

AI will be integrated soon for record analysis, patient analysis, and in management.
