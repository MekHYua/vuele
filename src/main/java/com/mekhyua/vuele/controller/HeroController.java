package com.mekhyua.vuele.controller;

import com.mekhyua.vuele.entity.Meta;
import com.mekhyua.vuele.entity.ResultPermission;
import com.mekhyua.vuele.entity.ResultToken;
import com.mekhyua.vuele.entity.ResultVo;
import com.mekhyua.vuele.pojo.Aut;
import com.mekhyua.vuele.pojo.AutChi;
import com.mekhyua.vuele.pojo.Hero;
import com.mekhyua.vuele.service.IHeroService;
import com.mekhyua.vuele.uitls.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/hero")
public class HeroController {

    @Autowired
    private IHeroService heroService;
    private ResultVo<Hero> resultVo;

    @RequestMapping("/login")
    public ResultToken login(@RequestBody Hero hero, HttpServletRequest request){
        resultVo = heroService.queryHeroByUsername(hero.getUsername(), hero.getPassword());

        ResultToken resultToken = new ResultToken();
        resultToken.setCode(1000);


        String token = JwtUtil.createToken(hero.getUsername());
        resultToken.setData(token);

        return resultToken;
    }

    @RequestMapping("/register")
    public ResultVo<Hero> register(@RequestBody Hero hero){
        resultVo = heroService.addHero(hero);

        return resultVo;
    }

    @RequestMapping("/findAll")
    public ResultVo<Hero> findAll(Integer page, Integer limit){
        resultVo = heroService.queryAll(page, limit);

        return resultVo;
    }

    @RequestMapping("/removeHero")
    public ResultVo<Hero> removeHero(Integer id){
        resultVo = heroService.deleteById(id);

        return resultVo;
    }

    @RequestMapping("/modifyHero")
    public ResultVo<Hero> modifyHero(@RequestBody Hero hero){
        resultVo = heroService.updateHero(hero);

        return resultVo;
    }

    @RequestMapping("/getHeroById")
    public ResultVo<Hero> getHeroById(Integer id){
        resultVo = heroService.getHeroById(id);

        return resultVo;
    }

    @RequestMapping("/detail")
    public ResultToken detail(String token){

        if((JwtUtil.checkToken(token))){
            System.out.println("true");
        }

//        eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyIxMjMiOiJhZG1pbiIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE2MzU1ODMyMDJ9.TV-7EFsIvNx385DnHgSQiGQiKhSAhMRjiVS8-mqhzes
//        eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyIxMTEiOiJhZG1pbiIsInJvbGUiOiJhZG1pbiIsInN1YiI6ImFkbWluLXRlc3QiLCJleHAiOjE2MzU1ODM1MDB9.M39nEa_HnUj0bSQkdMPgyU-EVGvUo0vlBcjgOQpQ2Mk
        ResultToken resultToken = new ResultToken();

        Hero hero = new Hero();
        hero.setUsername(token);
        hero.setPassword("houjif");
        hero.setInfo("hfueawoji");

        resultToken.setData(hero);
        resultToken.setCode(1000);

        return resultToken;
    }

    @RequestMapping("/aut")
    public ResultPermission aut(String token){
        ResultPermission resultPermission = new ResultPermission();
        List<Aut> list = new ArrayList<>();

        Aut aut1 = new Aut();
        aut1.setPath("/system");
        aut1.setRedirect("/menu");
        aut1.setComponent("Layout");
        aut1.setMeta(new Meta("form", "系统管理"));
//        aut1.setName("系统管理");

        List<AutChi> list11 = new ArrayList<>();
        AutChi aut11 = new AutChi();
        aut11.setPath("/menu");
        aut11.setComponent("menu/index");
        aut11.setName("menu");
        aut11.setMeta(new Meta("table", "菜单管理"));
        list11.add(aut11);

        AutChi aut12 = new AutChi();
        aut12.setPath("/roles");
        aut12.setComponent("roles/index");
        aut12.setName("roles");
        aut12.setMeta(new Meta("table", "角色管理"));
        list11.add(aut12);

        AutChi aut13 = new AutChi();
        aut13.setPath("/administrator");
        aut13.setComponent("dashboard/index");
        aut13.setName("administrator");
        aut13.setMeta(new Meta("table", "用户管理"));
        list11.add(aut13);


        aut1.setChildren(list11);
        list.add(aut1);

//        Aut aut1 = new Aut();
//        aut1.setPath("/");
//        aut1.setRedirect("/dashboard");
//        aut1.setComponent("Layout");
//        aut1.setTitle("系统管理");
//        aut1.setName("系统管理");
//
//        List<Aut> list11 = new ArrayList<>();
//        Aut aut11 = new Aut();
//        aut11.setPath("/dashbord");
//        aut11.setComponent("dashboard/index");
//        aut11.setTitle("Dashboard");
//        aut11.setName("Dashboard");
//        list11.add(aut11);
//        aut1.setChildren(list11);
//        list.add(aut1);
//
//        Aut aut2 = new Aut();
//        aut2.setPath("/example");
//        aut2.setRedirect("/example/table");
//        aut2.setComponent("Layout");
//        aut2.setTitle("Example");
//        aut2.setName("Example");
//
//        List<Aut> list21 = new ArrayList<>();
//        Aut aut21 = new Aut();
//        aut21.setPath("table");
//        aut21.setComponent("table/index");
//        aut21.setTitle("Table");
//        aut21.setName("Table");
//        list21.add(aut21);
//        aut2.setChildren(list21);
//
//        List<Aut> list22 = new ArrayList<>();
//        Aut aut22 = new Aut();
//        aut22.setPath("tree");
//        aut22.setComponent("tree/index");
//        aut22.setTitle("Tree");
//        aut22.setName("Tree");
//        list22.add(aut22);
//        aut2.setChildren(list22);
//
//        list.add(aut2);

        resultPermission.setList(list);
        resultPermission.setCode(1000);

        return resultPermission;
    }

}
