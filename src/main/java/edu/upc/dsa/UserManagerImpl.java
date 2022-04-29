package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Object;
import org.apache.log4j.Logger;

import java.util.*;

public class UserManagerImpl implements UserManager {

    private static UserManager instance;

    //private Queue<OrderTO> orderQueue;
    protected List<User> usuariosregistrados ;
    protected List<Object> objetosglobales ;
    final static Logger logger = Logger.getLogger(UserManagerImpl.class);

    private UserManagerImpl() {
        this.usuariosregistrados = new LinkedList<>();
        this.objetosglobales = new LinkedList<>();
    }

    public static UserManager getInstance() {
        if (instance==null) instance = new UserManagerImpl();
        return instance;
    }

    @Override
    public List<User> usuariosregistadosordenador() {
        Collections.sort(this.usuariosregistrados, new Comparator<User>() {
            public int compare(User u1, User u2) {
                if(u1.getSurnames() == u2.getSurnames())
                    return u1.getName().compareTo(u2.getName());
                else
                return u1.getSurnames().compareTo(u2.getSurnames());
            }
        });
        for(User user: usuariosregistrados)
            logger.info(user.getSurnames() + " " + user.getName());
        return this.usuariosregistrados;
    }

    @Override
    public List<Object> objetosordenadosporprecio() {
        Collections.sort(this.objetosglobales, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                return Double.compare(o2.getCoins(), o1.getCoins());
            }
        });
        logger.info("Ordenado de mayor a menor precio:");
        for(Object o:this.objetosglobales)
            logger.info(o.getNombre() + " " + o.getCoins());
        logger.info("===================================");
        return this.objetosglobales;
    }

    @Override
    public void comprarobjeto(String id, String nombre) {
        User user;
        Object object = null;
        for (Object o: objetosglobales){
            if(o.getNombre() == nombre)
                object = o;
        }
        for(User u: usuariosregistrados){
            if(u.getid() == id) {
                if (object.getCoins()>u.getCoins())
                    logger.error("No tienes suficientes monedas");
                else {
                    u.setCoins(u.getCoins() - object.getCoins());
                    u.addobject(object);
                    logger.info("Has comprado: " + nombre);
                }
            }
        }
    }

    @Override
    public void addObject(String nombre, String descripcion, int coins) {
        this.addObject(new Object(nombre, descripcion, coins));
    }

   /* @Override
    public List<Object> listadoobjetosusuario(String iduser) {
        for(User u: usuariosregistrados){
            if(u.getid()==iduser) {
                for(Object o: u.getO())
                    logger.info(o.getNombre());
                return u.getO();
            }
        }
        return null;
    }*/
    @Override
    public List<Object> listadoobjetosusuario(String iduser) {
        for(User u: usuariosregistrados){
            if(u.getid()==iduser) {
                for(Object o: u.getO())
                    logger.info(o.getNombre());
                return u.getO();
            }
        }
        return null;
    }
    public void addObject(Object o) {
        Boolean existe = false;
        int i = 0;
        for(Object object: objetosglobales) {
            if (object.getNombre() == o.getNombre()) {
                logger.error("Este objeto ya esta en la tienda");
                existe = true;
            }
        }
        if(!existe){
            this.objetosglobales.add(o);
            logger.info(o.getNombre() + " ha sido añadido con exito");
        }
    }

    public void addUser(User u) {
        Boolean existe = false;
        int i = 0;
        for(User user: usuariosregistrados) {
            if (user.getEmail() == u.getEmail()) {
                logger.error("Este email ya ha sido registrado");
                existe = true;
            }
        }
        if(!existe){
                this.usuariosregistrados.add(u);
                logger.info(u.getName() + " " + u.getSurnames() + " ha sido registrado con exito");
            }
    }
    @Override
    public void Registro(String id, String nombre, String apellidos, String email, String password) {
        this.addUser(new User(id, nombre, apellidos, email, password, 50));
    }

    @Override
    public User Login(String email, String password) {
        for(User user: usuariosregistrados){
            if(user.getEmail() == email && user.getPassword() == password){
                logger.info("Te has conectado con exito");
                return user;
            }
        }
        logger.error("Email o password incorrectos");
        return null;
    }

    @Override
    public int size() {
        return 0;
    }


}
