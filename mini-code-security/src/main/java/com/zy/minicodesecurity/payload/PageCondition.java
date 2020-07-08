package com.zy.minicodesecurity.payload;

import lombok.Data;

/**
 * <p>
 * 分页请求参数
 * </p>
 */
@Data
public class PageCondition {
    /**
     * 当前页码
     */
    private Integer currentPage;

    /**
     * 每页条数
     */
    private Integer pageSize;

}
