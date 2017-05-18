package cn.edu.bit.dict.page;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzwangqiqing
 * on 2017/5/18.
 */
@Data
public class PageResult<E> implements Serializable {
    private static final long serialVersionUID = -696525706282141780L;

    PageResult(List<E> resultList, PaginationInfo paginationInfo) {
        this.resultList = resultList;
        this.paginationInfo = paginationInfo;
    }

    List<E> resultList = new ArrayList<>();

    PaginationInfo paginationInfo;
}
