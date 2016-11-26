/**
 * Created by lrkin on 2016/11/26.
 */
public class StringUtils {

    /**
     * 判断字符串是否为null或者空白
     *
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.length() < 1) {
            return true;
        }
        return false;
    }

    public static boolean isNotBlank(String str) {
        return org.apache.commons.lang.StringUtils.isNotBlank(str);
    }

    public static boolean isBlank(String str) {
        return org.apache.commons.lang.StringUtils.isBlank(str);
    }

    public static void main(String[] args) {
        String strNull = null;
        String strEmpty = "";
        String strBlank = "    ";

        System.out.println(isNullOrEmpty(strBlank) == true ? "true" : "false");
        System.out.println(isBlank(strBlank) == true ? "true" : "false");
    }
}
