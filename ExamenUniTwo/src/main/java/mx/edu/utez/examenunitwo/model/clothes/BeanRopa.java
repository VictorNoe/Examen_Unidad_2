package mx.edu.utez.examenunitwo.model.clothes;

import mx.edu.utez.examenunitwo.model.clothes.categories.BeanCategoria;
import mx.edu.utez.examenunitwo.model.clothes.clothe_types.BeanTipoRopa;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanRopa {
    Long id;
    String name;
    double price;
    String size;
    String brand;
    int stock;
    String date;
    BeanTipoRopa tipoRopa;
    int status;
    BeanCategoria categoria;
    String cloth_type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCloth_type() {
        return cloth_type;
    }

    public void setCloth_type(String cloth_type) {
        this.cloth_type = cloth_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BeanTipoRopa getTipoRopa() {
        return tipoRopa;
    }

    public void setTipoRopa(BeanTipoRopa tipoRopa) {
        this.tipoRopa = tipoRopa;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BeanCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(BeanCategoria categoria) {
        this.categoria = categoria;
    }
}
