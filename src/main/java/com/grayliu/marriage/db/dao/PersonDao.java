package com.grayliu.marriage.db.dao;

import com.grayliu.marriage.db.entity.Person;

import java.util.List;

public interface PersonDao {


    public Person selectByPrimaryKey(Integer id);

    public Person selectByNum(String num);

    public int insert(Person person);

    public List<Person> query(Person person);

}
