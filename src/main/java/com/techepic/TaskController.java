package com.fci;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TaskController {

	@Autowired
	TaskRepository repo;

	@PutMapping("/tasks/{id}")
	ResponseEntity updateDescriptionAndPriority(@PathVariable("id") long id, @RequestBody Task task) {
 		Optional<Task> taskToCheck = repo.findById(id);
		if (taskToCheck.isPresent()) {
 			if (task.getDescription() != null) {
				System.out.println(2222222);
				Task taskToBeUpdated = taskToCheck.get();
				taskToBeUpdated.setDescription(task.getDescription());
				taskToBeUpdated.setPriority(task.getPriority());
				return new ResponseEntity<>(repo.save(taskToBeUpdated), HttpStatus.OK);
			} else {
				System.out.println(1111111);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task description is required");
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cannot find task with given id");
		}
	}

}
