package com.bookshop.service;

/**
 * Created by Nazar on 12.06.2017.
 */
public interface MailSenderService {

    void sendEmail(String theme, String mailBody, String email);

}
