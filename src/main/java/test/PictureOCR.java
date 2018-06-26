package test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import util.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan on 2018/6/24 21:15
 */
public class PictureOCR {

    public static ArrayList<String> gsorc(String path) {
        try {
            List<File> list = Utils.getFiles(new File(path));
            ArrayList<String> Strlist = new ArrayList<>();
            ITesseract instance = new Tesseract();
            //instance.setDatapath("D:\\Tess4J-3.4.8-src\\Tess4J");
            instance.setLanguage("normal");//选择字库文件（只需要文件名，不需要后缀名）
            for (int j = 0; j < list.size(); j++) {
                System.out.println(j);
                String result = instance.doOCR(list.get(j));//开始识别
                int index = 0;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < result.length(); i++) {
                    if (result.charAt(i) == '\n') {
                        index++;
                        sb.append(result.charAt(i));
                        if (index == 3) {
                            index = 0;
                            Strlist.add(sb.toString());
                            break;
                        }
                    } else {
                        sb.append(result.charAt(i));
                    }
                }
            }
            return Strlist;
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return null;
    }
}
