package domain;

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
                throw new IllegalArgumentException("[ERROR] 돈에 문자는 포함될 수 없습니다.");
        }
    }

    private void isDividedInto1000(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 1000원 단위여야 합니다.");
        }
    }

    public Integer getValue() {
        return this.value;
    }

}
