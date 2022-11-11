package lotto.domain;

public class LottoSystem {
    private int userLottoNumber;
    private int userLottoCount;

    static final int STANDARD = 1000;

    public LottoSystem(User user) {
        this.userLottoNumber = user.getUserPayAmount();
        validate();
    }

    private void validate() {
        int remainder;

        remainder = userLottoNumber % STANDARD;
        if (remainder != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지지 않습니다.");
        }
    }

    private void setUserLottoCount(){
        this.userLottoCount = userLottoNumber / STANDARD;
    }
}
