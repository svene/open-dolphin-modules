package org.opendolphin.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DolphinClassesHolder implements Serializable{

	public transient Set<Class<?>> dolphinHandlerClasses;
	public transient Map<String, DolphinHandlerInfo> handlerMap;

	public DolphinClassesHolder(Set<Class<?>> dolphinHandlerClasses) {
		this.dolphinHandlerClasses = dolphinHandlerClasses;
	}

	public void setHandlerMap(Map<String, DolphinHandlerInfo> handlerMap) {
		this.handlerMap = handlerMap;
	}

}
