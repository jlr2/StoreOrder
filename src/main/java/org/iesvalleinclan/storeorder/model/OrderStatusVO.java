package org.iesvalleinclan.storeorder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum OrderStatusVO {

    CREATED(0), CONFIRMED(1), CANCELLED(2);

    private Integer value;
    private static Map<Integer, OrderStatusVO> map = new HashMap<>();

    static {
        for (OrderStatusVO orderStatusVO : OrderStatusVO.values()) {
            map.put(orderStatusVO.value, orderStatusVO);
        }
    }

    public static OrderStatusVO valueOf(int orderStatusValue) {
        return map.get(orderStatusValue);
    }
}
