package lotto.Enum;

public enum ConstantString {

    REGEX_ONLY_NUMBER("[0-9]+"),
    ;

    final private String value;

    ConstantString(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
