package lotto.computer.lottoNumber;

import java.util.List;

public class LottoNumber {

    private List<Integer> Lotto;

    public LottoNumber(List<Integer> lotto) {
        Lotto = lotto;
    }

    public List<Integer> getLotto() {
        return Lotto;
    }

    public void setLotto(List<Integer> lotto) {
        Lotto = lotto;
    }
}
