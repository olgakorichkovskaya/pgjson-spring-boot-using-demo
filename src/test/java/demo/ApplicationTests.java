package demo;

import demo.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    private ProductService service;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testProductCrud() throws Exception {
        Product product = new Product();
        Custom custom = new Custom();
        String customName = "New customName";
        custom.setName(customName);
        product.setCustom(custom);

        service.save(product);

        Product saved = service.findAll().iterator().next();
        Assert.assertNotNull(saved);
        Custom customSaved = saved.getCustom();
        Assert.assertEquals(customName, customSaved.getName());
        System.out.println(" " + customSaved.getName());

        List<Price> prices = new ArrayList<>();
        prices.add(new Price(20, "Dollar"));
        prices.add(new Price(15, "Euro"));
        customSaved.setPriceList(prices);

        service.save(saved);

        saved = service.findAll().iterator().next();
        Assert.assertEquals(2, saved.getCustom().getPriceList().size());
        Assert.assertEquals(15, saved.getCustom().getPriceList().get(1).getAmount(), 0.001);
    }

//    @Test
    public void testJsonHashMap() throws Exception {
        Product product = new Product();
        Custom custom = new Custom();
        product.setCustom(custom);
        HashMap<String, Custom> map = new HashMap<>();
        map.put("Name 1", new Custom("Custom 1"));
        map.put("Name 2", new Custom("Custom 2"));
        product.setNamedCustoms(map);

        service.save(product);
        product = service.findAll().iterator().next();
        HashMap<String, Custom> named = product.getNamedCustoms();
        Assert.assertTrue(named.containsKey("Name 1"));
        Assert.assertTrue(named.containsKey("Name 2"));
    }
}
