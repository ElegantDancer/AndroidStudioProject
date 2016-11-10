package com.example;

/**
 * Created by zhenzhen on 15/12/10.
 */
public class ChineseLengthTest {

    public enum CTCountryType{
        Domestic("Domestic", "国内", 1),
        OVERSEA("GLOBAL", "海外", 2),
        UNKNOWN("UNKNOWN", "未知", 3);

        CTCountryType(String global, String oversal, int i) {

        }
    }

    public static void main(String[] args) {
        String s = "中国";
        String s1 = "ha";
        System.out.println(s.length());
        System.out.println(s1.length());
        System.out.println(CTCountryType.Domestic);
    }
}
