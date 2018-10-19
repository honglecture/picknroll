package com.picknroll.web.util;

public class Pagination {
	
	private static Pagination page = new Pagination();
	private int startRow, endRow;
	private StringBuffer sb;

	private Pagination() {}

	public static Pagination getInstance() {
		if (page == null) {
			page = new Pagination();
		}
		return page;
	}

	public synchronized void paging(int pageNum, int totalCount, int pageSize, int pageBlock) {
		int totalPage = (int) Math.ceil((double) totalCount / pageSize);
		startRow = (pageNum - 1) * pageSize + 1;
		endRow = pageNum * pageSize;

		int startPage = (int) ((pageNum - 1) / pageBlock) * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;

		if (endPage > totalPage) {
			endPage = totalPage;
		}

		sb = new StringBuffer();

		// Page클래스 변경 부분
		if (startPage < pageBlock) {
			sb.append(
				"<li class='disabled'><a href='#' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>"
			);
		} else {
			sb.append("<li class='pointer'><a onclick='javascript:movePage(\"");
			sb.append(startPage - pageBlock);
			sb.append("\");' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
		}

		for (int i = startPage; i <= endPage; i++) {
			if (i == pageNum) {
				sb.append("<li>");
				sb.append(i);
				sb.append("</li>");
			} else {
				sb.append("<li>");
				sb.append(i);
				sb.append("</li>");
			}
		}

		if (endPage < totalPage) {
			sb.append("<li class='pointer'><a onclick='javascript:movePage(\"");
			sb.append(startPage + pageBlock);
			sb.append("\");' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		} else {
			sb.append(
					"<li class='disabled'><a href='#' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		}
		
	}

	public StringBuffer getSb() {
		return sb;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}
	
}
