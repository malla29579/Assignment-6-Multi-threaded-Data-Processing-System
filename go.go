package main

import (
	"fmt"
	"time"
)

type Task struct {
	description string
}

func (t Task) getDescription() string {
	return t.description
}

func worker(taskQueue chan Task) {
	// Continuously fetch tasks from the channel
	for task := range taskQueue {
		// Simulate task processing
		fmt.Printf("%s is processing: %s\n", "Worker", task.getDescription())
		time.Sleep(1 * time.Second)
		// Log task completion
		logTaskCompletion(task)
	}
}

func logTaskCompletion(task Task) {
	// Log task completion
	fmt.Printf("Completed task: %s\n", task.getDescription())
}

func main() {
	// Create a buffered channel to simulate the task queue
	taskQueue := make(chan Task, 10)

	// Start multiple worker goroutines
	for i := 0; i < 4; i++ {
		go worker(taskQueue)
	}

	// Add tasks to the queue
	for i := 0; i < 10; i++ {
		taskQueue <- Task{description: fmt.Sprintf("Task %d", i+1)}
	}

	// Wait for workers to complete their tasks (can be adjusted as per your needs)
	time.Sleep(5 * time.Second)
}
