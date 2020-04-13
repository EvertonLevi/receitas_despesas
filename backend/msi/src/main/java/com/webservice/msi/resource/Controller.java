package com.webservice.msi.resource;

import java.util.List;
 
import javax.validation.Valid;

import com.webservice.msi.repository.UsuarioRepository;
import com.webservice.msi.model.UsuarioEntity;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public String createUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity) {
        UsuarioEntity entity = new UsuarioEntity();
        try {
            entity.setNome(usuarioEntity.getNome());
            entity.setEmail(usuarioEntity.getEmail());
            entity.setSenha(usuarioEntity.getSenha());
            usuarioRepository.save(entity);

            return entity.toString();
        } catch (Exception e) {
            return "Erro no CreateUser: " + e.getMessage();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
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