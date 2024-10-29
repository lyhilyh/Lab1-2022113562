package org.sharding_jdbc.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sharding_jdbc.demo.bean.Customer;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerMapper {
//    @Insert("insert into customer(id,name,address,phone) values(#{id},#{name},#{address},#{phone})")
//    public void insertCustomer(Customer customer);

    @Insert("insert into customer_base(id,name) values(#{id},#{name})")
    public void insertCustomerBase(Customer customer);

    @Insert("insert into customer_details(id,address,phone) values(#{id},#{address},#{phone})")
    public void insertCustomerDetail(Customer customer);
}

