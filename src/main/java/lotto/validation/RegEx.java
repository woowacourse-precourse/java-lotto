package lotto.validation;

public enum RegEx {
    NUMBER_REG_EX("^[0-9]*$"),
    ZERO_REG_EX("^0$");

    private final String regEx;

    RegEx(String regEx) {
        this.regEx = regEx;
    }

    public String getRegEx() {
        return regEx;
    }
}
