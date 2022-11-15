package lotto.domain;

import java.util.Objects;

public class LottoResult {

    private int sameCount;
    private boolean samePlusLotto;

    public LottoResult(int sameCount, boolean samePlusLotto) {
        this.sameCount = sameCount;
        this.samePlusLotto = samePlusLotto;
    }

    public int getSameCount() {
        return sameCount;
    }

    public boolean isSamePlusLotto() {
        return samePlusLotto;
    }

    public void setSamePlusLotto(boolean samePlusLotto) {
        this.samePlusLotto = samePlusLotto;
    }

    @Override
    public boolean equals(Object o) {
        LottoResult other = (LottoResult) o;
        if (this.samePlusLotto == other.samePlusLotto && this.sameCount == other.sameCount) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sameCount, samePlusLotto);
    }
}
