package com.example.infsystemapplfiles.controllers;

import com.example.infsystemapplfiles.excel.CreateReportXls;
import com.example.infsystemapplfiles.services.OrderService;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

@Controller
@RequestMapping("/order/file")
public class FileController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/report-date")
    public @ResponseBody byte[] getFile(@RequestParam String from, @RequestParam String to) throws IOException {
        String filepath = CreateReportXls.createReportByDate(orderService.getOrdersByDate(Timestamp.valueOf(from + " 0:0:01"),
                Timestamp.valueOf(to + " 23:59:59")), from, to);
        InputStream in = getClass().getResourceAsStream(filepath);
        assert in != null;
        return IOUtils.toByteArray(in);
    }
}
