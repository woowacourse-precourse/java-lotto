package domain;

import ui.ExceptionMessage;

public class Money {

    private Integer value;

    public Money(String money) {
        onlyContainsNumber(money);
        isDividedInto1000(money);
        this.value = Integer.parseInt(money);
    }

    private void onlyContainsNumber(String money) {
        for (char ele : money.toCharArray()) {
            if (ele < 48 || ele > 57)
                throw new IllegalArgumentException(ExceptionMessage.IS_NOT_ONLY_CONTAINS_NUMBER.getTxt());
        }
    }

    private void isDividedInto1000(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIVIDED_INTO_1000.getTxt());
        }
    }

    public Integer getValue() {
        return this.value;
    }

}
