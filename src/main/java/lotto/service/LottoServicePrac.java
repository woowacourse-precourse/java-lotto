package lotto.service;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.LottoStore;
import lotto.domain.lotto_numbers.Lotto;
import lotto.domain.winning.LottoResults;
import lotto.domain.winning.Purchaser;
import lotto.domain.winning.WinningNumbers;

public class LottoServicePrac {

    private final LottoStore lottoStore;
    private final LottoMachine lottoMachine;

    public LottoServicePrac(LottoStore lottoStore, LottoMachine lottoMachine) {
        this.lottoStore = lottoStore;
        this.lottoMachine = lottoMachine;
    }

    public void lottery() {
        // 랜덤 발행
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(1, 2, 3, 4, 6, 10)),
                new Lotto(List.of(1, 2, 3, 8, 9, 10)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10))
        );

        // 발행한 로또 구매자
        Purchaser purchaser = new Purchaser(lottos);

        WinningNumbers winningNumbers = lottoMachine.winningNumbers("1,2,3,4,5,6", "7");

        LottoResults lottoResults = purchaser.lottoResults(winningNumbers);

        System.out.println(lottoResults.resultFormat());
    }

    public static void main(String[] args) {
        LottoServicePrac lottoServicePrac = new LottoServicePrac(
                new LottoStore(),
                new LottoMachine()
        );
        lottoServicePrac.lottery();
    }
}
