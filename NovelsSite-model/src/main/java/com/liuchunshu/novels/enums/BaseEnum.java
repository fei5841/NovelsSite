package com.liuchunshu.novels.enums;

public interface BaseEnum<E extends Enum<?>, T1,T2> {

	public T1 getValue();
	public T2 getDisplayName();
}
