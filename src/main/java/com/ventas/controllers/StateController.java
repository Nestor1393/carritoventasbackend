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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {

    @Autowired
    private IStateService iStateService;
    @Autowired
    private ICityService iCityService;
    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ISupplierService iSupplierService;

    @Autowired
    private ICategoryService iCategoryService;

    @PostMapping("/guardar/estado")
    public String guardarEstado(Model model, HttpServletRequest request, RedirectAttributes attributes) {

        String idEstado = request.getParameter("idEstado");
        String nombreEstado = request.getParameter("nombreEstado");

        State state = new State();
        if (Long.parseLong(idEstado) != 0) {
            state.setId_state(Long.parseLong(idEstado));
        }
        state.setState_name(nombreEstado);

        State estadoGuardado = null;
        estadoGuardado = iStateService.guardarState(state);

        if (estadoGuardado != null) {

            if (Long.parseLong(idEstado) == 0) {
                model.addAttribute("success", "El estado se registró correctamente");
            }

            if (Long.parseLong(idEstado) != 0) {
                model.addAttribute("success", "El estado se actualizó correctamente");
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
        model.addAttribute("rolesUsuario",rolesUsuario);
        model.addAttribute("ciudadesDirecciones", ciudadesDirecciones);
        model.addAttribute("estadosDirecciones",estadosDirecciones);
        model.addAttribute("estados", estados);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("roles", roles);

        return "registros";
    }

    @GetMapping("/eliminar/estado/{idEstado}")
    public String eliminarEstado(@PathVariable("idEstado") Long idEstado, Model model) {

        State state = new State();
        state.setId_state(idEstado);

        iStateService.eliminarState(state);

       Optional<State> estadoConsultado = iStateService.encontrarStatePorId(idEstado);

        if(estadoConsultado.isEmpty()){
            model.addAttribute("success", "El estado fue eliminado correctamente");

        }else if(estadoConsultado.isPresent()){
            model.addAttribute("success", "El estado no fue eliminado");
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

        return "registros";
    }

}
