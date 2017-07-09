package com.bookshop.serviceImpl;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by Nazar on 09.07.2017.
 */
public class CookieThenAcceptHeaderLocaleResolver extends CookieLocaleResolver {

    private final AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();

    @Override
    protected Locale determineDefaultLocale(HttpServletRequest request) {

        Locale currentLocale = new Locale(acceptHeaderLocaleResolver.resolveLocale(request).getLanguage());

        if (currentLocale.equals("ua")) {
            return new Locale("ua");
        } else {
            return new Locale("en");
        }

    }
}
