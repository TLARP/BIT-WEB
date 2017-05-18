package cn.edu.bit.dict.response;

import java.io.Serializable;

/**
 * Created by hzwangqiqing
 * on 2017/5/18.
 */
public class Response<D> implements Serializable {
    private static final long serialVersionUID = 2829945422964720838L;
    private boolean success;
    private String code;
    private String desc;
    private D data;

    private Response() {
    }

    public static <D> Response<D> wrapSuccess() {
        return wrapSuccess(CommonCode.SUCCESS, null);
    }

    public static <D> Response<D> wrapSuccess(D data) {
        return wrapSuccess(CommonCode.SUCCESS, data);
    }

    public static <D> Response<D> wrapSuccess(Code code, D data) {
        Response response = new Response();
        response.success = true;
        response.data = data;
        response.code = code.getCode();
        response.desc = code.getDesc();
        return response;
    }

    public static <D> Response<D> wrapError(Code code) {
        return wrapError(code.getCode(), code.getDesc(), null);
    }

    public static <D> Response<D> wrapError(String desc) {
        return wrapError(CommonCode.FAIL.getCode(), desc,  null);
    }

    public static <D> Response<D> wrapError(Code code, D data) {
        return wrapError(code.getCode(), code.getDesc(), data);
    }

    public static <D> Response<D> wrapError(String code, String desc) {
        return wrapError(code, desc,null);
    }

    public static <D> Response<D> wrapError(String code, String desc, D data) {
        Response response = new Response();
        response.success = false;
        response.code = code;
        response.desc = desc;
        response.data = data;
        return response;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public D getData() {
        return this.data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
