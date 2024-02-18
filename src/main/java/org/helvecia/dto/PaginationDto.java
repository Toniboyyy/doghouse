package org.helvecia.dto;

import java.util.List;

import org.helvecia.entities.enumerations.Sorting;

public class PaginationDto<T> {
    
    private int pageIndex;

    private int pageSize;

    private List<T> entries;

    private Sorting sorting;



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

    public List<T> getEntries() {
        return entries;
    }

    public void setEntries(List<T> entries) {
        this.entries = entries;
    }
    
    public Sorting getSorting() {
        return sorting;
    }

    public void setSorting(Sorting sorting) {
        this.sorting = sorting;
    }

}
