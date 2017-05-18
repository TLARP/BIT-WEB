package cn.edu.bit.dict.response;

/**
 * Created by hzwangqiqing
 * on 2017/5/18.
 */
public enum CommonCode implements Code {
    SUCCESS(ErrorCodeUtil.getErrorCode("200"), "操作成功"),
    FAIL(ErrorCodeUtil.getErrorCode("500"), "操作失败");

    private String code;
    private String desc;

    private CommonCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
