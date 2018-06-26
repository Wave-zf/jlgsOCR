package test;

import util.Change;

/**
 * Created by zhangfan on 2018/6/26 12:47
 */
public class JavaMain {
    public static void main(String[] args) {
        String excelPath="I:\\测试\\1_20180208150251_x4hzz\\天猫工商信息执照\\网店工商信息文字提取.xls";
        String[] headNames={"注册号","企业名称"};
        String filePath = "I:\\测试\\1_20180208150251_x4hzz\\天猫工商信息执照";
        Change.txt_To_excel(excelPath,headNames,filePath);
    }
}
