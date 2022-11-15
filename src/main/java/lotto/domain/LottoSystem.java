package lotto.domain;

import lotto.Constant;

public class LottoSystem {
    private int userLottoNumber;
    private int userLottoCount;

    public LottoSystem(User user) {
        this.userLottoNumber = user.getUserPayAmount();
        validate();
    }

    private void validate() {
        int remainder;

        remainder = userLottoNumber % Constant.LOTTO_STANDARD.getNum();
        if (remainder != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지지 않습니다.");
        }
    }

    public void setUserLottoCount() {
        this.userLottoCount = userLottoNumber / Constant.LOTTO_STANDARD.getNum();
    }

    public Integer getUserLottoCount() {
        return userLottoCount;
    }

}
