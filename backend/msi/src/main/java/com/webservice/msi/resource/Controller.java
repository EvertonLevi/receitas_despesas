package com.webservice.msi.resource;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.webservice.msi.repository.LancamentoRepository;
import com.webservice.msi.repository.UsuarioRepository;
import com.webservice.msi.model.LancamentoEntity;
import com.webservice.msi.model.UsuarioEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<UsuarioEntity> Get() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/createUser")
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

    @PostMapping("/postLancamento")
    public String postLancamento(@Valid @RequestBody LancamentoEntity lancamentoEntity) {
        LancamentoEntity entity = new LancamentoEntity();
        try {
            entity.setDescricao(lancamentoEntity.getDescricao());
            entity.setValor(lancamentoEntity.getValor());
            entity.setData_de_lancamento(lancamentoEntity.getData_de_lancamento().now());

            lancamentoRepository.save(entity);
            return entity.toString();
        } catch (Exception e) {
            return "Erro no método postLancamento(): " + e.getMessage();
        }
    }

    @DeleteMapping("/deleteLancamento/{id}")
    public void deleteLancamento(@PathVariable Long id) {
        lancamentoRepository.deleteById(id);
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