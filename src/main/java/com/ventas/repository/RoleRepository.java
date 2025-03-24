package com.ventas.repository;

import com.ventas.entities.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query(value = "select role.*, count(user_role.id_user) as usuarios from role left join user_role on role.id_role = user_role.id_role group by  role.id_role;", nativeQuery = true)
    List<Object[]> encontrarRolesUsuarios();

    @Query(value = "SELECT * FROM user_role;", nativeQuery = true)
    List<Object[]> encontrarRolUsuarioRelacion();

    @Query(value = "select user_role.id_role from user_role where user_role.id_user = :id_user", nativeQuery = true)
    List<Object[]> consultarRolesPorUsuarioEdit(@Param("id_user") Long id_user);




}
