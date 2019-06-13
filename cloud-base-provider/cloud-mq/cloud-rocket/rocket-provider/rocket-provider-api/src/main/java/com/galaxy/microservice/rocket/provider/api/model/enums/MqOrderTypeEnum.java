package com.galaxy.microservice.rocket.provider.api.model.enums;

public enum MqOrderTypeEnum {
	/**
	 * 有序.
	 */
	ORDER(1),
	/**
	 * 无序.
	 */
	DIS_ORDER(0);

	/**
	 * The Order type.
	 */
	int orderType;

	MqOrderTypeEnum(final int orderType) {
		this.orderType = orderType;
	}

	/**
	 * Order type int.
	 *
	 * @return the int
	 */
	public int orderType() {
		return orderType;
	}
}
