package com.webservice.msi.resource;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import com.webservice.msi.repository.ContaRepository;
import com.webservice.msi.repository.LancamentoRepository;
import com.webservice.msi.repository.UsuarioRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import com.webservice.msi.model.ContaEntity;
import com.webservice.msi.model.LancamentoEntity;
import com.webservice.msi.model.UsuarioEntity;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
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

import javassist.NotFoundException;

// @CrossOrigin quando for usar o front
// @CrossOrigin(origins = "*", allowCredentials = "*")
@RestController
public class Controller {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<UsuarioEntity> Get() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/createUser")
    public String createUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity, ContaEntity contaEntity) {
        try {
            contaEntity = new ContaEntity(contaEntity.getId(), "Descrição default da conta");
            contaRepository.save(contaEntity);
            usuarioEntity.setIdContaUsuario(contaEntity);
            usuarioRepository.save(usuarioEntity);

            return usuarioEntity.toString();
        } catch (Exception e) {
            return "Erro no CreateUser: " + e.getMessage();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    } 

    @PostMapping("/postLancamento/{usuario_id}")
    public String postLancamento(
        @PathVariable(value = "usuario_id") Long usuario_id,
     @Valid @RequestBody LancamentoEntity lancamentoEntity,
            UsuarioEntity usuarioEntity) {
        try {
            usuarioEntity = new UsuarioEntity();
            usuarioEntity.setId(usuario_id);
            lancamentoEntity = new LancamentoEntity();
            // usuarioEntity.getId(); 
            usuarioRepository.save(usuarioEntity);
            
            lancamentoEntity.setUsuarioEntity(usuarioEntity);
            // lancamentoEntity.setData_de_lancamento(lancamentoEntity.getData_de_lancamento().now());
            // lancamentoEntity.setDescricao(lancamentoEntity.getDescricao());
            // lancamentoEntity.setValor(lancamentoEntity.getValor());
            lancamentoRepository.save(lancamentoEntity);
            return usuarioEntity.toString();
        } catch (

        Exception e) {
            return "Erro no método postLancamento(): " + e.getMessage();
        }
    }

    @DeleteMapping("/deleteLancamento/{id}")
    public void deleteLancamento(@PathVariable Long id) {
        lancamentoRepository.deleteById(id);
    }

    @PostMapping("/createConta")
    public String createConta(@Valid @RequestBody ContaEntity contaEntity, UsuarioEntity usuarioEntity) {
        LancamentoEntity entity = new LancamentoEntity();
        try {
            // entity.setDescricao(lancamentoEntity.getDescricao());
            // entity.setValor(lancamentoEntity.getValor());

            // lancamentoRepository.save(entity);
            return entity.toString();
        } catch (Exception e) {
            return "Erro no método createConta(): " + e.getMessage();
        }
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