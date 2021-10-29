package com.mekhyua.vuele.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mekhyua.vuele.dao.HeroDao;
import com.mekhyua.vuele.entity.ResultVo;
import com.mekhyua.vuele.pojo.Hero;
import com.mekhyua.vuele.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HeroServiceImpl implements IHeroService {

    @Autowired
    private HeroDao heroDao;

    private ResultVo<Hero> resultVo;

    @Override
    public ResultVo<Hero> queryAll(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Hero> heroes = heroDao.selectAll();
        PageInfo pageInfo = new PageInfo(heroes);
        resultVo = new ResultVo();
        resultVo.setCode(0);
        if(!heroes.isEmpty()){
            resultVo.setData(heroes);
            resultVo.setCode(1000);
            resultVo.setTotal(pageInfo.getTotal());
        }

        return resultVo;
    }

    @Override
    public ResultVo<Hero> queryHeroByUsername(String username, String password) {
        resultVo = new ResultVo<>();
        String s = heroDao.selectPassword(username);
        if(s.equals(password)){
            resultVo.setCode(1000);
        }

        return resultVo;
    }

    @Override
    public ResultVo<Hero> deleteById(Integer id) {
        int i = heroDao.deleteByPrimaryKey(id);
        resultVo = new ResultVo<>();
        if(i == 1){
            resultVo.setCode(1000);
        }

        return resultVo;
    }

    @Override
    public ResultVo<Hero> updateHero(Hero hero) {
        int i = heroDao.updateByPrimaryKeySelective(hero);
        if(i == 1){
            resultVo.setCode(1000);
        }

        return resultVo;
    }

    @Override
    public ResultVo<Hero> getHeroById(Integer id) {
        resultVo = new ResultVo<>();
        Hero hero = heroDao.selectByPrimaryKey(id);
        resultVo.setData(Collections.singletonList(hero));

        return resultVo;
    }

    @Override
    public ResultVo<Hero> addHero(Hero hero) {
        resultVo = new ResultVo<>();
        int i = heroDao.insert(hero);
        if(i == 1){
            resultVo.setCode(1000);
        }

        return resultVo;

    }
}
