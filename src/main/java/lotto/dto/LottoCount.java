package lotto.dto;

public class LottoCount {

    private int lottoCount;
    private boolean bonus;

    public LottoCount(int lottoCount, boolean bonus) {
        this.lottoCount = lottoCount;
        this.bonus = bonus;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public boolean isBonus() {
        return bonus;
    }
}
