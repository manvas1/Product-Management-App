import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Optional<Product> getProduct(String name){
        return  products.stream().filter( p -> p.getName().equalsIgnoreCase(name)).findFirst();
    }

    public Stream<Product> getProductWithText(String text) {
        return  products.stream().
                filter(p -> p.getName().toLowerCase().contains(text.toLowerCase())
        || p.getPlace().toLowerCase().contains(text.toLowerCase())
        || p.getType().toLowerCase().contains(text.toLowerCase()));

    }

    public Stream<Product> getProductByPlace(String place){
        return products.stream().
                filter( p -> p.getPlace().equalsIgnoreCase(place));
    }

    public Stream<Product> getOutOfWarrantyProducts(){
        return products.stream().filter(p -> p.getWarranty() < 2023);
    }
}
