package org.mowitnow.parser;

import com.google.common.collect.Lists;
import org.mowitnow.bean.Order;

import java.util.List;

/**
 * Created by home on 10/05/2014.
 */
public class OrdersParser extends AbstractParser<List<Order>> {

    public OrdersParser(String line) {
        super(line);
    }

    @Override
    protected List<Order> process() {
        List<Order> orders = Lists.newArrayList();

        char[] orderTab = line.trim().toCharArray();
        for (char order : orderTab) {
            orders.add(Order.valueOf(Character.toString(order)));
        }
        return orders;
    }

    @Override
    protected String getRegex() {
        return "^[ADG]{1,}$";
    }

}
