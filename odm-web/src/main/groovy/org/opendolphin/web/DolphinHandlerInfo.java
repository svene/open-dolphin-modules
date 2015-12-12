package org.opendolphin.web;

import java.lang.reflect.Method;

public class DolphinHandlerInfo {
	public String id;
	public Method method;
	public Class<?> clazz;

	public DolphinHandlerInfo(String id, Method method, Class clazz) {
		this.id = id;
		this.method = method;
		this.clazz = clazz;
	}
}
