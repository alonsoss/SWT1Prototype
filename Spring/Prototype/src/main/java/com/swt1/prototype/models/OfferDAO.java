package com.swt1.prototype.models;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.swt1.prototype.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Repository
public class OfferDAO implements DAO<Offer> {

    private List<Offer> offers = new ArrayList<>();
    @Autowired
    FirebaseService fb;

    @Override
    public Optional<Offer> get(int id) {
        // TODO Auto-generated method stub
        return Optional.ofNullable(offers.get((int) id));
    }

    @Override
    public List<Offer> getAll() throws InterruptedException, ExecutionException {
        // TODO Auto-generated method stub
        ApiFuture<QuerySnapshot> query = fb.getDb().collection("offers").get();
        QuerySnapshot data = query.get();
        List<QueryDocumentSnapshot> doc = data.getDocuments();

        for (QueryDocumentSnapshot document : doc) {
            System.out.println("user: " + document.getString("user"));
            System.out.println("price: " + document.getString("price"));
            System.out.println("description: " + document.getString("description"));
            System.out.println("accepted" + document.getBoolean("accepted"));
            System.out.println("DocumentID " + document.getId());
            offers.add(new Offer(document.getString("user"), document.getString("price"),
                    document.getString("description"),  document.getId()));
        }
        return offers;
    }


    @Override
    public boolean create(Offer offer) {
        // TODO Auto-generated method stub
        if (!offers.contains(offer)) {
            CollectionReference collection = fb.getDb().collection("offers");
            Map<String, Object> data = new HashMap<>();
            data.put("user", offer.getUser());
            data.put("price", offer.getPrice());
            data.put("description", offer.getDescription());
            data.put("accepted", offer.isAccepted());
            collection.add(data);
            offers.add(offer);
            return true;
        }
        return false;
    }

    @Override
    public void update(Offer t) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean delete(Offer t) {
        // TODO Auto-generated method stub
        // tasks.remove(o)
        return true;
    }

}
