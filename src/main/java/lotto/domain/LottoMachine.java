package lotto.domain;

import java.util.List;

public class LottoMachine {
    private LottoList lottoList;
    private List<Integer> winningNumber;

    public LottoMachine(LottoList lottoList, List<Integer> winningNumber) {
        this.lottoList = lottoList;
        this.winningNumber = winningNumber;
    }


}
