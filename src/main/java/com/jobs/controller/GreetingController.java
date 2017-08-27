package com.jobs.controller;

import com.jobs.entity.Customer;
import com.jobs.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Wan on 2017/8/20.
 */
@Controller
public class GreetingController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        List<Customer> peoples = customerRepository.findByLastName("huan");
        System.out.println(peoples.get(0) + "..." + peoples.get(1));
        model.addAttribute("name", name);
        model.addAttribute("pipi", peoples.get(0));
        return "greeting";
    }

}
