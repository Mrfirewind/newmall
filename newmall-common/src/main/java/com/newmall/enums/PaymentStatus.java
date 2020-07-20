package com.newmall.enums;

/**
 * @Description: 订单状态 枚举
 */
public enum PaymentStatus {

	WAIT_PAY(10, "待付款"),
	PAID(20, "已付款，待发货");

	public final Integer type;
	public final String value;

	PaymentStatus(Integer type, String value){
		this.type = type;
		this.value = value;
	}

}
