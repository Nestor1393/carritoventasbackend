package com.ventas.Service.Impl;

import com.ventas.Service.IUserService;
import com.ventas.entities.User;
import com.ventas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserServiceImpl implements IUserService {

   // @Autowired
   // private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User guardarUsuario(User user) {

        return userRepository.save(user);
    }

    @Override
    public void eliminarUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> encontrarUserPorId(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> encontrarTodosLosUsuarios() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<Long> encontrarPersonaPorUsuario(String user_name, String password) {
        return userRepository.encontrarPersonaPorUsuario(user_name, password);
    }

    @Override
    public List<Object[]> consultarUsuariosCompletos() {
        return userRepository.consultarUsuariosCompletos();
    }

    @Override
    public Optional<Long> encontrarUsuarioPorDireccion(Long id_address) {
        return userRepository.encontrarUsuarioPorDireccion(id_address);
    }

    @Override
    public List<Object[]> consultarUsuarioCompleto(Long idUsuario) {
        return userRepository.consultarUsuarioCompleto(idUsuario);
    }

    @Override
    public List<Object[]> consultarClienteCompleto(Long idUsuario) {
        return userRepository.consultarClienteCompleto(idUsuario);
    }

    @Override
    public Optional<Long> consultarUsuarioPorIdPersona(Long idPersona) {
        return userRepository.consultarUsuarioPorIdPersona(idPersona);
    }

    @Override
    public List<Object[]> consultarUsuariosConMasVentas() {
        return userRepository.consultarUsuariosConMasVentas();
    }


}
