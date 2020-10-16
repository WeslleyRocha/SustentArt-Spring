package com.sustentart.SustentArt.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sustentart.SustentArt.model.Usuario;
import com.sustentart.SustentArt.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		Optional<Usuario> user = userRepository.findByEmail(email);
		user.orElseThrow(()-> new UsernameNotFoundException(email + "Not Found."));
		
		return user.map(UserDetailsImpl::new).get();
	}
	
}
