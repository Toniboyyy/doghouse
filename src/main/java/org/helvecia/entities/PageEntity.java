package org.helvecia.entities;

import java.util.List;

public class PageEntity<T> {
    
    private List<T> entries;

    private Long totalAmount;

    private int pageIndex;

    private int pageSize;

    public PageEntity(List<T> entries, Long totalAmount, int pageIndex, int pageSize) {
        this.entries = entries;
        this.totalAmount = totalAmount;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public List<T> getEntries() {
        return entries;
    }

    public void setEntries(List<T> entries) {
        this.entries = entries;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    
}
