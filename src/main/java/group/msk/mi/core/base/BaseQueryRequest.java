package group.msk.mi.core.base;

/**
 * @Author 吕衡
 * @Create 2020/8/19 - 21:39
 * @Desc 基础查询类
 */
public class BaseQueryRequest {

    /**
     * 当前页码
     */
    private Long currentPage;

    /**
     * 页面容量
     */
    private Long pageSize;

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
