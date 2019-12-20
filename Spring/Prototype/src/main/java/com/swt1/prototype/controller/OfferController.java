package com.swt1.prototype.controller;

import com.swt1.prototype.models.OfferDAO;
import com.swt1.prototype.models.Offer;
import com.swt1.prototype.services.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/offer/")
public class OfferController {
    @Autowired
    FirebaseService fbs;
    @Autowired
    OfferDAO dao;

    @PostMapping("/add")
    public boolean addTask(@RequestBody Offer offer) {
        boolean data = dao.create(offer);
        return data;
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Offer> getOffer() throws InterruptedException, ExecutionException {
        return dao.getAll();
    }
}

