package com.service.impl;

import com.entity.News;
import com.service.NewsService;
import com.util.DataSourceUtils;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    @Override
    public List<News> listNewss() {
        List<News> news = new ArrayList<>();
        String sql = "SELECT * FROM news";
        try (Connection connection = DataSourceUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                News news1 = new News(rs.getInt("id"), rs.getString("name"), rs.getString("editor"), rs.getString("content"), rs.getTimestamp("insertTime"), rs.getTimestamp("currentTime"));
                news.add(news1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }


    @Override
    public List<News> listNewss(String xwmc) {
        List<News> news = new ArrayList<>();
        String sql = "SELECT * FROM news WHERE name LIKE" + "'%" + xwmc + "%'";
        try (Connection connection = DataSourceUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                News news1 = new News(rs.getInt("id"), rs.getString("name"), rs.getString("editor"), rs.getString("content"), rs.getTimestamp("insertTime"), rs.getTimestamp("currentTime"));
                news.add(news1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public void addNews(News news) {
        String sql = "INSERT INTO news(name,insertTime,currentTime,editor,content) VALUES(?,?,?,?,?)";
        try (Connection connection = DataSourceUtils.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, news.getName());
            st.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            st.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            st.setString(4, news.getEditor());
            st.setString(5, news.getContent());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateNews(News news) {
        String sql = "UPDATE news SET name =?,editor = ?,currentTime = ?,content=? WHERE id = ?;";
        try (Connection connection = DataSourceUtils.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, news.getName());
            st.setString(2, news.getEditor());
            st.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            st.setString(4, news.getContent());
            st.setInt(5, news.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public News getNews(int id) {
        News news = new News();
        String sql = "SELECT * FROM news WHERE id=?";
        try (Connection connection = DataSourceUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    news = new News(rs.getInt("id"), rs.getString("name"), rs.getString("editor"), rs.getString("content"), rs.getTimestamp("insertTime"), rs.getTimestamp("currentTime"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    @Override
    public void delNews(int id) {
        String sql = "DELETE FROM news WHERE id=?";
        try (Connection connection = DataSourceUtils.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
