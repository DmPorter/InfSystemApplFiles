package com.example.infsystemapplfiles.helper;



import com.example.infsystemapplfiles.models.Order;
import com.example.infsystemapplfiles.models.OrderPosition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOrders {

    public static double getCostPrice(List<OrderForReport> list){
        double sum = 0;
        for(OrderForReport order: list){
            sum += order.getSum() - order.getCostPrice();
        }
        return sum;
    }

    public static double getSum(List<OrderForReport> list){
        double sum = 0;
        for(OrderForReport order: list){
            sum += order.getSum();
        }
        return sum;
    }

    public static double getSumOrder(Order order){
        double sum = 0;

        for(OrderPosition value: order.getOrderPositions()){
            sum += value.getQuantity() * value.getRecipe().getCost();
        }

        return sum;
    }

}
