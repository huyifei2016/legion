package utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import model.Log;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExcelUtils {

    public static void writeExcelWithModel(List<Log> logs) {
        String fileName = String.valueOf(System.currentTimeMillis()) + ".xlsx";
        WriteSheet sheet = new WriteSheet();
        sheet.setSheetName("test result");
        sheet.setSheetNo(1);
        ExcelWriterBuilder excelBuilder = EasyExcelFactory.write(fileName);
        ExcelWriter excelWriter = excelBuilder.excelType(ExcelTypeEnum.XLSX).head(Log.class).build();
        excelWriter.write(logs, sheet);
        excelWriter.finish();
        try {
            FileUtils.moveToDirectory(new File(fileName),new File(System.getProperty("user.dir")+"\\build\\reports\\"),true);
        }catch (IOException ex)
        {ex.printStackTrace();}
    }


    private static String getCurrentTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTimeFormatter.format(LocalDateTime.now());
    }

}
