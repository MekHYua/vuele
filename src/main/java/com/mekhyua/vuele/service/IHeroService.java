package com.mekhyua.vuele.service;

import com.mekhyua.vuele.entity.ResultVo;
import com.mekhyua.vuele.pojo.Hero;

import java.util.List;

public interface IHeroService {

    ResultVo<Hero> queryAll(Integer page, Integer limit);

    ResultVo<Hero> queryHeroByUsername(String username, String password);

    ResultVo<Hero> deleteById(Integer id);

    ResultVo<Hero> updateHero(Hero hero);

    ResultVo<Hero> getHeroById(Integer id);

    ResultVo<Hero> addHero(Hero hero);

}
