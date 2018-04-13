package com.markswell.apirest.handlerexception;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.markswell.apirest.handlerexception.ApiRestHendlerExeption.Erro;

@ControllerAdvice
public class ApiRestHendlerExeption extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@Override	
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) { 
		
		String mUser = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
		String mDev = ex.getCause().toString();
		
		List<Erro> listaErros = Arrays.asList(new Erro(mUser, mDev));
		
		return handleExceptionInternal(ex,listaErros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			List<Erro> lista = criarListaErros(ex.getBindingResult());
		return handleExceptionInternal(ex, lista, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> criarListaErros(BindingResult result){
		 List<Erro> erros = new ArrayList<>();
		 for(FieldError fieldError: result.getFieldErrors()) {
			 String mUsuario = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			 
			 erros.add(new Erro(mUsuario, fieldError.toString()));
		 }
		return erros;
	}
	
	@ExceptionHandler({EmptyResultDataAccessException.class})
	public ResponseEntity<Object> handlerEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
		
		String mUser = messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
		String mDev = ex.toString();
		
		List<Erro> listaErros = Arrays.asList(new Erro(mUser, mDev));
		
		return handleExceptionInternal(ex, listaErros, new HttpHeaders(), HttpStatus.NOT_FOUND, request); 
		
	}
	
	public static class Erro {
		private String menssagemusuario;
		private String menssagemdesenvolvedor;
		
		public Erro(String mUsuario, String mDesenvolvedor) {
			this.menssagemusuario = mUsuario;
			this.menssagemdesenvolvedor = mDesenvolvedor;
		}

		public String getMenssagemusuario() {
			return menssagemusuario;
		}

		public String getMenssagemdesenvolvedor() {
			return menssagemdesenvolvedor;
		}
		
				
		
	}

}
