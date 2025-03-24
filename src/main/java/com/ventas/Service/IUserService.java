package com.ventas.Service;

import com.ventas.entities.User;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User guardarUsuario(User user);

    void eliminarUser(Long id);

    Optional<User> encontrarUserPorId(Long id);

    List<User> encontrarTodosLosUsuarios();

    Optional<Long> encontrarPersonaPorUsuario(String user_name, String password);

    List<Object[]> consultarUsuariosCompletos();

    Optional<Long> encontrarUsuarioPorDireccion(Long id_address);

    List<Object[]> consultarUsuarioCompleto(Long id_usuario);

    List<Object[]> consultarClienteCompleto(Long id_usuario);

    Optional<Long> consultarUsuarioPorIdPersona(Long idPersona);

    List<Object[]> consultarUsuariosConMasVentas();
}
