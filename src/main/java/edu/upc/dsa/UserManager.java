package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Object;

import java.util.List;

public interface UserManager {

    public List<User> usuariosregistadosordenador();
    public List<Object> objetosordenadosporprecio();
    public void comprarobjeto(String id, String nombre);
    public void addObject(String nombre, String descripcion, int coins);
    //public List<Product> ordenarlistaProductos();
    //public List<ProdCantTO> ListaProdCant();
    //public void deliverOrder();
    public List<Object> listadoobjetosusuario(String iduser);
    public void Registro(String id, String nombre, String apellidos, String email, String password);
    public User Login(String email, String password);
    //public void addProdCantTO(String o,int u);

    //public List<Product> getListProductsBySells();

    //public List<OrderTO> listaOrderporUsuario(String ID);

    public int size();
}