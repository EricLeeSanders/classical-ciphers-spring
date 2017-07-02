package com.ericleesanders.classicalciphers.web.dto.cipher;

import com.ericleesanders.classicalciphers.web.validation.CheckAlphabetic;

public class VigenereDTO {

    @CheckAlphabetic(message = "Key must not be empty and must be alphabetic.")
    private String vigenereKey;

    public VigenereDTO() {
    }

    public VigenereDTO(String vigenereKey) {
        this.vigenereKey = vigenereKey;
    }

    public String getVigenereKey() {

        return vigenereKey;
    }

    public void setVigenereKey(String vigenereKey) {

        this.vigenereKey = vigenereKey;
    }

    @Override
    public String toString() {

        return "VigenereDTO [vigenereKey=" + vigenereKey + "]";
    }
}
