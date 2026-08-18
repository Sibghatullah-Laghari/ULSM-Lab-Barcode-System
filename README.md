# ULSM Lab Barcode Management Utility

> 📅 **Last updated:** 2026-07-17  
> 📌 *Note:* Minor documentation refresh and added developer tips.

A lightweight Java application for generating, decoding, and managing laboratory sample barcodes. The utility is designed to improve sample tracking and help laboratories maintain structured digital records.

## Overview

This project provides a simple framework for processing barcodes in laboratory environments. It enables users to

* Generate barcode values from laboratory sample information.
* Decode barcode values into readable sample details.
* Store sample records in memory during application execution.
* Validate input before barcode generation or decoding.

## Main Features

* URL-safe Base64 encoding and decoding.
* Validation of patient IDs, sample IDs, and laboratory test codes..
* In-memory repository for temporary storage of sample records..
* Simple command-line interface for demonstration and testing.
* Maven-based project with JUnit 5 unit testing support..

## Technology Stack

* Java 17
* Apache Maven 3.9+
* JUnit 5

## Requirements

Before starting the application, make sure the following software is installed

* Java Development Kit (JDK) 17
* Apache Maven 3.9 or newer

## Build and Test

Clone the repository and execute:

```bash
mvn test
...
