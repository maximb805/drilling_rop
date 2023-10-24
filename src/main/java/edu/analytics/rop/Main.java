//package edu.analytics.rop;
//
//import edu.analytics.rop.entities.FullRun;
//import edu.analytics.rop.repository.FullRunsRepository;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.FileInputStream;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Date;
//
//@Service
//public class Main {
//
//    @Autowired
//    public FullRunsRepository fullRunsRepository;
//
//    @Transactional
//    public void fillDB() {
//        String filename = "C:\\Users\\maxim\\Desktop\\projects\\ROP\\src\\main\\resources\\WB.xlsx";
//        XSSFWorkbook sheets = readWorkBook(filename);
//
//        assert sheets != null;
//        XSSFSheet sheet = sheets.getSheet("Лист1");
//        int r = 1;
//        while (sheet.getRow(r) != null) {
//            try {
//                XSSFRow row = sheet.getRow(r);
//                FullRun fullRun = new FullRun();
//                XSSFCell cell = row.getCell(0);
//                if (cell != null)
//                    fullRun.setRunNum((int) cell.getNumericCellValue());
//
//                LocalDate localDate = null;
//                Date date = null;
//                cell = row.getCell(1);
//                if (cell != null)
//                    date = cell.getDateCellValue();
//                if (date != null)
//                    localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//                fullRun.setStartDate(localDate);
//
//                cell = row.getCell(2);
//                if (cell != null)
//                    fullRun.setBitFullType(cell.getStringCellValue());
//
//                cell = row.getCell(3);
//                if (cell != null)
//                    fullRun.setBitIADCCode(cell.getStringCellValue());
//
//                cell = row.getCell(4);
//                if (cell != null)
//                    fullRun.setBitSerial(cell.getStringCellValue());
//                fullRun.setRunStartDepth(row.getCell(5).getNumericCellValue());
//                fullRun.setRunEndDepth(row.getCell(6).getNumericCellValue());
//                fullRun.setRunPenetration(row.getCell(7).getNumericCellValue());
//                fullRun.setRunDrillingTime(row.getCell(8).getNumericCellValue());
//                fullRun.setRunROP(row.getCell(9).getNumericCellValue());
//                fullRun.setDiameter(row.getCell(10).getNumericCellValue());
//
//                cell = row.getCell(11);
//                if (cell != null)
//                    fullRun.setPadName(cell.getStringCellValue());
//
//                cell = row.getCell(12);
//                if (cell != null)
//                    fullRun.setWellName(cell.getStringCellValue());
//
//                cell = row.getCell(13);
//                if (cell != null)
//                    fullRun.setRunPurpose(cell.getStringCellValue());
//
//                cell = row.getCell(14);
//                if (cell != null)
//                    fullRun.setWellConstruction(cell.getStringCellValue());
//
//                cell = row.getCell(15);
//                if (cell != null)
//                    fullRun.setBitProducer(cell.getStringCellValue());
//
//                cell = row.getCell(16);
//                if (cell != null)
//                    fullRun.setPadSet(cell.getStringCellValue());
//
//                cell = row.getCell(17);
//                if (cell != null)
//                    fullRun.setFieldName(cell.getStringCellValue());
//
//                fullRunsRepository.save(fullRun);
//                r++;
//            } catch (IllegalStateException ex) {
//                System.out.println(r + 1);
//                throw new IllegalStateException(ex);
//            }
//        }
//    }
//
//    public static XSSFWorkbook readWorkBook(String fileName) {
//        try {
//            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(fileName));
//            return wb;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//}
