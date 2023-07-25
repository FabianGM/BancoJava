package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios() {
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel actualizarUsuario(Long id, UsuarioModel usuarioActualizado) {
        Optional<UsuarioModel> usuarioExistenteOpcional = usuarioRepository.findById(id);
        if (usuarioExistenteOpcional.isPresent()) {
            UsuarioModel usuarioExistente = usuarioExistenteOpcional.get();
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
            usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
            usuarioExistente.setClave(usuarioActualizado.getClave());
            usuarioExistente.setEstado(usuarioActualizado.isEstado());

            return usuarioRepository.save(usuarioExistente);
        } else {
            return null;
        }
    }

    public boolean eliminarUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}