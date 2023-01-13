package com.acarainservices.acarainservices.orders;

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
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersServices ordersServices;

    @PostMapping
    // public Orders postStudent(@Valid @RequestBody Orders orders, Errors errors) {
    public ResponseEntity<ResponseData<Orders>> postStudent(@Valid @RequestBody Orders orders, Errors errors) {
        ResponseData<Orders> responseData = new ResponseData<>();

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
            List<Orders> value = new ArrayList<>();
            value.add(ordersServices.save(orders));
            responseData.setData(value);
        } catch (Exception e) {
            responseData.setData(null);
            responseData.setResult(false);
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
        }

        return ResponseEntity.ok(responseData);
        // return ordersServices.save(orders);
    }

    @GetMapping
    // public Iterable<Orders> fetchStudent(){
    public ResponseEntity<ResponseData<Orders>> fetchOrders() {
        // return ordersServices.findAll();
        ResponseData<Orders> responseData = new ResponseData<>();
        try {
            Iterable<Orders> values = ordersServices.findAll();
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
    // public Orders fetchStudentById(@PathVariable("id") int id){
    public ResponseEntity<ResponseData<Orders>> fetchStudentById(@PathVariable("id") int id) {
        // return ordersServices.findOne(id);
        ResponseData<Orders> responseData = new ResponseData<>();

        try {
            Orders values = ordersServices.findOne(id);
            List<Orders> result = new ArrayList<>();
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
    // public Orders updateStudent(@RequestBody Orders orders){
    public ResponseEntity<ResponseData<Orders>> updateStudent(@Valid @RequestBody Orders orders, Errors errors) {
        ResponseData<Orders> responseData = new ResponseData<>();

        if (orders.getIdUserOrder() != 0) {

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
                List<Orders> value = new ArrayList<>();
                value.add(ordersServices.save(orders));
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
    public ResponseEntity<ResponseData<Orders>> deleteStudentById(@PathVariable("id") int id) {
        ResponseData<Orders> responseData = new ResponseData<>();
        if (id != 0) {
            try {
                ordersServices.removeOne(id);
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
    public ResponseEntity<ResponseData<Orders>> getOrdersByName(@RequestBody SearchData searchData) {
        ResponseData<Orders> responseData = new ResponseData<>();
        try {
            Iterable<Orders> values = ordersServices.findbyname(searchData.getSearchKey());
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
