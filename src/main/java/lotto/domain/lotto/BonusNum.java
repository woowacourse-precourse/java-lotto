package lotto.domain.lotto;

import java.util.Objects;

public class BonusNum {
    private final int num;

    public BonusNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BonusNum bonusNum = (BonusNum) o;
        return num == bonusNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
