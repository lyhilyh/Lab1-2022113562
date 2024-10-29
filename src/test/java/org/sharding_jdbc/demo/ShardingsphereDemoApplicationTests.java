package org.sharding_jdbc.demo;

import org.sharding_jdbc.demo.bean.Customer;
import org.sharding_jdbc.demo.bean.Dog;
import org.sharding_jdbc.demo.bean.Orders;
import org.sharding_jdbc.demo.mapper.CustomerMapper;
import org.sharding_jdbc.demo.mapper.DogMapper;
import org.sharding_jdbc.demo.mapper.OrdersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingsphereDemoApplicationTests {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private DogMapper dogMapper;

//    @Test
//    public void insertCustomer(){
//        for (int i = 1; i <= 10 ; i++) {
//            Customer customer = new Customer();
//            customer.setId(i);
//            customer.setName("zs"+i);
//            customer.setAddress("address"+i);
//            customer.setPhone("phone"+i);
//            customerMapper.insertCustomer(customer);
//        }
//    }
    // 测试水平分库分表
    @Test
    public void addOrders(){
        for (int i = 1; i <=10 ; i++) {
            Orders orders = new Orders();
            orders.setId(i);
            orders.setCustomerId(i);
            orders.setOrderType(i);
            orders.setAmount(1000.0*i);
            ordersMapper.insert(orders);
            Orders orderss = new Orders();
            orderss.setId(i+10);
            orderss.setCustomerId(i+1);
            orderss.setOrderType(i);
            orderss.setAmount(1000.0*i);
            ordersMapper.insert(orderss);
        }
    }
    @Test
    public void queryOrders(){  //分表查询
        Orders orders = ordersMapper.selectOne(1);
        System.out.println("查看订单");
        System.out.println(orders);
    }
    @Test
    public void queryOrdersDB(){    //分库查询
        Orders orders = new Orders();
        orders.setCustomerId(7);
        orders.setId(7);
        Orders o = ordersMapper.selectOneDB(orders);
        System.out.println(o);
    }

    // 测试垂直分表
    @Test
    public void insertCustomer(){
        for (int i = 1; i <= 10 ; i++) {
            Customer customer = new Customer();
            customer.setId(i);
            customer.setName("zs"+i);
            customer.setAddress("address"+i);
            customer.setPhone("phone"+i);
            customerMapper.insertCustomerBase(customer);
            customerMapper.insertCustomerDetail(customer);
        }
    }

    // 测试垂直分库
    @Test
    public void insertOrderAndDog(){
        for (int i = 1; i <= 10 ; i++) {
            Orders orders = new Orders();
            orders.setId(i);
            orders.setCustomerId(i);
            orders.setOrderType(i);
            orders.setAmount(1000.0*i);
            ordersMapper.insert(orders);
            Dog dog = new Dog();
            dog.setId(i);
            dog.setName("dog"+i);
            dogMapper.insertDog(dog);
        }
    }
}

