package cn.edu.bit.dict.page;

import lombok.Data;

import java.io.Serializable;


/**
 * Created by hzwangqiqing
 * on 2017/5/18.
 */
@Data
public class PaginationInfo implements Serializable {
    private static final long serialVersionUID = -388899486311002284L;

    public PaginationInfo() {
        this.initialize();
    }

    // 当前页，1基址
    private Integer currentPage = 1;

    // 每页记录数
    private Integer recordPerPage = 20;

    // 总页数
    private Integer totalPage = null;

    // 总记录数
    private Integer totalRecord = null;

    private void initialize() {
        totalPage = 0;
        if (null != totalRecord) {
            totalPage = (totalRecord + recordPerPage - 1) / recordPerPage;
        }
    }
}
