package com.qiang.chapter2.service;

import com.qiang.chapter2.helper.DatabaseHelper;
import com.qiang.chapter2.model.Customer;
import com.qiang.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by liq on 2018/3/15.
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取客户列表
     *
     * @param
     * @return
     */
    public List<Customer> getCustomerList() {
        /*Connection conn = null;
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        try {
            conn = DatabaseHelper.getConnection();
            String sql = "select * from customer";
            PreparedStatement stat =  conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setContact(rs.getString("contact"));
                customer.setEmail(rs.getString("email"));
                customer.setName(rs.getString("name"));
                customer.setRemark(rs.getString("remark"));
                customer.setTelephone(rs.getString("telephone"));
                customerList.add(customer);
            }
            return customerList;
        } catch (SQLException e) {
            LOGGER.error("execute sql failure", e);
        }finally {
           DatabaseHelper.closeConnection(conn);
        }
        return null;*/

        /**
         * 使用了DatabaseHelper之后的程序代码
         */
        /*Connection conn = DatabaseHelper.getConnection();
        try {
            String sql = "select * from customer";
            return DatabaseHelper.queryEntityList(Customer.class, conn, sql);
        }finally {
            DatabaseHelper.closeConnection(conn);
        }*/

        /**
         * 使用ThreadLocal后的代码，不需要管理connection传来传去的
         */
        String sql = "select * from customer";
        return DatabaseHelper.queryEntityList(Customer.class,sql);
    }

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    public Customer getCustomer(long id) {
        return null;
    }

    /**
     * 创建客户
     *
     * @param fieldMap
     * @return
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return false;
    }

    /**
     * 更新用户
     *
     * @param fieldMap
     * @return
     */
    public boolean updateCustomer(Map<String, Object> fieldMap) {
        return false;
    }

    /**
     * 删除用户
     *
     * @param
     * @return
     */
    public boolean deleteCustomer(long id) {
        return false;
    }

}
