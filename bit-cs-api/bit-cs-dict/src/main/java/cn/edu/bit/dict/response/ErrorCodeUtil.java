package cn.edu.bit.dict.response;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by hzwangqiqing
 * on 2017/5/18.
 */
public final class ErrorCodeUtil {
    private static ThreadLocal<String> appCodeEnumCache = new ThreadLocal();
    private static final String DEFUALT_CODE = "00000";

    private ErrorCodeUtil() {
    }

    private static String getErrorCode(String specificCode, String appCode) {
        if (specificCode == null || specificCode.trim().length() == 0) {
            specificCode = "00000";
        }

        if (appCode == null) {
            appCode = "unkown";
        }

        return appCode + specificCode;
    }

    public static String getErrorCode(String specificCode) {
        try {
            String appCode = getAppCode();
            return getErrorCode(specificCode, appCode);
        } catch (Exception var2) {
            return specificCode;
        }
    }

    private static String getAppCode() {
        String appCode = (String) appCodeEnumCache.get();
        if (appCode != null) {
            return appCode;
        } else {
            try {
                appCode = "unkown";
                ResourceBundle bundle = ResourceBundle.getBundle("config", new Locale("zh", "CN"));
                String name = bundle.getString("app.name");
                if (name != null && name.trim().length() > 0) {
                    appCode = name;
                }
            } catch (Exception var3) {
                ;
            }

            appCodeEnumCache.set(appCode);
            return appCode;
        }
    }
}