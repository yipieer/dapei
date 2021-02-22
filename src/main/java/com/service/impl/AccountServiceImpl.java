package com.service.impl;

import com.entity.Accounts;
import com.service.AccountService;
import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
 @Override
    public boolean AccountLogin(Accounts accounts) {
        String sql = "SELECT * FROM account WHERE username=? AND password=?";
        try (Connection connection = DataSourceUtils.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)){
            st.setString(1, accounts.getUserName());
            st.setString(2, accounts.getPassword());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
