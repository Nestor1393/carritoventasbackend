package com.ventas.controllers;

import com.ventas.Service.*;
import com.ventas.entities.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CityController {

    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private ICityService iCityService;
    @Autowired
    private IStateService iStateService;
    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ISupplierService iSupplierService;

    @Autowired
    private ICategoryService iCategoryService;

    @PostMapping("/guardar/ciudad")
    public String guardarCiudad(Model model, HttpServletRequest request) {

        String idCiudad = request.getParameter("idCiudad");
        String ciudad = request.getParameter("nombreCiudad");
        String estadoId = request.getParameter("listaEstados");

        City city = new City();

        if (Long.parseLong(idCiudad) != 0) {
            Optional<City> ciudadBuscada = iCityService.encontrarCityPorId(Long.parseLong(idCiudad));
            city.setId_city(ciudadBuscada.get().getId_city());
        }

        Optional<State> estado = iStateService.encontrarStatePorId(Long.parseLong(estadoId));

        if (estado.isPresent()) {
            city.setId_state(estado.get());
        }
        city.setCity_name(ciudad);

        City ciudadGuardada = null;
        ciudadGuardada = iCityService.guardarCity(city);

        if (ciudadGuardada != null) {

            if (Long.parseLong(idCiudad) == 0) {
                model.addAttribute("success", "La Ciudad se registró correctamente");
            }

            if (Long.parseLong(idCiudad) != 0) {
                model.addAttribute("success", "La Ciudad se actualizó correctamente");
            }
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
        model.addAttribute("rolesUsuario", rolesUsuario);
        model.addAttribute("ciudadesDirecciones", ciudadesDirecciones);
        model.addAttribute("estadosDirecciones", estadosDirecciones);
        model.addAttribute("estados", estados);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("roles", roles);

        return "registros";
    }


    @GetMapping("/eliminar/ciudad/{idCiudad}")
    public String eliminarCiudad(Model model, @PathVariable Long idCiudad) {

        iCityService.eliminarCiudad(idCiudad);

        Optional<City> ciudadBuscada = iCityService.encontrarCityPorId(idCiudad);

        if (ciudadBuscada.isEmpty()) {
            model.addAttribute("success", "La Ciudad se eliminó correctamente");
        } else {
            model.addAttribute("success", "La Ciudad no se pudo eliminar");
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
        model.addAttribute("rolesUsuario", rolesUsuario);
        model.addAttribute("ciudadesDirecciones", ciudadesDirecciones);
        model.addAttribute("estadosDirecciones", estadosDirecciones);
        model.addAttribute("estados", estados);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("roles", roles);

        return "registros";
    }

}