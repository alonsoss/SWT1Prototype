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
/*
@Repository
public class UsersDAO implements DAO<Users> {

    private List<Users> users = new ArrayList<>();
    @Autowired
    FirebaseService fb;

    @Override
    public Optional<Users> get(int id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public List<Users> getAll() throws InterruptedException, ExecutionException {
        // TODO Auto-generated method stub
        ApiFuture<QuerySnapshot> query = fb.getDb().collection("users").get();
        QuerySnapshot data = query.get();
        List<QueryDocumentSnapshot> doc = data.getDocuments();

        for (QueryDocumentSnapshot document : doc) {
            System.out.println("DocumentID " + document.getId());
            System.out.println("name: " + document.getString("name"));
            System.out.println("username: " + document.getString("username"));
            System.out.println("email: " + document.getString("email"));
            System.out.println("password: " + document.getString("password"));
            users.add(new Users(document.getString("name"), document.getString("username"),
                    document.getString("email"),  document.getString("password"), document.getId()));
        }
        return users;
    }

    @Override
    public boolean create(Users user) {
        // TODO Auto-generated method stub
        if (!users.contains(user)) {
            CollectionReference collection = fb.getDb().collection("users");
            Map<String, String> data = new HashMap<>();
            data.put("name", user.getName());
            data.put("username", user.getUsername());
            data.put("email", user.getEmail());
            data.put("password", user.getPassword());
            collection.add(data);
            users.add(user);
            return true;
        }
        return false;
    }

    @Override
    public void update(Users t) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean delete(Users t) {
        // TODO Auto-generated method stub
        // users.remove(o)
        return true;
    }

}

 */