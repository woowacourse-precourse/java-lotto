package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.LottoCalculator;

public class LottoManager {
    private int purchaseMoney;

    public int inputLottoCount() {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseMoney = Integer.parseInt(Console.readLine());
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

    public void printWinningDetails(LottoCalculator lottoCalculator) {
        System.out.println("3개 일치 (5,000원) - " + lottoCalculator.getRankCount().get(0) + "개");
        System.out.printf("4개 일치 (50,000원) - " + lottoCalculator.getRankCount().get(1) + "개");
        System.out.printf("5개 일치 (1,500,000원) - " + lottoCalculator.getRankCount().get(2) + "개");
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoCalculator.getRankCount().get(3) + "개");
        System.out.printf("6개 일치 (2,000,000,000원) - " + lottoCalculator.getRankCount().get(4) + "개");
    }

    public void printRateOfReturn(LottoCalculator lottoCalculator) {
        System.out.println("총 수익률은 " + lottoCalculator.getRateOfReturn(purchaseMoney) + "%입니다.");
    }
}
