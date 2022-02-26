package com.ventas.Ventas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VentasApplication {

//	private static final Logger logger= LoggerFactory.getLogger(VentasApplication.class);

	public static void main(String[] args) {
//		logger.trace("Este es un mensaje de rastreo");
//		logger.debug("Este es un mensaje de depuracion");
//		logger.info("Este es un mensaje de informacion");
//		logger.warn("Este es un mensaje de advertencia");
//		logger.error("Este es un mensaje de error");
		SpringApplication.run(VentasApplication.class, args);
	}

}
