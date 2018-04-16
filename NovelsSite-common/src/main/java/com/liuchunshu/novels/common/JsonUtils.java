package com.liuchunshu.novels.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {

	private static final String DEFAULT_FIELD_NAME = "DisplayName";

	/**
	 * Object javabean 需要转成json的对象 String[] enumFieldName 对象中enum类型成员需要显示的字段名称。
	 * return json
	 * 
	 */
	public static String formatEnumValue(Object javabean, String... enumFieldName) {
		if (enumFieldName == null || enumFieldName.length == 0) {
			enumFieldName = new String[] { DEFAULT_FIELD_NAME };
		}
		JSONObject json = new JSONObject();
		int i = 0;
		try {
			// 获取clazz类的所有属性已经父类的所有属性
			Class<?> claz = javabean.getClass();
			Field[] fields = claz.getDeclaredFields();
			for (Field field : fields) {
				String fieldName = field.getName();
				if ("serialVersionUID".equalsIgnoreCase(fieldName)) {
					continue;
				}
				Object temp = null;

				Method med = claz.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
				temp = med.invoke(javabean);

				if (field.getType().isEnum()) {
					if (i > enumFieldName.length - 1) {
						i = enumFieldName.length - 1;
					}
					Class<?> type = field.getType();
					med = type.getMethod(
							"get" + enumFieldName[i].substring(0, 1).toUpperCase() + enumFieldName[i].substring(1));
					if (enumFieldName.length > 1) {
						i++;
					}
					temp = med.invoke(temp);
				}
				json.put(fieldName, temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return json.toJSONString();
	}

	/**
	 * Object javabean 需要转成json的对象 String[] nofieldname 需要隐藏的字段，即不在json中显示的字段
	 * String[] enumFieldName 对象中enum类型成员需要显示的字段名称。 return json
	 * 
	 */
	public static String formatEnumValueWithNoField(Object javabean, String[] nofieldname, String... enumFieldName) {
		if (enumFieldName == null || enumFieldName.length == 0) {
			enumFieldName = new String[] { DEFAULT_FIELD_NAME };
		}
		JSONObject json = new JSONObject();
		int i = 0;
		try {
			// 获取clazz类的所有属性已经父类的所有属性
			Class<?> claz = javabean.getClass();
			Field[] fields = claz.getDeclaredFields();
			label1: for (Field field : fields) {
				String fieldName = field.getName();
				for (String tempstr : nofieldname) {
					if (tempstr.equalsIgnoreCase(fieldName)) {
						continue label1;
					}
				}
				if ("serialVersionUID".equalsIgnoreCase(fieldName)) {
					continue label1;
				}
				Object temp = null;

				Method med = claz.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
				temp = med.invoke(javabean);

				if (field.getType().isEnum()) {
					if (i > enumFieldName.length - 1) {
						i = enumFieldName.length - 1;
					}
					Class<?> type = field.getType();
					med = type.getMethod(
							"get" + enumFieldName[i].substring(0, 1).toUpperCase() + enumFieldName[i].substring(1));
					if (enumFieldName.length > 1) {
						i++;
					}
					temp = med.invoke(temp);
				}
				json.put(fieldName, temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return json.toJSONString();
	}
}
