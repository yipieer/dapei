package com.service;

import com.entity.News;

import java.util.List;

public interface NewsService {
    //查看
    List<News> listNewss();
    //查询
    List<News> listNewss(String xwmc);
    //添加
    void addNews(News news);
    //更新
    void updateNews(News News);
    //取新闻
    News getNews(int id);
    //删新闻
    void delNews(int id);

}
