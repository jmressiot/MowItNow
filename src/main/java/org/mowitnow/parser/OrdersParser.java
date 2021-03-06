package org.mowitnow.parser;

import com.google.common.collect.Lists;
import org.mowitnow.bean.Order;

import java.util.List;

public class OrdersParser extends AbstractParser<List<Order>> {

    public OrdersParser(String line) {
        super(line);
    }

    @Override
    protected List<Order> process() {
        List<Order> orders = Lists.newArrayList();

        char[] orderTab = getLine().trim().toCharArray();
        for (char order : orderTab) {
            orders.add(Order.valueOf(Character.toString(order)));
        }
        return orders;
    }

    @Override
    protected String getRegex() {
        Order[] orders = Order.values();
        String orderList = "";
        for (Order order : orders) {
            orderList = orderList + order.name();
        }

        return "^[" + orderList + "]{1,}$";
    }

}
