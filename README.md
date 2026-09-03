# ULSM Lab Barcode Management Utility

> 📅 **Last updated:** 2026-08-27  
> 📌 *Note:* Minor documentation refresh with improved developer guidance.

A lightweight Java application for generating, decoding, and managing laboratory sample barcodes. This utility improves sample traceability and assists laboratories in maintaining structured digital logs.

## Overview

This project offers a straightforward framework for barcode processing in lab settings. It allows users to:

* Generate barcode values based on laboratory sample metadata.
* Decode barcode strings back into readable sample attributes.
* Keep sample records in memory during the application runtime.
* Validate all inputs prior to barcode generation or decoding.

## Main Features

* URL‑safe Base64 encoding and decoding routines.
* Validation rules for patient IDs, sample IDs, and lab test codes.
* Temporary in‑memory repository for storing sample entries.
* Simple command‑line interface for demonstration and testing purposes.
* Maven‑based build with JUnit 5 unit test coverage.

## Technology Stack

* Java 17
* Apache Maven 3.9+
* JUnit 5

## Requirements

Ensure the following are installed before running the application:

* Java Development Kit (JDK) 17
* Apache Maven 3.9 or later

