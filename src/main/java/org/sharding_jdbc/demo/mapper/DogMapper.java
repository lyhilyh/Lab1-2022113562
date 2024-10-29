package org.sharding_jdbc.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.sharding_jdbc.demo.bean.Dog;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DogMapper {
    @Insert("insert into dogs(id,name) values(#{id},#{name})")
    public void insertDog(Dog dog);
}
