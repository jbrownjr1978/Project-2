import junit.framework.TestCase;
import org.example.Model.Product;
import org.example.Service.ProductService;
import org.example.Service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import java.util.List;
import org.example.Exception.ProductException;


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
    public void accntServiceAddAccnt() throws ProductException {
//        arrange
        double price = 245.13;
        String productName = "television";
        String sellerName = "Jerry";
//        act
        try {
            productService.addProduct(price, productName, sellerName);
        } catch (ProductException x) {
//            if the accntexception is thrown fail the test
            x.printStackTrace();
            Assert.fail("account exception incorrectly thrown");
        }
//        assert
        List<Product> accnts = ProductService.getproductList();
//        I'm expecting a single account in the list - at index 0
        Product actual = accnts.get(0);
        Assert.assertEquals(price, actual.getPrice());
        Assert.assertEquals(productName, actual.getProductName());
        Assert.assertEquals(sellerName, actual.getSellerName());
    }





}
