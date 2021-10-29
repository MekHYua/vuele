package com.mekhyua.vuele.dao;

import com.mekhyua.vuele.pojo.Hero;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Hero record);

    int insertSelective(Hero record);

    Hero selectByPrimaryKey(Integer id);

    List<Hero> selectAll();

    String selectPassword(String username);

    int updateByPrimaryKeySelective(Hero record);

    int updateByPrimaryKey(Hero record);
}