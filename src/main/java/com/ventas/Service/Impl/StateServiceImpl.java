package com.ventas.Service.Impl;

import com.ventas.Service.IStateService;
import com.ventas.entities.State;
import com.ventas.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StateServiceImpl implements IStateService {

@Autowired
private StateRepository stateRepository;

    @Override
    public List<State> listarAllState() {
        return (List<State>) stateRepository.findAll();

    }
    @Override
    public State guardarState(State state) {
       return stateRepository.save(state);
    }

    @Override
    public Optional<State> encontrarStatePorId(Long id) {
        return stateRepository.findById(id);
    }

    @Override
    public void eliminarState(State state) {
        stateRepository.delete(state);
    }

    @Override
    public List<Object[]> encontrarEstadosDirecciones() {
        return stateRepository.encontrarEstadosDirecciones();
    }
}
