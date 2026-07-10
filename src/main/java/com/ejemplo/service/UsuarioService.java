package com.ejemplo.service;

import com.ejemplo.model.Usuario;
import com.ejemplo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    // Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }
    
    // Obtener usuario por ID
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }
    
    // Obtener usuario por email
    public Optional<Usuario> obtenerPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
    
    // Buscar usuarios por nombre
    public List<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    // Guardar usuario
    public Usuario guardar(Usuario usuario) {
        // Validar que no exista email duplicado
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El email ya existe en la base de datos");
        }
        return usuarioRepository.save(usuario);
    }
    
    // Actualizar usuario
    public Usuario actualizar(Long id, Usuario usuarioActualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        
        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            
            // Actualizar solo los campos que no sean nulos
            if (usuarioActualizado.getNombre() != null) {
                usuario.setNombre(usuarioActualizado.getNombre());
            }
            if (usuarioActualizado.getEmail() != null) {
                usuario.setEmail(usuarioActualizado.getEmail());
            }
            if (usuarioActualizado.getTelefono() != null) {
                usuario.setTelefono(usuarioActualizado.getTelefono());
            }
            
            return usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("Usuario con ID " + id + " no encontrado");
        }
    }
    
    // Eliminar usuario
    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario con ID " + id + " no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
    
    // Contar total de usuarios
    public long contarUsuarios() {
        return usuarioRepository.count();
    }
}