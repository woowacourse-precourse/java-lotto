package lotto;

import java.util.Objects;

public class LottoHitsCountVO {
    private int hitsCount;
    private boolean hitsBonus;

    public LottoHitsCountVO() {
    }

    public LottoHitsCountVO(int hitsCount, boolean hitsBonus) {
        this.hitsCount = hitsCount;
        this.hitsBonus = hitsBonus;
    }

    public int getHitsCount() {
        return hitsCount;
    }

    public void setHitsCount(int hitsCount) {
        this.hitsCount = hitsCount;
    }

    public boolean isHitsBonus() {
        return hitsBonus;
    }

    public void setHitsBonus(boolean hitsBonus) {
        this.hitsBonus = hitsBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoHitsCountVO that = (LottoHitsCountVO) o;
        return hitsCount == that.hitsCount && hitsBonus == that.hitsBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hitsCount, hitsBonus);
    }

    @Override
    public String toString() {
        return "LottoHitDTO{" +
                "hitsCount=" + hitsCount +
                ", hitsBonus=" + hitsBonus +
                '}';
    }
}
