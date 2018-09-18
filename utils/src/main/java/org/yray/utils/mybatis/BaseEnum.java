package org.yray.utils.mybatis;

public interface BaseEnum<E extends Enum<?>, T> {
	T getValue();
	String getDisplayName();
}