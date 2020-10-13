public interface ProductBuilder {
    Product build();
    ProductBuilder name(String name);
    ProductBuilder price(int price);
    ProductBuilder supplier(String supplier);
}
