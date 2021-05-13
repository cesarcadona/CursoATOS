package br.camc.ProjetoFinalFull.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.camc.ProjetoFinalFull.services.CustomUserDetailsService;
import br.camc.ProjetoFinalFull.utils.JwtUtil;


@Component
public class JwtFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private CustomUserDetailsService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizatonHeader = request.getHeader("Authorization");
		
		String token = null;
		String username = null;
		
		if(authorizatonHeader != null && authorizatonHeader.startsWith("Bearer ")) {
			token = authorizatonHeader.substring(7);
			username = jwtUtil.extractUsername(token);
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = service.loadUserByUsername(username);
			if(jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usToken);
			}
			
		}
		filterChain.doFilter(request, response);
	}
	

}
