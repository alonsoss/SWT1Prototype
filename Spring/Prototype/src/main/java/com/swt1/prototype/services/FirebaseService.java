package com.swt1.prototype.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.swt1.prototype.models.Tasks;
import com.swt1.prototype.models.TasksDAO;

@Service
public class FirebaseService {
	private Firestore db;
	@Autowired
	private TasksDAO dao;

	public FirebaseService() throws IOException {
		// TODO Auto-generated constructor stub
		initDB();
	}

	/**
	 * @return the db
	 */
	public Firestore getDb() {
		return db;
	}

	// Init Firestore
	private void initDB() throws IOException {
		ClassLoader classloader = getClass().getClassLoader();
		File config = new File(
				classloader.getResource("swt1prototype-firebase-adminsdk-o6nvy-87f8c5c264.json").getFile());
		// Use a service account
		InputStream serviceAccount = new FileInputStream(config);
		GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
		FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
		FirebaseApp.initializeApp(options);
		this.db = FirestoreClient.getFirestore();
	}

}
