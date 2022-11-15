package lotto.domain;


public class MoneyEnumClass {
    public enum MoneyEnum {
        FIFTH, FOURTH, THIRD
        , SECOND, FIRST
    }
    private String result[] = new String[MoneyEnum.values().length];

    public String getResult(MoneyEnum moneyEnum) {
        return result[moneyEnum.ordinal()];
    }

    public void setResult(MoneyEnum moneyEnum, String output) {
        result[moneyEnum.ordinal()] = output;
    }
}
