package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

public class LottoManager {
    public int inputLottoCount() {
        return Integer.parseInt(Console.readLine());
    }

    public void printLottoNumbers(Lotto[] lottos) {
        for (int i = 0; i < lottos.length; i++) {
            System.out.println(lottos[i].getNumbers());
        }
    }

    public void printRateOfReturn() { // 수익률 출력

    }
}
