package com.ventas.controllers;

import com.ventas.Service.*;
import com.ventas.entities.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RoleController {
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private IStateService iStateService;
    @Autowired
    private ICityService iCityService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ISupplierService iSupplierService;

    @Autowired
    private ICategoryService iCategoryService;

    @PostMapping("/guardar/rol")
    public String guardarRol(Model model, HttpServletRequest request) {

        String idRol = request.getParameter("idRol");
        String nombreRole = request.getParameter("nombreRol");

        Role role = new Role();
        if (Long.parseLong(idRol) != 0) {
            role.setId_role(Long.parseLong(idRol));
        }
        role.setRole_name(nombreRole);

        Role rolGuardado = null;
        rolGuardado = iRoleService.guardarRol(role);

        if (rolGuardado != null) {

            if (Long.parseLong(idRol) != 0) {
                model.addAttribute("success", "El rol se actualizó correctamente");
            } else if (Long.parseLong(idRol) == 0) {
                model.addAttribute("success", "El rol se registró correctamente");
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
        model.addAttribute("estadosDirecciones", estadosDirecciones);
        model.addAttribute("estados", estados);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("roles", roles);

        return "registros";
    }

    @GetMapping("/eliminar/role/{idRole}")
    public String eliminarRol(Model model, @PathVariable Long idRole){

        iRoleService.eliminarRole(idRole);

        Optional<Role> rolBuscado = iRoleService.encontrarRolePorId(idRole);
        if(rolBuscado.isEmpty()){
            model.addAttribute("success", "el Rol fue eliminado correctamente");
        }else{
            model.addAttribute("success", "el no pudo ser eliminado");
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
        model.addAttribute("estadosDirecciones", estadosDirecciones);
        model.addAttribute("estados", estados);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("roles", roles);

        return "registros";
    }

//Metodo que consulta todos los roles para el formulario de editar usuario, devuelve una List<Role> por medio del metodo findAll de JPA.
    @GetMapping("/consultar/todos/roles")
    @ResponseBody
    public List<Object[]> consultarTodosLosRoles() {

      return iRoleService.encontrarRolesUsuarios();
    }

    @GetMapping("/consultar/roles/usuarioEdit")
    @ResponseBody
    List<Object[]> consultarRolesPorUsuarioEdit(@RequestParam("id_user") Long id_user){

        return  iRoleService.consultarRolesPorUsuarioEdit(id_user);
    }
}
