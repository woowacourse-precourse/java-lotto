package lotto.domain;

public class LottoSystem {
    private int userLottoNumber;

    public LottoSystem(User user) {
        this.userLottoNumber = user.getUserPayAmount();
        validate();
    }

    private void validate() {
        final int STANDARD = 1000;
        int remainder;

        remainder = userLottoNumber % STANDARD;
        if (remainder != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지지 않습니다.");
        }
    }
}
