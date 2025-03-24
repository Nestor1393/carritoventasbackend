package com.ventas.Service;

import com.ventas.entities.Address;
import com.ventas.entities.State;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IStateService {

    List<State> listarAllState();
    State  guardarState(State state);
    Optional<State> encontrarStatePorId(Long id);
    void eliminarState(State state);
    List<Object[]> encontrarEstadosDirecciones();


}
