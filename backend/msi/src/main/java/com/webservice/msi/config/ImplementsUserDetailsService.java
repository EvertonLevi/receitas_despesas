package com.webservice.msi.config;

import javax.transaction.Transactional;

import com.webservice.msi.model.UsuarioEntity;
import com.webservice.msi.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {
 @Autowired
 private UsuarioRepository ur;

 @Override
 public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
  UsuarioEntity usuario = ur.findByEmail(email);

  if (usuario == null) {
   throw new UsernameNotFoundException("Usuario não encontrado!");
  }
  return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
 }
}