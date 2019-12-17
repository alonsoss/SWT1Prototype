package com.swt1.prototype.controller;

import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.swt1.prototype.models.Tasks;
import com.swt1.prototype.models.TasksDAO;
import com.swt1.prototype.services.FirebaseService;

@RestController
@RequestMapping("/api/task/")
public class TaskController {
	Tasks test;

	@Autowired
	FirebaseService fbs;
	@Autowired
	TasksDAO dao;

	@PostMapping("/add")
	public boolean addTask(@RequestBody Tasks task) {
		boolean data = dao.create(task);
		return data;
	}

	@GetMapping("/getAll")
	@ResponseBody
	public List<Tasks> getTasks() throws InterruptedException, ExecutionException {
		return dao.getAll();
	}
}
