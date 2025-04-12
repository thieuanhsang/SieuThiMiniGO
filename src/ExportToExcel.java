import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExportToExcel {

  public static void export(String sheetName, Class clazz, List<?> results) {
    try {
      Field[] fields = clazz.getDeclaredFields();
      Method[] methods;
      HSSFWorkbook workbook = new HSSFWorkbook();
      int rowIndex = 0;
      HSSFSheet sheet = workbook.createSheet(sheetName);
      HSSFRow row = sheet.createRow(rowIndex);
      Cell cell = null;
      for (int i = 0; i < fields.length; i++) {
        cell = row.createCell(i);
        cell.setCellValue(fields[i].getName());
      }
      rowIndex++;
      int i = 0;
      for (Object data : results) {
        HSSFRow row1 = sheet.createRow(rowIndex);
        for (int j = 0; j < fields.length; j++) {
          if (!fields[j].isAccessible()) {
            fields[j].setAccessible(true);
          }

          Cell cell1 = row1.createCell(j);
          cell1.setCellValue(fields[j].get(data) + "");
        }
        i++;
        rowIndex++;
      }
//      for (int i = 0; i < fields.length; i++) {
//          int j = i;
//          if(fields[i].get(results.get(i)) instanceof String) {
//            cell = row.createCell(i);
//            cell.setCellValue(fields[i].getName());
//          } else if(fields[i].get(results.get(i)) instanceof Integer) {
//            cell = row.createCell(i, CellType.NUMERIC);
//            cell.setCellValue(fields[i].getName());
//          }
//
//        }
//
//
//
//      for (int i = 0; i < results.size(); i++) {
//        row = sheet.createRow(4 + i);
//        methods = results.get(i).getClass().getMethods();
//        int j = i;
//        for (Method method : methods) {
//
//          if(isGetter(method)) {
//            if(Integer.class.isInstance(method)) {
//              cell = row.createCell(j, CellType.NUMERIC);
//              cell.setCellValue(String.valueOf(method.getReturnType()));
//
//            }
//            else if(Double.class.isInstance(method)) {
//              cell = row.createCell(j, CellType.NUMERIC);
//              cell.setCellValue(String.valueOf(method));
//            }
//            else if (String.class.isInstance(method)) {
//              cell = row.createCell(j, CellType.STRING);
//              cell.setCellValue(String.valueOf(method.getReturnType()));
//            }
//          }
//
//          j++;
//        }
//        for (Method method : methods) {
//          String getterData = method.invoke(clazz).toString();
//
//        }
      String workingDir = System.getProperty("user.dir");
      File f = new File(workingDir + "/" + sheetName+".xlsx");
      try {
        FileOutputStream fileOutputStream = new FileOutputStream(f);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
      } catch (Exception e1) {
      }

    } catch (Exception e) {

    }
  }

  public static boolean isGetter(Method method) {
    if (!method.getName().startsWith("get")) {
      return false;
    }
    if (method.getParameterTypes().length != 0) {
      return false;
    }
    if (void.class.equals(method.getReturnType())) {
      return false;
    }
    return true;
  }
}
