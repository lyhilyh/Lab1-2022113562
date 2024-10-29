package org.sharding_jdbc.demo.bean;

public class Dog {
    private Integer id;
    String name;

    public Dog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
