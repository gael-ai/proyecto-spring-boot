package com.ejemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoSpringApplication.class, args);
        System.out.println("\n===============================================");
        System.out.println("✅ Aplicación Spring Boot iniciada correctamente");
        System.out.println("📍 URL: http://localhost:8080");
        System.out.println("📍 API Usuarios: http://localhost:8080/api/usuarios");
        System.out.println("===============================================\n");
    }
}