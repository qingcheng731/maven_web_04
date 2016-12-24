package org.lanqiao.vo;

import java.util.List;

/**
 * 一个分页的泛型vo类
 * @author wangzhoucheng
 *
 * @param <T> 需要进行分页的表对应的entity对象
 */
public class PageData<T> {
	private int pagesize;//每页的条数
	private int pageindex;//当前页码
	private int pagecount;//总页数
	private int totalrecords;//总记录数
	
	private List<T> list;

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPageindex() {
		return pageindex;
	}

	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}

	public int getTotalrecords() {
		return totalrecords;
	}

	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "UserVo [pagesize=" + pagesize + ", pageindex=" + pageindex
				+ ", pagecount=" + pagecount + ", totalrecords=" + totalrecords
				+ ", list=" + list + "]";
	}
	
	
	
}
