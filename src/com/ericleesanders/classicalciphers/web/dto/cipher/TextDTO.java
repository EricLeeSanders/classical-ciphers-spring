package com.ericleesanders.classicalciphers.web.dto.cipher;

import com.ericleesanders.classicalciphers.web.validation.CheckAlphabetic;

public class TextDTO {

    @CheckAlphabetic(message = "Text must not be empty and must be alphabetic.")
    private String text;

    public TextDTO() {
    }

    public TextDTO(String text) {
        this.text = text;
    }

    public String getText() {

        return text;
    }

    public void setText(String text) {

        this.text = text;
    }

    @Override
    public String toString() {

        return "TextDTO [text=" + text + "]";
    }
}
