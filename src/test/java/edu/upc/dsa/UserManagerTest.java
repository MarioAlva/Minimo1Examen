package edu.upc.dsa;

import edu.upc.dsa.models.Object;
import edu.upc.dsa.models.User;
import org.junit.Test;
import org.junit.Before;
import java.util.List;
import org.apache.log4j.Logger;

public class UserManagerTest {
    final static Logger log = Logger.getLogger(UserManagerTest.class);
    UserManager um;
    @Before
    public void addUsers() {
        um=UserManagerImpl.getInstance();
        log.info("Registro de usuarios");
        um.Registro("oiram99", "Mario", "Alva Howes", "mario@test.com", "test");
        um.Registro("oiram989", "Ma8rio", "A88lva Howes", "mario@test.com", "t88est");
        um.Registro("pepe99", "Pepe", "Gonzalez Rodriguez", "pepe@test.com", "test");
        um.Registro("juan99", "Juan", "Baco Jimenez", "juan@test.com", "test");
        um.Registro("nadia99", "Nadia", "Bacarro tello", "nadia@test.com", "test");
        um.Registro("repetido", "Nadia", "Alva Howes", "testrepeticion@test.com", "test");
        log.info("===================================");
        log.info("Añadir objetos");
        um.addObject("Espada", "Es una espada", 5);
        um.addObject("Espada", "Es una espada", 445);
        um.addObject("Escudo", "Es un escudo", 50);
    }

    @Test
        public void testuser(){
        log.info("===================================");
        log.info("Usuarios registrados ordenados alfabeticamente");
        List<User> u = um.usuariosregistadosordenador();
        log.info("===================================");
        log.info("Login de usuarios");
        User usuario1 = um.Login("mario@test.com", "test");
        User usuario2 = um.Login("mario@test.com", "testeo");
        log.info("===================================");
        List<Object> o = um.objetosordenadosporprecio();
        log.info("Usuario compra objetos");
        um.comprarobjeto("oiram99", "Espada");
        um.comprarobjeto("oiram99", "Escudo");
        log.info("===================================");
        log.info("Objetos que tiene un usuario");
        um.listadoobjetosusuario("oiram99");
    }
}