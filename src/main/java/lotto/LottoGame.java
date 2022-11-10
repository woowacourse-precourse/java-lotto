package lotto;

import java.util.List;


public class LottoGame {
    //로또의 당첨결과를 계산하는 클래스
    Integer buyPrice;
    Integer bonusNumber;
    Lotto winningLotto;
    List<Lotto> publishedLottos;

    public LottoGame(Integer buyPrice, Integer bonusNumber, Lotto winningLotto, List<Lotto> publishedLottos) {
        this.buyPrice = buyPrice;
        this.bonusNumber = bonusNumber;
        this.winningLotto = winningLotto;
        this.publishedLottos = publishedLottos;
    }

    public void play() {
    }

    //private LottoResult calculateResult() {}
}
