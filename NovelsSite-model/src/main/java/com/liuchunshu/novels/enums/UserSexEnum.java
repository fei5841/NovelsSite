package com.liuchunshu.novels.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserSexEnum implements BaseEnum<UserSexEnum, Integer,String> {
	MAN("男", 1), WOMAN("女", 2);
	private int index;
	private String name;

	private static Map<Integer, UserSexEnum> enumMap = new HashMap<Integer, UserSexEnum>();

	static {
		for (UserSexEnum use : UserSexEnum.values()) {
			enumMap.put(use.getIndex(), use);
		}
	}

	private UserSexEnum(String name, int index) {
		this.name = name;
		this.index = index;
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

	public static UserSexEnum getEnum(int index) {
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
