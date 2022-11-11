package lotto.domain;

public class Clerk {
    public int calculateNumberOfLottos(int money) {
        validate(money);
        return money / 1000;
    }

    private void validate(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해야 합니다.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }
    }
}
