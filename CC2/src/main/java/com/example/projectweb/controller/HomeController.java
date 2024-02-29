package com.example.projectweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectweb.model.Home;
import com.example.projectweb.service.HomeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HomeController {
    
    @Autowired
    HomeService hs;
    @PostMapping("/addservice")
    public ResponseEntity<Home> postMethod(@RequestBody Home h) {
        return new ResponseEntity<>(hs.add(h),HttpStatus.CREATED);
    }

    @GetMapping("/getservice")
    public ResponseEntity<List<Home>> getMethod() {
        return new ResponseEntity<>(hs.get(),HttpStatus.OK);
    }
    
    @GetMapping("/getservice/{serviceId}")
    public ResponseEntity<Optional<Home>> getMethodById(@PathVariable int serviceId) {
        return new ResponseEntity<>(hs.getbyid(serviceId),HttpStatus.OK);
    }
    
    @PutMapping("putservice/{serviceId}")
    public Home putMethod(@PathVariable int serviceId, @RequestBody Home h) {
        return hs.put(serviceId,h);
    }
    @DeleteMapping("/deleteservice/{serviceId}")
    public String detMethod(@PathVariable int serviceId)
    {
        return hs.del(serviceId);
    }


    @GetMapping("/pagination/{pageno}/{pagesize}")
    public List<Home> getPagination(@PathVariable int pageno,@PathVariable int pagesize ){
        return hs.pagination(pageno, pagesize);
    }
    @GetMapping("/sorting/{field}")
    public List<Home> getSorting(@PathVariable String field ){
        return hs.sorting(field);
}

     @GetMapping("/pagesort/{pageno}/{pagesize}/{field}")
         public List<Home> getMethodName(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String field) {
             return hs.PageandSort(pageno, pagesize,field);
     }
}
