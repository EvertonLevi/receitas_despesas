package com.webservice.msi.resource;

import java.util.Optional;
import java.util.List;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.webservice.msi.repository.ContaRepository;
import com.webservice.msi.repository.LancamentoRepository;
import com.webservice.msi.repository.UsuarioRepository;
import com.webservice.msi.service.JwtUserDetailsService;
import com.webservice.msi.config.JwtTokenUtil;
import com.webservice.msi.model.ContaEntity;
import com.webservice.msi.model.JwtRequest;
import com.webservice.msi.model.JwtResponse;
import com.webservice.msi.model.LancamentoEntity;
import com.webservice.msi.model.UsuarioEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.ResourceAccessException;

// @CrossOrigin(origins = "*", allowCredentials = "", allowedHeaders = "*")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class Controller {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired(required = true)
    private AuthenticationManager authenticationManager;

    @Autowired(required = true)
    private JwtTokenUtil jwtTokenUtil;

    @Autowired(required = true)
    private JwtUserDetailsService userDetailsService;

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

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USUÁRIO DESABILITADO", e);
        } catch (BadCredentialsException e) {
            throw new Exception("CREDENCIAIS INVÁLIDAS", e);
        }
    }

    // @GetMapping("/authenticate")
    // public ResponseEntity<List<UsuarioEntity>> createAuthenticationToken() {
    // return new ResponseEntity<List<UsuarioEntity>>(usuarioRepository.findAll(),
    // HttpStatus.OK);
    // }

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

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/testAuth")
    public String TesteAuth() {
        return "Hello World, o teste auth PASSOU";
    }

    // @RequestMapping("/")
    // public ResponseEntity Index(HttpServletResponse response) {
    // HttpHeaders headers = new HttpHeaders();
    // headers.add("Location", "http://localhost:3000/");
    // return new ResponseEntity<>(headers, HttpStatus.FOUND);
    // }
    // TODO LOGIN POR REQUEST

    // gerar token no signin (front)
    // Login POST (user, senha)
    // findByUser
    // if senha == user.senha do banco
    // return token
    // token no localstorage
}