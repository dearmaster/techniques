package com.master.asm.web.controller;

import com.master.asm.model.Article;
import com.master.asm.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    public ArticleController() {
        System.out.println("----------");
        System.out.println("----------");
        System.out.println("----------");
        System.out.println("----------");
    }

    @Resource
    private ArticleService articleService;

    @RequestMapping("/loadAll")
    public String loadAll(Model model) {
        List<Article> list = articleService.loadAll();
        model.addAttribute("articles", list);
        return "SUCCESS";
    }

    @RequestMapping(value = "/xml/get/{id}.xml", produces = {MediaType.APPLICATION_XML_VALUE + ";charset=UTF-8"})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Article loadXmlById(@PathVariable("id") Integer id, Model model) {
        Article article = articleService.getById(id);
        return article;
    }

    @RequestMapping(value = "/json/get/{id}.json", produces = {MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Article> handleWriteJSON(Model model) {
        List<Article> list = articleService.loadAll();
        return list;
    }

}