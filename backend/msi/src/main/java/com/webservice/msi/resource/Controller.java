package com.webservice.msi.resource;

import java.util.Optional;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import com.webservice.msi.repository.ContaRepository;
import com.webservice.msi.repository.LancamentoRepository;
import com.webservice.msi.repository.UsuarioRepository;

import com.webservice.msi.model.ContaEntity;
import com.webservice.msi.model.LancamentoEntity;
import com.webservice.msi.model.UsuarioEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.ResourceAccessException;

@CrossOrigin(origins = "*", allowCredentials = "")
@RestController
public class Controller {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    // @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    // public List<UsuarioEntity> Get() {
    // return usuarioRepository.findAll();
    // }

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

    @GetMapping("/getUser")
    public ResponseEntity<List<UsuarioEntity>> getUsuario() {
        return new ResponseEntity<List<UsuarioEntity>>(usuarioRepository.findAll(), HttpStatus.OK);
    }


    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

    @PostMapping("/postLancamento/{usuario_id}")
    public String postLancamento(@PathVariable(value = "usuario_id") Long usuarioId,
            @Valid @RequestBody LancamentoEntity lancamentoEntity) {
        try {
            Optional<UsuarioEntity> optional = usuarioRepository.findById(usuarioId);
            UsuarioEntity usuarioEntity = optional.get();
            // TODO a hora está settando com outro fuso
            // lancamentoEntity.setData_de_lancamento(lancamentoEntity.getData_de_lancamento().now());
            lancamentoEntity.setUsuarioEntity(usuarioEntity);
            lancamentoRepository.save(lancamentoEntity);
            return usuarioEntity.toString();
        } catch (

        Exception e) {
            return "Erro no método postLancamento(): " + e.getMessage();
        }
    }

    @PutMapping("/putLancamento/{id}")
    public String putLancamento(@PathVariable(value = "id") Long lancamentoId,
            @Valid @RequestBody LancamentoEntity lancamentoEntity) {
        try {
            LancamentoEntity lancamento = lancamentoRepository.findById(lancamentoId)
                    .orElseThrow(() -> new ResourceAccessException("Id não encontrado " + lancamentoId));

            lancamento.setData_de_lancamento(lancamentoEntity.getData_de_lancamento().now());
            lancamento.setDescricao(lancamentoEntity.getDescricao());
            lancamento.setValor(lancamentoEntity.getValor());
            lancamento.setUsuarioEntity(lancamento.getUsuarioEntity());

            lancamentoRepository.save(lancamento);
            return lancamentoEntity.toString();
        } catch (Exception e) {
            return "Erro no método putLancamento(): " + e.getMessage();
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

}