import java.util.Date;

public class products {

    int id;
    String description;
    String brand;
    int stock;
    double purchaseprice;
    double salesprice;
    Boolean active;
    Date dateCreate;

    public products (){};

    public products(int id, String description, int stock, double salesprice) {
        this.id = id;
        this.description = description;
        this.stock = stock;
        this.salesprice = salesprice;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPurchaseprice(double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public void setSalesprice(double salesprice) {
        this.salesprice = salesprice;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public int getStock() {
        return stock;
    }

    public double getPurchaseprice() {
        return purchaseprice;
    }

    public double getSalesprice() {
        return salesprice;
    }

    public Boolean getActive() {
        return active;
    }

    public Date getDateCreate() {
        return dateCreate;
    }
}