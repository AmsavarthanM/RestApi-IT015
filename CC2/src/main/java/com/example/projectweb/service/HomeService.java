package com.example.projectweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.projectweb.model.Home;
// import com.example.projectweb.model.User;
import com.example.projectweb.repository.HomeRepo;
// import com.example.projectweb.repository.UserRepo;

@Service
public class HomeService {
    @Autowired
    HomeRepo hr;
    public Home add(Home h)
    {
        return hr.save(h);
    }
    public List<Home> get()
    {
        return hr.findAll();
    }
    public Optional<Home> getbyid(int id)
    {
        return hr.findById(id);
    }

    public Home put(int id,Home h)
    {
        Home homeValid=hr.findById(id).orElse(null);
        if(homeValid!=null)
        {
            homeValid.setServiceName(h.getServiceName());
            homeValid.setServicePrice(h.getServicePrice());
            homeValid.setDescription(h.getDescription());
            
            return hr.saveAndFlush(homeValid);
        }
        else
        return null;
    }
    
    public String del(int id)
    {
        hr.deleteById(id);
        return("Service Data Removed Succesfully");
    }

   public List<Home> pagination(int pageno,int pagesize){
    Pageable page=PageRequest.of(pageno, pagesize);
    return hr.findAll(page).getContent();
   }

   public List<Home>  sorting(String medicineBrand){
        Sort sort=Sort.by(Sort.Direction.ASC,medicineBrand);
        return hr.findAll(sort);
}


public List<Home>PageandSort(int pageno,int pagesize,String field)
    {
        return hr.findAll(PageRequest.of(pageno,pagesize).withSort(Sort.Direction.ASC,field)).getContent();
}

}