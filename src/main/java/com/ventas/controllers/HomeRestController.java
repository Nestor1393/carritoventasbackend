package com.ventas.controllers;

import com.ventas.DTO.PersonDTO;
import com.ventas.Service.IPersonService;
import com.ventas.Service.IUserService;
import com.ventas.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
public class HomeRestController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IPersonService iPersonService;

   /* @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(value = "/iniciar/sesion", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> mostrarProductos(Model model, @RequestBody Map<String, String> body) {

        String usuario = body.get("usuario");
        String contrasena = body.get("contrasena");

        Map<String, Object> respuesta = new HashMap<String, Object>();

        if (usuario == null || contrasena == null) {
            respuesta.put("sesion", null);
            respuesta.put("mensaje", "Usuario y/o contraseña no proporcionados");

            //BAD_REQUEST para entradas inválidas.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
        }

        Optional<Long> id_persona = iUserService.encontrarPersonaPorUsuario(usuario, contrasena);

        if (id_persona.isPresent()) {

            Long personaId = id_persona.get();

            Optional<Person> persona = iPersonService.encontrarPersonPorId(personaId);

            if (persona.isPresent()) {
                Person personaEncontrada = persona.get();
                respuesta.put("sesion", personaEncontrada);
                respuesta.put("mensaje", "Inicio de sesión exitoso");
                return ResponseEntity.ok(respuesta);
            } else {
                respuesta.put("sesion", null);
                respuesta.put("mensaje", "No se pudo encontrar la persona con el ID proporcionado");

                //INTERNAL_SERVER_ERROR para errores inesperados al buscar la persona por ID.
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
            }

        } else {
            respuesta.put("sesion", null);
            respuesta.put("mensaje", "El usuario y la contraseña no existen o son erróneos");

            //UNAUTHORIZED para credenciales incorrectas.
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(respuesta);
        }
    }
    */

    @CrossOrigin(origins = {"http://localhost:3000/","https://carritoventasfrontend-production.up.railway.app"})
    @RequestMapping(value = "/iniciar/sesion", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> mostrarProductos(Model model, @RequestBody Map<String, String> body) {
        Map<String, Object> respuesta = new HashMap<>();

        try {
            String usuario = body.get("usuario");
            String contrasena = body.get("contrasena");

            Optional<Long> id_persona = iUserService.encontrarPersonaPorUsuario(usuario, contrasena);

            if (id_persona.isPresent()) {
                Long personaId = id_persona.get();
                Object[] persona = iPersonService.encontrarPersonDtoPorId(personaId).get(0);

                PersonDTO personaEncontrada = new PersonDTO();

                if (persona != null) {

                    personaEncontrada.setId_person((Long) persona[0]);
                    personaEncontrada.setBirthdate(((java.sql.Date) persona[1]).toLocalDate());
                    personaEncontrada.setEmail((String) persona[2]);
                    personaEncontrada.setFirst_name((String) persona[3]);
                    personaEncontrada.setLast_name((String) persona[4]);

                    respuesta.put("sesion", personaEncontrada);
                    respuesta.put("mensaje", "Inicio de sesión exitoso");

                } else {
                    respuesta.put("sesion", null);
                    respuesta.put("mensaje", "La persona no fue encontrada");
                }
            } else {
                respuesta.put("sesion", null);
                respuesta.put("mensaje", "El usuario y la contraseña no existen o son erróneos");
            }

            return ResponseEntity.ok(respuesta);

        } catch (Exception e) {
            // Manejar cualquier excepción inesperada
            System.err.println("Error en el proceso de inicio de sesión: " + e.getMessage());
            e.printStackTrace();

            // Devolver una respuesta de error adecuada
            respuesta.put("sesion", null);
            respuesta.put("mensaje", "Ocurrió un error en el servidor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }
}
