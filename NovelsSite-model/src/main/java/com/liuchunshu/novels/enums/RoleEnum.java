package com.liuchunshu.novels.enums;

import java.util.HashMap;
import java.util.Map;

public enum RoleEnum implements BaseEnum<RoleEnum, Integer,String> {

	ADMINA("admin", 1), READER("reader", 2), WRITER("writer", 3);

	private int index;
	private String name;

	private RoleEnum(String name, int index) {
		this.index = index;
		this.name = name;
	}

	private static Map<Integer, RoleEnum> enumMap = new HashMap<Integer, RoleEnum>();

	static {
		for (RoleEnum role : RoleEnum.values()) {
			enumMap.put(role.getIndex(), role);
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static RoleEnum getEnum(int index) {
		return enumMap.get(index);
	}

	@Override
	public Integer getValue() {
		return this.index;
	}

	@Override
	public String getDisplayName() {
		return this.name;
	}
}
