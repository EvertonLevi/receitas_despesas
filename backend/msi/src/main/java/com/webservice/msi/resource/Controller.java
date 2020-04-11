package com.webservice.msi.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.webservice.msi.repository.UsuarioRepository;
import com.webservice.msi.model.UsuarioEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin quando for usar o front

// @CrossOrigin(origins = "*", allowCredentials = "*")
@RestController
public class Controller {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<UsuarioEntity> Get() {
        return usuarioRepository.findAll();
    }

    // @PostMapping
    @RequestMapping(value = "/createUsuario", method = RequestMethod.POST)
    public UsuarioEntity createUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
        // return usuarioEntity.save(usuarioEntity);
    }

    @GetMapping
    public String Controller() {
        return "Hello World";
    }

    @GetMapping("/createUser")
    public String dsda() {
        return "Create";
    }

}