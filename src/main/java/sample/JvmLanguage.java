package sample;

public enum JvmLanguage implements EnumBase<JvmLanguage> { // 1. Genericsに自分自身を指定してEnumであることをEnumBaseに教える
    JAVA("10", "Java"), // 2. コード値とともにEnumを宣言する
    KOTLIN("20", "Kotlin"),
    SCALA("30", "Scala"),
    GROOVY("40", "Groovy");
    // Jvm言語は他にもあるが、よく見聞きするものだけを取り上げている。ここでマサカリは欲しくない…。

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
