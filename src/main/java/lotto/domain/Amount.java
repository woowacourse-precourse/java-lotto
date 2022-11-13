package lotto.domain;

public class Amount {
    int value;

    public Amount(int value) {
        validateCanDivideIntoOneThousand(value);
        this.value = value;
    }

    private void validateCanDivideIntoOneThousand(int amount) {
        if (amount % 1000 == 0) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로만 입력 가능합니다.");
    }
}
