package com.qiang.chapter2.test;

/**
 * Created by liq on 2018/3/15.
 */

import com.qiang.chapter2.helper.DatabaseHelper;
import com.qiang.chapter2.model.Customer;
import com.qiang.chapter2.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CustomerService单元测试
 */
public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    @Before
    public void init() throws IOException {
        //初始化测试数据库
        DatabaseHelper.executeSqlFile("sql/customer.init.sql");
    }

    @Test
    public void getCustomerListTest(){
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2,customerList.size());
    }
    @Test
    public  void getCustomerTest(){
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNull(customer);
    }
    @Test
    public void createCustomerTest(){
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("name", "customer100");
        fieldMap.put("contact", "John");
        fieldMap.put("telephone", "13333333333");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }
    @Test
    public void updateCustomerTest(){
        long id = 1;
        Map<String,Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("contact", "Eric");
        boolean result = customerService.updateCustomer(id,fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest(){
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
