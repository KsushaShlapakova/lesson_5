public class ProductBuilderImpl implements ProductBuilder {

    private Product product;

    ProductBuilderImpl(){
        product = new Product();
    }

    @Override
    public Product build() {
        return product;
    }

    @Override
    public ProductBuilder name(String name) {
        product.setName(name);
        return this;
    }

    @Override
    public ProductBuilder price(int price) {
        product.setPrice(price);
        return this;
    }

    @Override
    public ProductBuilder supplier(String supplier) {
        product.setSupplier(supplier);
        return this;
    }
}
