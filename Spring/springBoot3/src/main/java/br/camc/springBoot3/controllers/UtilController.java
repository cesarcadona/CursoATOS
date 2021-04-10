package br.camc.springBoot3.controllers;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "Swagger2RestController", description = "Rest APIs exercicios 1-3")
@RestController
@RequestMapping("/util")
public class UtilController {
	
	@ApiOperation(value= "Retorna a data e a hora atual", response = Iterable.class, tags = "utils")
	@GetMapping("/TimeNow")
	public String getTimeNow() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date();
		return formatter.format(date);
	}
	
	@ApiOperation(value= "Recebe a temperatura em fahrenheit e retorne em celsius ", response = Iterable.class, tags = "utils")
	@PostMapping("/{temperature}")
	public float convertFahrenheitToCelsius(float temperature) {
		return (temperature-32)/1.8f;
	}
	
	
	@ApiOperation(value= "Recebe um número e retorne se este é par ou impar", response = Iterable.class, tags = "utils")
	@PostMapping("/{number}")
	public boolean isNumberPair(float number) {
		return number%2==0;
	}
	
	
		

}
