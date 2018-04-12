package com.markswell.apirest.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.markswell.apirest.event.RecursoCriadoEvent;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvent recursoCriado) {
		HttpServletResponse response = recursoCriado.getResponse();
		Long codigo = recursoCriado.getCodigo();
		
		adicionarHeadeLocation(response, codigo);
	}

	private void adicionarHeadeLocation(HttpServletResponse response, Long codigo) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(codigo).toUri();
				response.setHeader("Location", uri.toASCIIString());
	}

}
