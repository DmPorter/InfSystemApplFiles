package com.example.infsystemapplfiles.helper;

import com.example.infsystemapplfiles.models.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderForReport {

    private long idOrder;

    private Timestamp date;

    private double sum = 0;

    private double costPrice = 0;


    public static List<OrderForReport> getOrders(List<Order> list){
        List<OrderForReport> orderForReportList = new ArrayList<>();

        for(var val: list){
            orderForReportList.add(new OrderForReport(val));
        }
        return orderForReportList;
    }

    public OrderForReport(Order order){
        this.idOrder = order.getIdOrder();
        this.date = order.getDate();

        countSumOrder(order.getOrderPositions());

        countCostPriceOrder(order.getOrderPositions());
    }

    private void countSumOrder(List<OrderPosition> orderPositionList){
        for(OrderPosition val: orderPositionList){
            sum += val.getQuantity() * val.getRecipe().getCost() + val.getCostAdditives();
        }
    }

    private void countCostPriceOrder(List<OrderPosition> orderPositionList){
        for(OrderPosition val: orderPositionList){
            costPrice += CostPrice.getCostPrice(val.getRecipe().getIngredients());

            for(var add: val.getList()){
                costPrice += add.getQuantity() *
                        add.getAdditive().getQuantity() *
                        add.getAdditive().getProduct().getCost();
            }
        }
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }
}
