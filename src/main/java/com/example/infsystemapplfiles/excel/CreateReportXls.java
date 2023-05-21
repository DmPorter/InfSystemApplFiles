package com.example.infsystemapplfiles.excel;

import com.example.infsystemapplfiles.helper.CostPrice;
import com.example.infsystemapplfiles.helper.OrderForReport;
import com.example.infsystemapplfiles.helper.SumOrders;
import com.example.infsystemapplfiles.models.Order;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CreateReportXls {

    public static String createReportByDate(List<Order> orders, String dateFrom, String dateTo) {
        try(Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Отчет");

            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("Номер");
            row.createCell(1).setCellValue("Дата и время");
            row.createCell(2).setCellValue("Стоимость");
            row.createCell(3).setCellValue("Себестоимость");
            row.createCell(4).setCellValue("Сотрудник");

            double sum = 0;
            for(int i = 0; i < orders.size(); i++){
                Order order = orders.get(i);
                row = sheet.createRow(i + 1);

                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(order.getDate().toString());

                double orderCost = order.getCost();
                sum += orderCost;

                row.createCell(2).setCellValue(orderCost);
                row.createCell(3).setCellValue(0);
                row.createCell(4).setCellValue(order.getPerson().getName());
            }

            row = sheet.createRow(orders.size() + 2);

            row.createCell(0).setCellValue("Сумма заказов");
            row.createCell(1).setCellValue(sum);

            row = sheet.createRow(orders.size() + 3);
            row.createCell(0).setCellValue("Общая прибыль");
            row.createCell(1).setCellValue(SumOrders.getCostPrice(OrderForReport.getOrders(orders)));

            row = sheet.createRow(orders.size() + 4);
            row.createCell(0).setCellValue("Всего заказов");
            row.createCell(1).setCellValue(orders.size());

            row = sheet.createRow(orders.size() + 5);
            row.createCell(0).setCellValue("Дата начала отчета");
            row.createCell(1).setCellValue(dateFrom);

            row = sheet.createRow(orders.size() + 6);
            row.createCell(0).setCellValue("Дата окончания отчета");
            row.createCell(1).setCellValue(dateTo);

            try(FileOutputStream out = new FileOutputStream(new File("C:\\Users\\dmitr\\IdeaProjects\\InfSystemApplFiles\\files\\" + dateFrom + "_" + dateTo + ".xls"))){
                workbook.write(out);
            }catch (IOException e) {
                e.printStackTrace();
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return "C:\\Users\\dmitr\\IdeaProjects\\InfSystemApplFiles\\files\\" + dateFrom + "_" + dateTo + ".xls";
    }
}
