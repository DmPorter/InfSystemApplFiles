package com.example.infsystemapplfiles;

import com.example.infsystemapplfiles.excel.CreateReportXls;
import com.example.infsystemapplfiles.services.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
class InfSystemApplFilesApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        CreateReportXls.createReportByDate(orderService.getOrdersByDate(Timestamp.valueOf("2023-03-01" + " 0:0:01"),
                Timestamp.valueOf("2023-03-02" + " 23:59:59")), "2023-03-01", "2023-03-02" );
    }

}
