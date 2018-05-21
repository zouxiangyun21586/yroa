package com.yr.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yr.dao.CheckWorkDao;
import com.yr.entry.CheckWork;
import com.yr.util.FileUtil;

@Service
public class CheckWorkExcelService {
	@Autowired
	private CheckWorkDao checkWorkDao;

	/**
	 * 导出考勤报表
	 * @param search 查询条件
	 * @return
	 * @throws Exception
	 */
	public File exportExcel(CheckWork search)throws Exception {
		List<CheckWork> excelList = checkWorkDao.getAllExcel(search);
		return writeExcel(excelList);
	}
	
	/**
	 * 写考勤报表
	 * @return
	 * @throws Exception
	 */
	public File writeExcel(List<CheckWork> excelList) throws Exception {
		// 得到excel文件
		String tempFilePath = "D:/excel/kq.xls";
		File tempFile = new File(tempFilePath);
		String excelPath = "D:/excel/考勤详情.xls";
		File excelFile = FileUtil.getExcelByTemplate(tempFile, new File(excelPath));

		// 创建一个excel sheet
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();
		wb.setSheetName(0, "上课考勤");// 设置 Sheet Name

		// 合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7)); //从0行合并到0列，从0列合并到2列

		// 写列表分类头
		XSSFRow rowHeadCase = sheet.createRow(0);
		writeExcelValue("上课考勤", rowHeadCase, 0, wb, true);
		 
		// 写列表头
		writeExcelHeadAndWidth(wb, sheet);
		// 写列表值
		writeExcelValue(excelList, wb, sheet);

		// 写进文件
		FileOutputStream output = new FileOutputStream(excelFile);
		wb.write(output);
		output.close();
		return excelFile;
	}
	
	private void writeExcelHeadAndWidth(XSSFWorkbook wb, XSSFSheet sheet) {
		XSSFRow rowHead = sheet.createRow(1);
		writeExcelValue("考勤日期", rowHead, 0, wb, true);
		sheet.setColumnWidth(0, 3500); //列宽
		writeExcelValue("考勤人员姓名", rowHead, 1, wb, true);
		sheet.setColumnWidth(1, 4500); //列宽
		writeExcelValue("考勤时间段", rowHead, 2, wb, true);
		sheet.setColumnWidth(2, 4500); //列宽
		writeExcelValue("标准上课时间", rowHead, 3, wb, true);
		sheet.setColumnWidth(3, 4500); //列宽
		writeExcelValue("实到时间", rowHead, 4, wb, true);
		sheet.setColumnWidth(4, 3500); //列宽
		writeExcelValue("考勤情况", rowHead, 5, wb, true);
		sheet.setColumnWidth(5, 3500); //列宽
		writeExcelValue("迟到时长(分钟)", rowHead, 6, wb, true);
		sheet.setColumnWidth(6, 4500); //列宽
		writeExcelValue("是否交请假条", rowHead, 7, wb, true);
		sheet.setColumnWidth(7, 4500); //列宽
	}
	
	private void writeExcelValue(List<CheckWork> excelList,XSSFWorkbook wb, XSSFSheet sheet) {
		int c = 0;
		int row = 2;
		for (CheckWork cw : excelList) {
			c=0;
			XSSFRow xssfRow = sheet.createRow(row++);
			writeExcelValue(cw.getCkTime()+"", xssfRow, c++, wb, false);
			writeExcelValue(cw.getStuName(), xssfRow, c++, wb, false);
			writeExcelValue(cw.getCtName(), xssfRow, c++, wb, false);
			writeExcelValue(cw.getStartTime(), xssfRow, c++, wb, false);
			writeExcelValue(cw.getRetyTime(), xssfRow, c++, wb, false);
			writeExcelValue(cw.getIsLateStr(), xssfRow, c++, wb, false);
			writeExcelValue(cw.getLateTime()+"", xssfRow, c++, wb, false);
			writeExcelValue(cw.getIsNoteStr(), xssfRow, c++, wb, false);
		}
	}

	/**
	 * 写进单元格, 单元格样式也在这里设置
	 * 
	 * @param value
	 *            要写入单元格的值
	 * @param row
	 *            第几行
	 * @param cols
	 *            第几列
	 * @param wb
	 * @param isHead
	 *            true是列表头 false不是列表头
	 */
	protected void writeExcelValue(String value, XSSFRow row, int cols, XSSFWorkbook wb, boolean isHead) {
		XSSFCell cell = row.createCell(cols);
		cell.setCellType(XSSFCell.CELL_TYPE_STRING);// 文本格式
		cell.setCellValue(value);// 写入内容
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		if (value.equals("旷课") || value.equals("没交请假条")){
			font.setColor(XSSFFont.COLOR_RED);//字体颜色
		}
		if (isHead) {
			style.setFillForegroundColor(IndexedColors.BLUE.getIndex());//背景色
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			style.setWrapText(true); // 行内容换行
			style.setBorderBottom(XSSFCellStyle.BORDER_THIN); //边框
			style.setBorderTop(XSSFCellStyle.BORDER_THIN);
			style.setBorderRight(XSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
			style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 居中  
			font.setBold(true); //字体加粗
			font.setFontHeight(13); //字体大小
		}
		style.setFont(font);
		cell.setCellStyle(style);
	}

}
