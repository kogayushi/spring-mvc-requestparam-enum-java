package sample;

public enum AltJs {
    TYPE_SCRIPT("10", "TypeScript"),
    FLOW("20", "Flow"),
    COFFEE_SCRIPT("30", "CoffeeScript");


    private String code;
    private String genericName;

    public String getCode() {
        return this.code = code;
    }

    public String getGenericName() {
        return this.genericName;
    }

    AltJs(String code, String genericName) {
        this.code = code;
        this.genericName = genericName;
    }
}
