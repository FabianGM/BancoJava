package com.example.demo.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsuarioJpaRepositoryTest {
    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerUsuarios() {
        ArrayList<UsuarioModel> usuarios = (ArrayList<UsuarioModel>) usuarioRepository.findAll();
        assertNotNull(usuarios);
    }

    @Test
    public void guardarUsuario() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNombre("Pablo Mena");
        usuario.setDireccion("Quito");
        usuario.setTelefono(Integer.valueOf(982800451));
        usuario.setClave("741852");
        usuario.setEstado(true);
        usuarioRepository.save(usuario);
    }

    // Prueba del método obtenerPorId
    @Test
    public void testObtenerPorId() {
        Long id = 1L;
        UsuarioModel usuario = new UsuarioModel();
        usuario.setUsuarioId(id);
        usuario.setNombre("John Doe");

        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));

        Optional<UsuarioModel> resultado = usuarioService.obtenerPorId(id);

        assertTrue(resultado.isPresent());
        assertEquals(usuario, resultado.get());
    }

    // Prueba del método actualizarUsuario
    @Test
    public void testActualizarUsuario() {
        Long id = 1L;
        UsuarioModel usuarioExistente = new UsuarioModel();
        usuarioExistente.setUsuarioId(id);
        usuarioExistente.setNombre("John Doe");

        UsuarioModel usuarioActualizado = new UsuarioModel();
        usuarioActualizado.setNombre("Jane Smith");

        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuarioExistente));
        when(usuarioRepository.save(usuarioExistente)).thenReturn(usuarioExistente);

        UsuarioModel resultado = usuarioService.actualizarUsuario(id, usuarioActualizado);

        assertNotNull(resultado);
        assertEquals(usuarioActualizado.getNombre(), resultado.getNombre());
    }

    // Prueba del método eliminarUsuario
    @Test
    public void testEliminarUsuario() {
        Long id = 1L;

        // Simulamos que el usuario existe en la base de datos
        doNothing().when(usuarioRepository).deleteById(id);

        boolean resultado = usuarioService.eliminarUsuario(id);

        assertTrue(resultado);
    }
}