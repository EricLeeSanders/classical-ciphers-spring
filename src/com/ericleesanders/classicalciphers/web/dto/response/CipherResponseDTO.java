package com.ericleesanders.classicalciphers.web.dto.response;

import javax.validation.Valid;

import com.ericleesanders.classicalciphers.web.dto.cipher.TextDTO;

public class CipherResponseDTO<Cipher> {
    @Valid
    private Cipher cipher;
    @Valid
    private TextDTO text;

    private String log;

    public CipherResponseDTO() {
    }

    public CipherResponseDTO(Cipher cipher, TextDTO text, String log) {
        this.cipher = cipher;
        this.text = text;
        this.log = log;
    }

    public Cipher getCipher() {

        return cipher;
    }

    public void setCipher(Cipher cipher) {

        this.cipher = cipher;
    }

    public TextDTO getText() {

        return text;
    }

    public void setText(TextDTO text) {

        this.text = text;
    }

    public String getLog() {

        return log;
    }

    public void setLog(String string) {

        this.log = string;
    }

    @Override
    public String toString() {

        return "CipherResponseDTO [cipher=" + cipher + ", text=" + text + "]";
    }

}
