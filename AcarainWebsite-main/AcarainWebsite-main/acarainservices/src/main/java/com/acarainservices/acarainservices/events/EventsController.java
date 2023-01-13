package com.acarainservices.acarainservices.events;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acarainservices.acarainservices.dto.ResponseData;
import com.acarainservices.acarainservices.dto.SearchData;

@RestController
@RequestMapping("/api/events/")
public class EventsController {

    @Autowired
    private EventsServices eventsServices;

    @PostMapping
    // public Events postStudent(@Valid @RequestBody Events events, Errors errors) {
    public ResponseEntity<ResponseData<Events>> postStudent(@Valid @RequestBody Events events, Errors errors) {
        ResponseData<Events> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                // System.out.println(error.getDefaultMessage());
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);

            // throw new RuntimeException("Validation Error")
        }

        try {
            responseData.setResult(true);
            List<Events> value = new ArrayList<>();
            value.add(eventsServices.save(events));
            responseData.setData(value);
        } catch (Exception e) {
            responseData.setData(null);
            responseData.setResult(false);
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
        }

        return ResponseEntity.ok(responseData);
        // return eventsServices.save(events);
    }

    @GetMapping
    // public Iterable<Events> fetchEvents(){
    public ResponseEntity<ResponseData<Events>> fetchEvents() {
        // return eventsServices.findAll();
        ResponseData<Events> responseData = new ResponseData<>();
        try {
            Iterable<Events> values = eventsServices.findAll();
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(values);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @GetMapping("/{id}")
    // public Events fetchEventsById(@PathVariable("id") int id){
    public ResponseEntity<ResponseData<Events>> fetchEventsById(@PathVariable("id") int id) {
        // return eventsServices.findOne(id);
        ResponseData<Events> responseData = new ResponseData<>();

        try {
            Events values = eventsServices.findOne(id);
            List<Events> result = new ArrayList<>();
            result.add(values);
            responseData.setData(result);
            responseData.setResult(true);
            responseData.setMessage(null);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PutMapping
    // public Events updateEvents(@RequestBody Events events){
    public ResponseEntity<ResponseData<Events>> updateEvents(@Valid @RequestBody Events events, Errors errors) {
        ResponseData<Events> responseData = new ResponseData<>();

        if (events.getId() != 0) {

            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }
                responseData.setResult(false);
                responseData.setData(null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            try {
                responseData.setResult(true);
                List<Events> value = new ArrayList<>();
                value.add(eventsServices.save(events));
                responseData.setData(value);

            } catch (Exception e) {
                responseData.setData(null);
                responseData.setResult(false);
                List<String> message = new ArrayList<>();
                message.add(e.getMessage());
                responseData.setMessage(message);
            }

            return ResponseEntity.ok(responseData);

        } else {
            responseData.setResult(false);
            responseData.setData(null);
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

    }
   

    @DeleteMapping("/{id}")
    // public void deleteEventById(@PathVariable("id") int id){
    public ResponseEntity<ResponseData<Events>> deleteEventById(@PathVariable("id") int id) {
        ResponseData<Events> responseData = new ResponseData<>();
        if (id != 0) {
            try {
                eventsServices.removeOne(id);
                List<String> message = new ArrayList<>();
                message.add("Successfully removed");
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(true);
                return ResponseEntity.ok(responseData);
            } catch (Exception e) {
                List<String> message = new ArrayList<>();
                message.add(e.getMessage());
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(false);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }
        } else {
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

    }

    @PostMapping("/search")
    public ResponseEntity<ResponseData<Events>> getEventsByName(@RequestBody SearchData searchData) {
        ResponseData<Events> responseData = new ResponseData<>();
        try {
            Iterable<Events> values = eventsServices.findbyname(searchData.getSearchKey());
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(values);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

}
