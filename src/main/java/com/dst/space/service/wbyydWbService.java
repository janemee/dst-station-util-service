package com.dst.space.service;

import com.dst.station.bean.TransferWorkOrderReq;
import com.dst.station.service.SbyService;
import com.dst.steed.common.util.DstJsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class wbyydWbService {

    public static void main(String[] args) {
        String env = "test";
        String token = "i23af404de02d474fade67378e5be2d89";
//        List<String> userIds = Arrays.asList("116");
//        List<String> userName = Arrays.asList("彭亮奇");
//        TransferWorkOrderReq transferWorkOrderReq = new TransferWorkOrderReq();
//        transferWorkOrderReq.setOrderCodes(Arrays.asList("1136069613790203904"));
//        transferWorkOrderReq.setUserIds(userIds);
//        transferWorkOrderReq.setUserNames(userName);
//        SbyService.transferWorkOrder(env, token, transferWorkOrderReq);

//        String filePath = "D:\\download\\2026-05-22-10-33-42_EXPORT_XLSX_25659895_759_0.xlsx";
//        List<TransferWorkOrderReq> transferWorkOrderReqs = parseExcelFile(filePath);
//        for (TransferWorkOrderReq transferWorkOrderReq : transferWorkOrderReqs) {
//            SbyService.transferWorkOrder(env, token, transferWorkOrderReq);
////            String MongoDBSql = "update workorder set user_id = '" + userIds.get(0) + "',user_name = '" + userName.get(0) + "' where order_code = '" + orderCodes.get(0) + "'";
//        }



        System.out.println("完成");
    }


    /**
     * 解析Excel文件
     *
     * @param filePath 文件路径
     * @return 解析结果
     */
    public static List<TransferWorkOrderReq> parseExcelFile(String filePath) {
        System.out.println("解析Excel文件...");
        List<TransferWorkOrderReq> transferWorkOrderReqs = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(inputStream);
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                String sheetName = workbook.getSheetName(i);
                System.out.println("Sheet Name: " + sheetName);
                int numberOfRows = workbook.getSheetAt(i).getLastRowNum();
                for (int j = 1; j <= numberOfRows; j++) {
                    Row row = workbook.getSheetAt(i).getRow(j);
                    TransferWorkOrderReq transferWorkOrderReq = getRow(row);
                    if (transferWorkOrderReq == null) {
                        continue;
                    }
                    transferWorkOrderReqs.add(transferWorkOrderReq);
                }
            }
            System.out.println("解析完成，共" + transferWorkOrderReqs.size() + "条数据");
            return transferWorkOrderReqs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transferWorkOrderReqs;
    }

    /**
     * 解析每行内容
     *
     * @param row 行
     * @return 解析结果
     */
    public static TransferWorkOrderReq getRow(Row row) {
        if (row == null) {
            return null;
        }
        String orderCodes = row.getCell(6).getStringCellValue();
        String userIds = row.getCell(14).getStringCellValue();
        String userNames = row.getCell(15).getStringCellValue();


        if (StringUtils.isBlank(orderCodes) || StringUtils.isBlank(userIds) || StringUtils.isBlank(userNames)) {
            return null;
        }
        TransferWorkOrderReq transferWorkOrderReq = new TransferWorkOrderReq();
        transferWorkOrderReq.setOrderCodes(Collections.singletonList(orderCodes));
        transferWorkOrderReq.setUserIds(DstJsonUtil.toList(userIds, String.class));
        transferWorkOrderReq.setUserNames(DstJsonUtil.toList(userNames, String.class));
        return transferWorkOrderReq;
    }



}
