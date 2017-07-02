package com.ericleesanders.classicalciphers.web.log;

public interface Logger {

    /**
     * Add a String of text
     * 
     * @param text
     */
    void add(String text);

    /**
     * Add an Object's toString
     * 
     * @param obj
     */
    void add(Object obj);

    /**
     * Add a String of text and create a new line
     * 
     * @param text
     */
    void addLine(String text);

    /**
     * Add an Object's toString and create a new line
     * 
     * @param obj
     */
    void addLine(Object obj);
}
