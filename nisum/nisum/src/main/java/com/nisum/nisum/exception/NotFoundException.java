package com.nisum.nisum.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String mensaje;

	public NotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public NotFoundException(String mensaje) {
		this.mensaje = mensaje;
	}

}
