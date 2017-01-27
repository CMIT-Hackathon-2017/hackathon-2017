package com.nordea.hackathon2017.pojo;

public enum ProgrammingLanguage {

    DEFAULT(0),
    JAVA(1),
    C_SHARP(2),
    PYTHON(3),
    CPP(4);

    private int code;

    ProgrammingLanguage(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ProgrammingLanguage getInstance(int code_language_id) {
        for (ProgrammingLanguage pl : values()) {
            if (pl.getCode() == code_language_id) {
                return pl;
            }
        }
        return DEFAULT;
    }
}
