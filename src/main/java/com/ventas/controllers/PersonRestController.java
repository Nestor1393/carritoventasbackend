package com.ventas.controllers;

import com.ventas.DTO.PersonDTO;
import com.ventas.Service.ICustomerService;
import com.ventas.Service.IPersonService;
import com.ventas.Service.IUserService;
import com.ventas.entities.Address;
import com.ventas.entities.Person;
import com.ventas.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class PersonRestController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IPersonService iPersonService;

    @GetMapping("consultar/usuario/completo")
    public List<Object[]> consultarUsuarioCompleto(@RequestParam("idUsuario") Long idUsuario){

        return iUserService.consultarUsuarioCompleto(idUsuario);
    }

    @GetMapping("consultar/cliente/completo")
    public List<Object[]> consultarClienteCompleto(@RequestParam("idUsuario") Long idUsuario){

        return iUserService.consultarClienteCompleto(idUsuario);
    }


    @CrossOrigin(origins = {"http://localhost:3000/", "https://5a87-2806-2f0-a300-ffe8-60bf-c0c-e5fa-7fd9.ngrok-free.app"})
    @PostMapping("guardar/usuario/facebook")
        public Long guardarUsuarioDeFacebook(@RequestBody Map<String, Object> facebookData){

        String facebook_id = (String) facebookData.get("id");
        Optional<Person> persona = iPersonService.findByIdFacebook(facebook_id);
        Long idPersona = null;
        if(persona.isPresent()){
            idPersona = persona.get().getId_person();

        }else{
            String first_name = (String) facebookData.get("first_name");
            String last_name = (String) facebookData.get("last_name");
            Address direccion = new Address();
            direccion.setId_address(3L);

            Person personaFacebook = new Person();
            personaFacebook.setIdFacebook(facebook_id);
            personaFacebook.setFirst_name(first_name);
            personaFacebook.setLast_name(last_name);
            personaFacebook.setEmail("facebook@gmail.com");
            personaFacebook.setBirthdate(LocalDate.now());
            personaFacebook.setId_address(direccion);

            Person personaGuardada = null;
           personaGuardada = iPersonService.guardarPersona(personaFacebook);

           User usuario = new User();
           usuario.setUser_name("usuario"+facebook_id);
           usuario.setPassword("password"+facebook_id);
           usuario.setId_person(personaGuardada);

           iUserService.guardarUsuario(usuario);

           if(personaGuardada != null){
               idPersona = personaGuardada.getId_person();
           }
        }
        return idPersona;
    }

    @CrossOrigin(origins = {"http://localhost:3000/", "https://5a87-2806-2f0-a300-ffe8-60bf-c0c-e5fa-7fd9.ngrok-free.app"})
    @PostMapping("guardar/usuario/google")
    public Long guardarUsuarioDeGoogle(@RequestBody Map<String, Object> googleData){

        String google_id =  googleData.get("nbf")+"";
        Optional<Person> persona = iPersonService.findByIdGoogle(google_id);
        Long idPersona = null;
        if(persona.isPresent()){
            idPersona = persona.get().getId_person();

        }else{
            String first_name = (String) googleData.get("given_name");
            String last_name = (String) googleData.get("family_name");
            String email = (String) googleData.get("email");
            Address direccion = new Address();
            direccion.setId_address(3L);

            Person personaGoogle = new Person();
            personaGoogle.setIdGoogle(google_id);
            personaGoogle.setFirst_name(first_name);
            personaGoogle.setLast_name(last_name);
            personaGoogle.setEmail(email);
            personaGoogle.setBirthdate(LocalDate.now());
            personaGoogle.setId_address(direccion);

            Person personaGuardada = null;
            personaGuardada = iPersonService.guardarPersona(personaGoogle);

            User usuario = new User();
            usuario.setUser_name(email);
            usuario.setPassword("password"+google_id);
            usuario.setId_person(personaGuardada);

            iUserService.guardarUsuario(usuario);

            if(personaGuardada != null){
                idPersona = personaGuardada.getId_person();
            }
        }
        return idPersona;
    }


    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("consultar/usuarios/mas/ventas")
    public List<Object[]> consultarUsuariosConMasVentas(){

        return iUserService.consultarUsuariosConMasVentas();
    }
}
