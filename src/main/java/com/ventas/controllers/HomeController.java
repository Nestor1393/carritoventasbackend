package com.ventas.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.ventas.Service.*;
import com.ventas.entities.*;
import com.ventas.repository.StateRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.management.ObjectName;
import java.util.List;
import java.util.Optional;

@Controller
//
@SessionAttributes({"persona"})
public class HomeController {

    @Autowired
    private IStateService iStateService;
    @Autowired
    private ICityService iCityService;
    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IPersonService iPersonService;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private  ICustomerService iCustomerService;

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private ISupplierService iSupplierService;

    @Autowired
    HttpSession session;


    @GetMapping("/")
    public String home(Model model) {

        String vista = "";

        if (session.getAttribute("persona") != null) {

            List<Supplier> proveedores = iSupplierService.encontrarTodosLosProveedores();
            List<Category> categorias = iCategoryService.encontrarTodasLasCategorias();
            List<Object[]> clientesCompletos = iCustomerService.encontrarTodosLosClientesCompletos();
            List<Object[]> rolUsuarioRelacion = iRoleService.encontrarRolUsuarioRelacion();
            List<Object[]> usuariosCompletos = iUserService.consultarUsuariosCompletos();
            List<Object[]> rolesUsuario = iRoleService.encontrarRolesUsuarios();
            List<Object[]> ciudadesDirecciones = iCityService.encontrarCiudadDirecciones();
            List<Object[]> estadosDirecciones = iStateService.encontrarEstadosDirecciones();
            List<State> estados = iStateService.listarAllState();
            List<City> ciudades = iCityService.listarAllCity();
            List<Role> roles = iRoleService.encontrarTodosLosRoles();

            model.addAttribute("proveedores", proveedores);
            model.addAttribute("categorias", categorias);
            model.addAttribute("clientesCompletos", clientesCompletos);
            model.addAttribute("rolUsuarioRelacion",rolUsuarioRelacion);
            model.addAttribute("usuariosCompletos",usuariosCompletos);
            model.addAttribute("rolesUsuario",rolesUsuario);
            model.addAttribute("ciudadesDirecciones", ciudadesDirecciones);
            model.addAttribute("estadosDirecciones",estadosDirecciones);
            model.addAttribute("estados", estados);
            model.addAttribute("ciudades", ciudades);
            model.addAttribute("roles", roles);

            vista = "registros";

        } else {
            model.addAttribute("usuario", new User());
            vista = "login";
        }
        return vista;
    }

    @GetMapping({"/login"})
    public String mostrarAccesos(Model model) {

        String vista = "";

        if (session.getAttribute("persona") != null) {

            List<Supplier> proveedores = iSupplierService.encontrarTodosLosProveedores();
            List<Category> categorias = iCategoryService.encontrarTodasLasCategorias();
            List<Object[]> clientesCompletos = iCustomerService.encontrarTodosLosClientesCompletos();
            List<Object[]> rolUsuarioRelacion = iRoleService.encontrarRolUsuarioRelacion();
            List<Object[]> usuariosCompletos = iUserService.consultarUsuariosCompletos();
            List<Object[]> rolesUsuario = iRoleService.encontrarRolesUsuarios();
            List<Object[]> ciudadesDirecciones = iCityService.encontrarCiudadDirecciones();
            List<Object[]> estadosDirecciones = iStateService.encontrarEstadosDirecciones();
            List<State> estados = iStateService.listarAllState();
            List<City> ciudades = iCityService.listarAllCity();
            List<Role> roles = iRoleService.encontrarTodosLosRoles();

            model.addAttribute("proveedores", proveedores);
            model.addAttribute("categorias", categorias);
            model.addAttribute("clientesCompletos", clientesCompletos);
            model.addAttribute("rolUsuarioRelacion",rolUsuarioRelacion);
            model.addAttribute("usuariosCompletos",usuariosCompletos);
            model.addAttribute("rolesUsuario",rolesUsuario);
            model.addAttribute("ciudadesDirecciones", ciudadesDirecciones);
            model.addAttribute("estadosDirecciones",estadosDirecciones);
            model.addAttribute("estados", estados);
            model.addAttribute("ciudades", ciudades);
            model.addAttribute("roles", roles);

            vista = "registros";
        } else {
            vista = "redirect:/";
        }
        return vista;
    }

    @PostMapping("/login")
    public String mostrarRegistros(Model model, User user) {

        String usuario = user.getUser_name();
        String password = user.getPassword();
        String vista = "";

        Optional<Long> id_persona = iUserService.encontrarPersonaPorUsuario(usuario, password);

        if (id_persona.isPresent()) {

            Long personaId = id_persona.get();

            Optional<Person> persona = iPersonService.encontrarPersonPorId(personaId);

            if (persona.isPresent()) {
                Person personaEncontrada = persona.get();
                session.setAttribute("persona", personaEncontrada);
            }

            List<Supplier> proveedores = iSupplierService.encontrarTodosLosProveedores();
            List<Category> categorias = iCategoryService.encontrarTodasLasCategorias();
            List<Object[]> clientesCompletos = iCustomerService.encontrarTodosLosClientesCompletos();
            List<Object[]> rolUsuarioRelacion = iRoleService.encontrarRolUsuarioRelacion();
            List<Object[]> usuariosCompletos = iUserService.consultarUsuariosCompletos();
            List<Object[]> rolesUsuario = iRoleService.encontrarRolesUsuarios();
            List<Object[]> ciudadesDirecciones = iCityService.encontrarCiudadDirecciones();
            List<Object[]> estadosDirecciones = iStateService.encontrarEstadosDirecciones();
            List<State> estados = iStateService.listarAllState();
            List<City> ciudades = iCityService.listarAllCity();
            List<Role> roles = iRoleService.encontrarTodosLosRoles();

            model.addAttribute("proveedores", proveedores);
            model.addAttribute("categorias", categorias);
            model.addAttribute("clientesCompletos", clientesCompletos);
            model.addAttribute("rolUsuarioRelacion",rolUsuarioRelacion);
            model.addAttribute("usuariosCompletos",usuariosCompletos);
            model.addAttribute("rolesUsuario",rolesUsuario);
            model.addAttribute("ciudadesDirecciones", ciudadesDirecciones);
            model.addAttribute("estadosDirecciones",estadosDirecciones);
            model.addAttribute("estados", estados);
            model.addAttribute("ciudades", ciudades);
            model.addAttribute("roles", roles);

            vista = "registros";

        } else {
            model.addAttribute("error", "El usuario y la contraseña no existen o son erroneos");
            home(model);
            vista = "login";
        }

        return vista;
    }

    @GetMapping("/logout")
    public String cerrarSesion(Model model) {

        session.setAttribute("persona", null);
        //session.invalidate();
        home(model);

        return "login";
    }


}
