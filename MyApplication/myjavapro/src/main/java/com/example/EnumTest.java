package com.example;

/**
 * Created by zhenzhen on 16/8/5.
 */
public class EnumTest {
    public enum HotelListEnterType{
        A, B, C, D;
        public static HotelListEnterType getEnumByInt(int ordinal){
            HotelListEnterType[] dd = HotelListEnterType.values();
            for(HotelListEnterType sortTypeEnum : dd){
                if(sortTypeEnum.ordinal() == ordinal){

                    return sortTypeEnum;
                }
            }
            return C;
        }
    }

    public static void main(String[] args) {
        System.out.println(EnumTest.HotelListEnterType.getEnumByInt(3));
    }
}
