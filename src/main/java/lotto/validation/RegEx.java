package lotto.validation;

public enum RegEx {
    NUMBER_REG_EX("^[0-9]*$"),
    ZERO_REG_EX("^0$"),
    WINNING_INPUT_REG_EX("^([1-9],{1}|[1-4]{1}[0-5]{1},){5}([1-9]{1}|[1-4]{1}[0-5]{1}){1}$");

    private final String regEx;

    RegEx(String regEx) {
        this.regEx = regEx;
    }

    public String getRegEx() {
        return regEx;
    }
}
