package util;

/**
 * Created by lrkin on 2016/11/26.
 */
public class StringUtils {

    /**
     * 判断字符串是否为Null或空白
     *
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.length() < 1)
            return true;
        return false;
    }

    public static boolean isNotBlank(String str) {
        return org.apache.commons.lang.StringUtils.isNotBlank(str);
    }

    public static boolean isBlank(String str) {
        return org.apache.commons.lang.StringUtils.isBlank(str);
    }

    /**
     * 判断字符串是否为Null或者全部是空格、Tab的内容
     *
     * @param str
     * @return
     */
    public static boolean isNullOrWhiteSpace(String str) {
        if (str == null || str.length() < 1)
            return true;
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == ' ' && str.charAt(i) == '\t'))
                return false;
        }
        return true;
    }

}
