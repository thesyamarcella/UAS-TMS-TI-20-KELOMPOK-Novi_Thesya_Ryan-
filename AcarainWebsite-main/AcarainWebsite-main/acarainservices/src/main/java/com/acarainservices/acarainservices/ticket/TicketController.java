package com.acarainservices.acarainservices.ticket;

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

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketServices ticketServices;

    @PostMapping
    // public Ticket postStudent(@Valid @RequestBody Ticket ticket, Errors errors) {
    public ResponseEntity<ResponseData<Ticket>> postTicket(@Valid @RequestBody Ticket ticket, Errors errors) {
        ResponseData<Ticket> responseData = new ResponseData<>();

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
            List<Ticket> value = new ArrayList<>();
            value.add(ticketServices.save(ticket));
            responseData.setData(value);
        } catch (Exception e) {
            responseData.setData(null);
            responseData.setResult(false);
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
        }

        return ResponseEntity.ok(responseData);
        // return ticketServices.save(ticket);
    }

    @GetMapping
    // public Iterable<Ticket> fetchStudent(){
    public ResponseEntity<ResponseData<Ticket>> fetchTicket() {
        // return ticketServices.findAll();
        ResponseData<Ticket> responseData = new ResponseData<>();
        try {
            Iterable<Ticket> values = ticketServices.findAll();
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
    // public Ticket fetchStudentById(@PathVariable("id") int id){
    public ResponseEntity<ResponseData<Ticket>> fetchTicketById(@PathVariable("id") int id) {
        // return ticketServices.findOne(id);
        ResponseData<Ticket> responseData = new ResponseData<>();

        try {
            Ticket values = ticketServices.findOne(id);
            List<Ticket> result = new ArrayList<>();
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
    @GetMapping("/events/{id}")
    // public Ticket fetchStudentById(@PathVariable("id") int id){
    public ResponseEntity<ResponseData<Ticket>> fetchTicketByEventId(@PathVariable("id") int id) {
        // return ticketServices.findOne(id);
        ResponseData<Ticket> responseData = new ResponseData<>();

        try {
            List<Ticket> values = ticketServices.getIdTicket(id);
            List<Ticket> result = new ArrayList<>();
            result.addAll(values);
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
    // public Ticket updateStudent(@RequestBody Ticket ticket){
    public ResponseEntity<ResponseData<Ticket>> updateStudent(@Valid @RequestBody Ticket ticket, Errors errors) {
        ResponseData<Ticket> responseData = new ResponseData<>();

        if (ticket.getId() != 0) {

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
                List<Ticket> value = new ArrayList<>();
                value.add(ticketServices.save(ticket));
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
    // public void deleteStudentById(@PathVariable("id") int id){
    public ResponseEntity<ResponseData<Ticket>> deleteTicketById(@PathVariable("id") int id) {
        ResponseData<Ticket> responseData = new ResponseData<>();
        if (id != 0) {
            try {
                ticketServices.removeOne(id);
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

    // @PostMapping("/search")
    // public ResponseEntity<ResponseData<Ticket>> getticketByName(@RequestBody
    // SearchData searchData) {
    // ResponseData<Ticket> responseData = new ResponseData<>();
    // try {
    // Iterable<Ticket> values =
    // ticketServices.findbyname(searchData.getSearchKey());
    // responseData.setResult(true);
    // responseData.setMessage(null);
    // responseData.setData(values);
    // return ResponseEntity.ok(responseData);
    // } catch (Exception e) {
    // List<String> message = new ArrayList<>();
    // message.add(e.getMessage());
    // responseData.setMessage(message);
    // responseData.setData(null);
    // responseData.setResult(false);
    // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    // }
    // }

}
