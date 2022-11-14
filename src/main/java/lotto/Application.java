package lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lotto winningLottoWithEnterNumbers = LottoGenerator.createWinningLottoWithEnterNumbers();
        System.out.println(winningLottoWithEnterNumbers.getNumbers());
    }
}
