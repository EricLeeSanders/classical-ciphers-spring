package com.ericleesanders.classicalciphers.web.log;

public interface Logger {
	void add(String text);
	void add(Object obj);
	void addLine(String text);
	void addLine(Object obj);
}
