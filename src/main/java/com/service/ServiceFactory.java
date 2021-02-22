package com.service;

import com.service.impl.AccountServiceImpl;
import com.service.impl.NewsServiceImpl;

public class ServiceFactory {

    private static  NewsService NEWS_SERVICE = createNews();

    private static  AccountService ACCOUNT_SERVICE = createAccount();

    private static AccountService createAccount() {
        return new AccountServiceImpl();
    }

    private static NewsService createNews() {
        return new NewsServiceImpl();
    }

    public static NewsService getNewsService() {
        return NEWS_SERVICE;
    }

    public static AccountService getAccountService() {
        return ACCOUNT_SERVICE;
    }
}
