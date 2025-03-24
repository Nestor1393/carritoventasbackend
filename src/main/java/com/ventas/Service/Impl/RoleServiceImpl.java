package com.ventas.Service.Impl;

import com.ventas.Service.IRoleService;
import com.ventas.entities.Role;
import com.ventas.repository.RoleRepository;
import org.aspectj.weaver.patterns.VoidArrayFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role guardarRol(Role role) {
       return roleRepository.save(role);
    }

    @Override
    public void eliminarRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> encontrarRolePorId(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> encontrarTodosLosRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public List<Object[]> encontrarRolesUsuarios() {
        return roleRepository.encontrarRolesUsuarios();
    }

    @Override
    public List<Object[]> encontrarRolUsuarioRelacion() {
        return roleRepository.encontrarRolUsuarioRelacion();
    }

    @Override
    public List<Object[]> consultarRolesPorUsuarioEdit(Long id_user) {
        return roleRepository.consultarRolesPorUsuarioEdit(id_user);
    }


}
