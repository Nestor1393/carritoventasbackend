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

import java.time.LocalDate;
import java.util.*;


@Controller
public class PersonController {

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
    private IAddressService iAddressService;
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ISupplierService iSupplierService;

    @Autowired
    private ICategoryService iCategoryService;


    @PostMapping("/guardar/persona")
    public String guardarPersona(Model model, HttpServletRequest request) {

        String tipoPersona = request.getParameter("tipoPersona");

        String idDireccion = request.getParameter("idDireccion");
        String idPersona = request.getParameter("idPersona");


        //Address
        String calle = request.getParameter("calleUsuario");
        String numero = request.getParameter("numeroUsuario");
        String colonia = request.getParameter("coloniaUsuario");
        String codigoPostal = request.getParameter("codigoUsuario");
        String ciudad = request.getParameter("ciudadUsuario2");

        Optional<City> city = iCityService.encontrarCityPorId(Long.parseLong(ciudad));
        Address direccion = new Address();

        if (Long.parseLong(idDireccion) != 0) {
            Optional<Address> direccionEncontrada = iAddressService.encontrarAddressPorId(Long.parseLong(idDireccion));
            //direccionEncontrada.ifPresent(address -> direccion.setId_address(address.getId_address()));
            if (direccionEncontrada.isPresent()) {
                direccion.setId_address(direccionEncontrada.get().getId_address());
            }
        }
        direccion.setStreet(calle);
        direccion.setNumber(Integer.parseInt(numero));
        direccion.setLocality(colonia);
        direccion.setPostal_code(Integer.parseInt(codigoPostal));
        if (city.isPresent()) {
            City cd = city.get();
            direccion.setId_city(cd);
        } else {
            System.out.println("La ciudad no existe");
        }
        Address direccionGuardada = null;
        direccionGuardada = iAddressService.guardarAddress(direccion);

        //Person
        String nombre = request.getParameter("nombreUsuario");
        String apellidos = request.getParameter("apellidosUsuario");
        String nacimiento = request.getParameter("nacimientoUsuario");
        String correo = request.getParameter("emailUsuario");

        Person persona = new Person();

        if (Long.parseLong(idPersona) != 0) {
            Optional<Person> personaEncontrada = iPersonService.encontrarPersonPorId(Long.parseLong(idPersona));
            if (personaEncontrada.isPresent()) {
                persona.setId_person(personaEncontrada.get().getId_person());
            }
        }

        persona.setFirst_name(nombre);
        persona.setLast_name(apellidos);
        persona.setBirthdate(LocalDate.parse(nacimiento));
        persona.setEmail(correo);
        persona.setId_address(direccionGuardada);

        Person personaGuardada = null;
        personaGuardada = iPersonService.guardarPersona(persona);

        if (Integer.parseInt(tipoPersona) == 1) {

            //User
            String usuario = request.getParameter("userUsuario");
            String password = request.getParameter("passwordUsuario");

            String idUsuario = request.getParameter("idUsuario");


            String[] roles = null;
            if(Long.parseLong(idUsuario) == 0){
                roles = request.getParameterValues("roleUsuario");
            }else if(Long.parseLong(idUsuario) != 0){
                roles = request.getParameterValues("role_usuario");
            }

            Set<Optional<Role>> rolesCosultados = new HashSet<>();
            for (String rol : roles) {
                Optional<Role> rol1 = iRoleService.encontrarRolePorId(Long.parseLong(rol));
                rolesCosultados.add(rol1);
            }

            User user = new User();

            if (Long.parseLong(idUsuario) != 0) {
                Optional<User> usuarioEncontrado = iUserService.encontrarUserPorId(Long.parseLong(idUsuario));
                if (usuarioEncontrado.isPresent()) {
                    user.setId_user(usuarioEncontrado.get().getId_user());
                }
            }

            user.setUser_name(usuario);
            user.setPassword(password);
            user.setId_person(personaGuardada);

            Set<Role> rolesObtenidos = new HashSet<>();
            for (Optional<Role> rolConsultado : rolesCosultados) {
                if (rolConsultado.isPresent()) {
                    rolesObtenidos.add(rolConsultado.get());
                }
            }
            user.setRoles(rolesObtenidos);

            User userGuardado = null;
            userGuardado = iUserService.guardarUsuario(user);


            if (direccionGuardada != null && personaGuardada != null && userGuardado != null && Long.parseLong(idUsuario) == 0) {
                model.addAttribute("success", "El usuario se registró correctamente");

            } else if (direccionGuardada != null && personaGuardada != null && userGuardado != null && Long.parseLong(idUsuario) != 0) {
                model.addAttribute("success", "El usuario se actualizó correctamente");
            }

        } else if (Integer.parseInt(tipoPersona) == 2) {

            String idCliente = request.getParameter("idUsuario");

            Customer customer = new Customer();

            if (Long.parseLong(idCliente) != 0) {

                Optional<Customer> clienteEncontrado = iCustomerService.encontrarCustomerPorId(Long.parseLong(idCliente));
                if (clienteEncontrado.isPresent()) {
                    customer.setId_person(clienteEncontrado.get().getId_person());
                }
            }

            customer.setId_person(personaGuardada);

            Customer clienteGuardado = null;
            clienteGuardado = iCustomerService.guardarCustomer(customer);

            if (direccionGuardada != null && personaGuardada != null && clienteGuardado != null && Long.parseLong(idCliente) == 0) {
                model.addAttribute("success", "El cliente se registró correctamente");
            } else if (direccionGuardada != null && personaGuardada != null && clienteGuardado != null && Long.parseLong(idCliente) != 0) {
                model.addAttribute("success", "El cliente se actualizó correctamente");
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
        model.addAttribute("rolUsuarioRelacion", rolUsuarioRelacion);
        model.addAttribute("usuariosCompletos", usuariosCompletos);
        model.addAttribute("rolesUsuario", rolesUsuario);
        model.addAttribute("ciudadesDirecciones", ciudadesDirecciones);
        model.addAttribute("estadosDirecciones", estadosDirecciones);
        model.addAttribute("estados", estados);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("roles", roles);

        return "registros";

    }


    @GetMapping("/eliminar/persona/{idDireccion}")
    public String eliminarUsuario(Model model, @PathVariable Long idDireccion) {

        //

        int tipoPersona = 0;
        Optional<Long> usuarioPorDireccion = iUserService.encontrarUsuarioPorDireccion(idDireccion);

        if (usuarioPorDireccion.isPresent()) {
            tipoPersona = 1;
        }

        iAddressService.eliminarAddress(idDireccion);

        Optional<Address> direccionEncontrada = iAddressService.encontrarAddressPorId(idDireccion);

        if (direccionEncontrada.isEmpty()) {
            if(tipoPersona == 1){
                model.addAttribute("success", "El usuario se eliminó correctamente");
            }else if(tipoPersona == 0){
                model.addAttribute("success", "El cliente se eliminó correctamente");
            }

        } else {
            model.addAttribute("success", " El usuario no fue eliminado");
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
        model.addAttribute("rolUsuarioRelacion", rolUsuarioRelacion);
        model.addAttribute("usuariosCompletos", usuariosCompletos);
        model.addAttribute("rolesUsuario", rolesUsuario);
        model.addAttribute("ciudadesDirecciones", ciudadesDirecciones);
        model.addAttribute("estadosDirecciones", estadosDirecciones);
        model.addAttribute("estados", estados);
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("roles", roles);

        return "registros";
    }
}
