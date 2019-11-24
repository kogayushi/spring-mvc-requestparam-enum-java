package sample;

public enum JvmLanguage implements EnumBase<JvmLanguage> {
    JAVA("10", "Java"),
    KOTLIN("20", "Kotlin"),
    SCALA("30", "Scala"),
    GROOVY("40", "Groovy");
    // 他にもあるけど、よく見聞きするものだけを取り上げる。

    private String code;
    private String genericName;

    @Override
    public String getCode() {
        return this.code;
    }

    public String getGenericName() {
        return this.genericName;
    }

    JvmLanguage(String code, String genericName) {
        this.code = code;
        this.genericName = genericName;
    }
}
