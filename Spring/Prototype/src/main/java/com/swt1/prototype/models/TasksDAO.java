package com.swt1.prototype.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.swt1.prototype.services.FirebaseService;

@Repository
public class TasksDAO implements DAO<Tasks> {

	private List<Tasks> tasks = new ArrayList<>();
	@Autowired
	FirebaseService fb;

	@Override
	public Optional<Tasks> get(int id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(tasks.get((int) id));
	}

	@Override
	public List<Tasks> getAll() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		ApiFuture<QuerySnapshot> query = fb.getDb().collection("tasks").get();
		QuerySnapshot data = query.get();
		List<QueryDocumentSnapshot> doc = data.getDocuments();

		for (QueryDocumentSnapshot document : doc) {
			System.out.println("DocumentID " + document.getId());
			System.out.println("user: " + document.getString("user"));
			System.out.println("name: " + document.getString("name"));
			System.out.println("description: " + document.getString("description"));
			tasks.add(new Tasks(document.getString("name"), document.getString("user"),
					"asdasdasd", document.getId()));
		}
		return tasks;
	}

//	public List<Tasks> getallTasks() throws InterruptedException, ExecutionException {
//		ApiFuture<QuerySnapshot> query = db.collection("tasks").get();
//		QuerySnapshot data = query.get();
//		List<QueryDocumentSnapshot> doc = data.getDocuments();
//
//		for (QueryDocumentSnapshot document : doc) {
//			System.out.println("user: " + document.getString("user"));
//			System.out.println("name: " + document.getString("name"));
//			System.out.println("description: " + document.getString("description"));
//			dao.create(new Tasks(document.getString("name"), document.getString("user"),
//					document.getString("description")));
//		}
//		return dao.getAll();
//	}

	@Override
	public boolean create(Tasks task) {
		// TODO Auto-generated method stub
		if (!tasks.contains(task)) {
			CollectionReference collection = fb.getDb().collection("tasks");
			Map<String, String> data = new HashMap<>();
			data.put("name", task.getName());
			data.put("user", task.getUser());
			data.put("description", task.getDescription());
			collection.add(data);
			tasks.add(task);
			return true;
		}
		return false;
	}

	@Override
	public void update(Tasks t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean delete(Tasks t) {
		// TODO Auto-generated method stub
		// tasks.remove(o)
		return true;
	}

}
