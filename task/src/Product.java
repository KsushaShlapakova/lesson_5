public class Product {
    private String name;
    private int price;
    private String supplier;

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setSupplier(String supplier){
        this.supplier = supplier;
    }

    public String toString(){
        return name + ", " + price;
    }
}
