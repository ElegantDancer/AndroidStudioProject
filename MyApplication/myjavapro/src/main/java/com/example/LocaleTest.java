package com.example;

import java.util.Locale;

/**
 * Created by zhenzhen on 16/8/1.
 */
public class LocaleTest {
    public static void main(String[] args) {
        Locale[] localesList = Locale.getAvailableLocales();
        for(Locale i : localesList){
            System.out.println(i.getDisplayCountry() + "=" + i.getCountry() + " " + i.getDisplayLanguage() + "=" + i.getLanguage());
        }
    }
}
