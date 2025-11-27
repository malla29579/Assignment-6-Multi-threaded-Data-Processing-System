# Assignment-6-Multi-threaded-Data-Processing-System
# Data Processing System

## Overview

In this project, I designed and implemented a **Data Processing System** that simulates multiple worker threads processing data in parallel. The system uses a shared queue where worker threads retrieve tasks, process them, and save results to a shared resource. I implemented this system in both **Java** and **Go**, each with specific concurrency models and error-handling mechanisms to ensure efficient resource management, avoid deadlocks, and ensure smooth execution of all tasks.

## Features

- **Shared Queue**: I implemented a shared queue of tasks that each worker thread retrieves, processes, and writes the results to a shared output resource.
- **Concurrency Management**: In both Java and Go, I used synchronization techniques to manage thread access to shared resources and prevent race conditions.
- **Error Handling**: Both implementations include error-handling strategies to deal with potential exceptions, such as empty queue access and file I/O errors.
- **Logging**: The system logs each thread’s start, completion, and any encountered errors, providing transparency into the execution process.

## Languages and Tools

- **Java**:
  - **Concurrency**: `ExecutorService`, `BlockingQueue`
  - **Error Handling**: `try-catch` blocks
  - **Logging**: `java.util.logging`
  
- **Go**:
  - **Concurrency**: `goroutines`, `channels`
  - **Error Handling**: Error checking and `defer` statements
  - **Logging**: Built-in `log` package

## How It Works

### Java

1. **Task Queue**: I used a `BlockingQueue` to manage task retrieval. Threads are blocked if the queue is empty, ensuring that workers wait for tasks to be added.
2. **ExecutorService**: I used `ExecutorService` to manage a fixed thread pool, which helps execute worker threads that retrieve and process tasks concurrently.
3. **Error Handling**: Errors like interruptions and file I/O failures are caught and logged using `try-catch` blocks.

### Go

1. **Task Queue**: I used Go’s buffered `channel` to manage tasks. Channels are thread-safe and allow concurrent goroutines to retrieve tasks.
2. **Goroutines**: I used `go` keyword to create lightweight worker threads (goroutines) for parallel task processing.
3. **Error Handling**: I checked for errors after each operation and used `defer` to ensure proper resource management.



## Running the Project

### Java

1. Download or clone the repository.
2. Open the terminal and navigate to the project folder.
3. Compile and run the Java files using:
   ```bash
   javac *.java
   java DataProcessingSystem
