import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Market {
    Random random = new Random();

    Vector<Product> products = new Vector<>();

    List<String> suppliers = Arrays.asList("X", "Y", "Z");
    List<String> names = Arrays.asList("Кровать", "Подушка", "Очень дорогой кофе", "Сонник");

    public void produce() throws InterruptedException{
        while (true) {
            synchronized (this){

                while (products.size() == 5) {
                    System.out.println("Корзина переполнена");
                    wait();
                }

                ProductBuilder builder = new ProductBuilderImpl();
                Product newProduct = builder
                        .name(names.get(random.nextInt(names.size())))
                        .price(random.nextInt(900) + 100)
                        .supplier(suppliers.get(random.nextInt(suppliers.size())))
                        .build();

                products.add(newProduct);


                System.out.println("Произведен товар: " + newProduct);
                System.out.println("Все товары: " + products);

                notify();

                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException
    {
        while (true) {
            synchronized (this) {

                while (products.size() == 0){
                    System.out.println("Корзина пуста");
                    wait();
                }

                Product choose = products.get(random.nextInt(products.size()));
                products.remove(choose);

                System.out.println("Клиент купил: " + choose);

                notify();

                int sleep = random.nextInt(900) + 100;

                Thread.sleep(sleep);
            }
        }
    }
}
