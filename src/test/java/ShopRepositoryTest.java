import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(56, "Книга", 1200);
    Product product2 = new Product(8, "Майка", 2000);
    Product product3 = new Product(107, "Монитор", 15000);

    //Задание 1
    @Test
    public void shouldRemoveByID() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product2, product3};
        Product[] actuale = repo.removeById(56);

        Assertions.assertArrayEquals(expected, actuale);
    }

    @Test
    public void NotFoundException() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(0);
        });
    }

    //Задание 2
    @Test
    public void shouldAddToArray() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);

        Product[] expected = {product1};
        Product[] actuale = repo.findAll();

        Assertions.assertArrayEquals(expected, actuale);
    }

    @Test
    public void AlreadyExistsException() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product1);
        });
    }
}
