package com.ericleesanders.classicalciphers.web.log;

public class CipherLogger implements Logger {

    private StringBuilder sb = new StringBuilder();

    @Override
    public void add(String text) {

        sb.append(text);
    }

    @Override
    public void add(Object obj) {

        add(obj.toString());
    }

    @Override
    public void addLine(String text) {

        add(text);
        sb.append(System.lineSeparator());
    }

    @Override
    public void addLine(Object obj) {

        addLine(obj.toString());
    }

    @Override
    public String toString() {

        return sb.toString();
    }

}
