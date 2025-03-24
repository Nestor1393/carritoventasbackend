package com.ventas.controllers;


import com.ventas.Service.*;
import com.ventas.entities.*;
import com.ventas.repository.StateRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {
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
    private ISupplierService iSupplierService;
    @Autowired
    private ICategoryService iCategoryService;



    @PostMapping("/guardar/proveedor")
    public String registrarProveedor(Model model, HttpServletRequest request){

        String nombreProveedor = request.getParameter("nombreProveedor");
        String categoriaProducto = request.getParameter("categoriaProducto");

        Optional<Category> categoryEncontrada = iCategoryService.encontrarCategoriaPorId(Long.parseLong(categoriaProducto));
        Supplier proveedor =  new Supplier();
        if(categoryEncontrada.isPresent()){
            proveedor.setId_category(categoryEncontrada.get());
        }
        proveedor.setSupplier_name(nombreProveedor);

        Supplier proveedorGuardado = null;
       proveedorGuardado = iSupplierService.guardarProveedor(proveedor);

       if(proveedorGuardado != null){

           model.addAttribute("success", "El proveedor se registró correctamente");
       }else{
           model.addAttribute("success", "El proveedor no pudo ser registrado");
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
