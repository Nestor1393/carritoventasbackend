package com.ventas.Service;

import com.ventas.entities.Role;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IRoleService {

    Role guardarRol(Role role);

    void eliminarRole(Long id);

    Optional<Role> encontrarRolePorId(Long id);

    List<Role> encontrarTodosLosRoles();

    List<Object[]> encontrarRolesUsuarios();

    List<Object[]> encontrarRolUsuarioRelacion();

    List<Object[]> consultarRolesPorUsuarioEdit(Long id_user);
}
