package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;

public class LottoManager {
    public int inputLottoCount() {
        int purchaseMoney = Integer.parseInt(Console.readLine());
        if (purchaseMoney % 1000 > 0) {
            throw new IllegalArgumentException();
        }
        return purchaseMoney / 1000;
    }

    public void printLottoNumbers(Lotto[] lottos) {
        for (int i = 0; i < lottos.length; i++) {
            System.out.println(lottos[i].getNumbers());
        }
    }

    public String inputWinningNumbers() {
        System.out.println("당첨번호를 입력해주세요.");
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
