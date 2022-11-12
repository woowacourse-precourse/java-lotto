package lotto.view;

import lotto.Lotto;

public class LottoManager {
    public void printLottoNumbers(Lotto[] lottos) {
        for (int i = 0; i < lottos.length; i++) {
            System.out.println(lottos[i].getNumbers());
        }
    }

    public void printRateOfReturn() { // 수익률 출력

    }
}
