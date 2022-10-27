package mx.edu.utez.examenunitwo.model.clothes;

import mx.edu.utez.examenunitwo.model.Repository;
import mx.edu.utez.examenunitwo.model.clothes.categories.BeanCategoria;
import mx.edu.utez.examenunitwo.model.clothes.clothe_types.BeanTipoRopa;
import mx.edu.utez.examenunitwo.utils.MySQLConnection;
import mx.edu.utez.examenunitwo.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoRopa implements Repository<BeanRopa>{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();

    @Override
    public List<BeanRopa> findAll() {
        List<BeanRopa> prendas = new ArrayList<>();
        BeanRopa ropa = null;
        BeanCategoria categoria = null;
        BeanTipoRopa tipoRopa = null;
        try {
            conn = client.getConnection();
            String query = "SELECT cl.*, ca.name, cy.name FROM clothes cl JOIN categories ca JOIN clothe_types cy" +
                    "ON ca.id = cl.category_id ON cy.id = cl.cloth_type;";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                ropa.setId(rs.getLong("id"));
                ropa.setName(rs.getString("name"));
                ropa.setPrice(rs.getDouble("price"));
                ropa.setBrand(rs.getString("brand"));
                ropa.setStock(rs.getInt("stock"));
                ropa.setCloth_type(rs.getString("closth_type"));
                ropa.setStatus(rs.getInt("status"));
                tipoRopa.setName(rs.getString("name"));
                categoria.setName(rs.getString("name"));
                ropa.setTipoRopa(tipoRopa);
                ropa.setCategoria(categoria);
                prendas.add(ropa);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoRopa.class.getName())
                    .log(Level.SEVERE, "Error -> find"+ e.getMessage());
        } finally {
            client.close(conn,ps,rs);
        }
        return prendas;
    }
    @Override
    public Response<BeanRopa> save(BeanRopa ropa) {
        try {
            conn = client.getConnection();
            String query = "INSERT INTO clothes(name,price,size,brand,stock,cloth_type,created_at,status,category_id,clothe_type_id) VALUES (?,?,?,?,?,?,?,?,?,?);";
            ps = conn.prepareStatement(query);
            ps.setString(1,ropa.getName());
            ps.setDouble(2,ropa.getPrice());
            ps.setString(3,ropa.getSize());
            ps.setString(4,ropa.getBrand());
            ps.setInt(5,ropa.getStock());
            ps.setString(6,ropa.getCloth_type());
            ps.setInt(7,ropa.getStatus());
            ps.setLong(8,ropa.get().getId());
            if (ps.executeUpdate()==1){
                return new Response<BeanPersonal>(200,"Registrado correctamente",person,false);
            }else{
                return new Response<>(200,"Error al registrar",person,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPersonal.class.getName())
                    .log(Level.SEVERE,"Error- -> save" + e.getMessage());
            return new Response<>(400, "Error con el servidor",null,true);
        }finally {
            client.close(conn,ps,rs);
        }
    }

    @Override
    public Response<BeanPersonal> update(BeanPersonal object) {
        return null;
    }

    @Override
    public Response<BeanPersonal> remove(Long id) {
        return null;

    }

}
