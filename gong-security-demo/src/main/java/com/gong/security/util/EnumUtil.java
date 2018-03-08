package com.gong.security.util;

import com.gong.security.util.enums.IEnum;

/**
 * Created by GongWenHua on 17.12.17.
 */
public class EnumUtil {
    public static <T1 extends IEnum<T2>,T2> T1 GetEnumByIndex(T2 index, Class<T1> enumClass){
        T1[] contants = enumClass.getEnumConstants();
        for(T1 temp:contants){
            if(temp.getCode() == index){
                return temp;
            }
        }
        return null;
    }
}
