import br.com.Idespair.dao.IProductDao;
import br.com.Idespair.dao.ProductDao;
import br.com.Idespair.domain.Product;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ProductTest {

    private IProductDao productDao;

    public ProductTest(){
        productDao = new ProductDao();
    }

    @Test
    public void RegisterTest(){
        Product prod = new Product();

        prod.setName("Milk");
        prod.setManufacturer("Parmalat");
        prod.setPrice(5.50);
        prod = productDao.register(prod);

        assertNotNull(prod);
        assertNotNull(prod.getId());
    }

}
