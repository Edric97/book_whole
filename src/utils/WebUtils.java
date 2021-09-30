package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Map;

public class WebUtils {

    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static Integer transStrToInt(String s, Integer defaultInt) {

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return defaultInt;
        }
    }


}
