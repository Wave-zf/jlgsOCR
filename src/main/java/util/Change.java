package util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import test.PictureOCR;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by zhangfan on 2018/6/25 17:08
 */
public class Change {

    public static void txt_To_excel(String excelPath,String[] headNames,String filePath){
        ArrayList<String> list = PictureOCR.gsorc(filePath);
        //Excel
        HSSFWorkbook wb = new HSSFWorkbook();
        //sheet表
        HSSFSheet sheet = wb.createSheet();
        //标题行
        HSSFRow head=sheet.createRow(0);
        //定义样式
        HSSFCellStyle style = wb.createCellStyle();
        //字体样式
        HSSFFont font = wb.createFont();
        font.setColor(HSSFColor.BLACK.index);//字体颜色
        style.setFont(font);
        for (int i =0;i<=headNames.length-1;i++){
            //标题列
            HSSFCell headCell = head.createCell(i);
            //标题内容
            headCell.setCellValue(headNames[i]);
            //应用样式
            headCell.setCellStyle(style);
        }
        try (FileOutputStream os = new FileOutputStream(excelPath)) {
            //创建行
            for (int i =0;i<=list.size()-1;i++){
                HSSFRow row = sheet.createRow(i+1);
                HSSFCell cell = row.createCell(0);
                cell.setCellValue(list.get(i));
            }
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
