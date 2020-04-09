package com.webservice.msi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin quando for usar o front

@RestController
@RequestMapping("/helloW")
public class HW {

    // ainda n usar @Autowired

    @GetMapping
    public String HW() {
        return "Hello World";
    }

    @GetMapping("/createUser")
    public String dsda() {
        return "Create";
    }

}