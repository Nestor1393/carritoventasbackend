package com.ventas.controllers;

import com.ventas.Service.*;
import com.ventas.entities.*;
import com.ventas.repository.StateRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
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
    private IProductService iProductService;



    @PostMapping("guardar/producto/")
    public String guardarProducto(Model model, HttpServletRequest request){

        String nombreProducto = request.getParameter("nombreProducto");
        String precioProducto = request.getParameter("precioProducto");
        String stockProducto = request.getParameter("stockProducto");
        String codigoProducto = request.getParameter("codigoProducto");
        String proveedorProducto = request.getParameter("proveedorProducto");
        String descripcionProducto = request.getParameter("descripcionProducto");
        String categoriaProducto = request.getParameter("categoriaProducto");

        Product producto = new Product();

        producto.setProduct_name(nombreProducto);
        producto.setPrice(Double.parseDouble(precioProducto));
        producto.setStock(Integer.parseInt(stockProducto));
        producto.setProduct_code(codigoProducto);
        Optional<Supplier> proveedor = iSupplierService.encontrarProveedorPorId(Long.parseLong(proveedorProducto));
        if(proveedor.isPresent()){
            producto.setId_supplier(proveedor.get());
        }
        producto.setDescription(descripcionProducto);

        Product productoGuardado = null;
        productoGuardado = iProductService.guardarProducto(producto);

        if(productoGuardado != null){
            model.addAttribute("success", "El Producto se registró correctamente");
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
