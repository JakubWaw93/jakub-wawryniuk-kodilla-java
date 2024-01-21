package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    ProductDao productDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Potatoes");
        Product product2 = new Product("Tomatoes");
        Item item1 = new Item(product1, new BigDecimal(10.9), 2, new BigDecimal(2));
        Item item2 = new Item(product1, new BigDecimal(20), 4, new BigDecimal(0.5));
        Item item3 = new Item(product2, new BigDecimal(34), 3, new BigDecimal(6));
        product1.getItems().add(item1);
        product1.getItems().add(item2);
        product2.getItems().add(item3);
        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product2);
        Invoice invoice = new Invoice("12323523");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);


        //When

        /*invoiceDao.save(invoice);
        int id = invoice.getId();
        productDao.save(product1);
        int idProduct1 = product1.getId();
        productDao.save(product2);
        int idProduct2 = product2.getId();
        itemDao.save(item1);
        int idItem1 = item1.getId();
        itemDao.save(item2);
        int idItem2 = item2.getId();
        itemDao.save(item3);
        int idItem3 = item3.getId();
        System.out.println("This id = " + id);
        //Then
        assertNotEquals(0, id);

        //CleanUp
        try {
            productDao.deleteById(idProduct1);
            productDao.deleteById(idProduct2);
            itemDao.deleteById(idItem1);
            itemDao.deleteById(idItem2);
            itemDao.deleteById(idItem3);
            invoiceDao.deleteById(id);
        } catch (Exception e) {
            //do nothing
        }*/

    }

}
