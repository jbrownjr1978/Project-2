import junit.framework.TestCase;
import org.example.Model.Product;
import org.example.Service.ProductService;
import org.example.Service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import java.util.List;
import org.example.Exception.ProductException;
import org.example.Controller.TvController;


public class ProductServiceTest {

    ProductService productService;
    SellerService sellerService;

    @Before
    public void setUp() {
        productService = new ProductService(sellerService);
    }


    @Test
    public void accntServiceEmptyAtStart() {
        List<Product> productList = productService.getProductList();
        Assert.assertTrue(productList.size() == 0);
    }
    @Test
    /* public void productServiceAddAccnt()throws ProductException {
//        arrange
        double testPrice = 245.13;
        String testProductName = "television";
        String testSellerName = "Jerry";
//        act
                //        assert
        List<Product> products = productService.getProductList();
        productList.addProduct(testPrice, testProductName, testSellerName);
//        I'm expecting a single account in the list - at index 0
        Product actual = products.get(0);
        Assert.assertEquals(testPrice, actual.getPrice());
        Assert.assertEquals(testProductName, actual.getProductName());
        Assert.assertEquals(testSellerName, actual.getSellerName());
    }





}
