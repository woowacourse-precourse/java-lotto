package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.LottoCalculator;

public class LottoManager {
    private int purchaseMoney;

    public int inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        checkNumber(money);
        purchaseMoney = Integer.parseInt(money);
        checkAdequateMoney(purchaseMoney);
        return purchaseMoney / 1000;
    }

    public void checkNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자가 아닌 문자 입력");
        }
    }

    public void checkAdequateMoney(int purchaseMoney) {
        if (purchaseMoney % 1000 > 0) {
            throw new IllegalArgumentException("1000원 단위로 입력하세요");
        }
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
//        for (int i = 0; i < lottos.length; i++) {
//            System.out.println(lottos[i].getNumbers());
//        }
    }

    public String inputWinningNumbers() {
        System.out.println("당첨번호를 입력해주세요.");
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        checkNumber(bonusNumber);
        return bonusNumber;
//        return Console.readLine();
    }

    public void printWinningDetails(List<Integer> rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + rankCount.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCount.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCount.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCount.get(4) + "개");
//        System.out.println("3개 일치 (5,000원) - " + lottoCalculator.getRankCount().get(0) + "개");
//        System.out.println("4개 일치 (50,000원) - " + lottoCalculator.getRankCount().get(1) + "개");
//        System.out.println("5개 일치 (1,500,000원) - " + lottoCalculator.getRankCount().get(2) + "개");
//        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoCalculator.getRankCount().get(3) + "개");
//        System.out.println("6개 일치 (2,000,000,000원) - " + lottoCalculator.getRankCount().get(4) + "개");
    }

    public void printRateOfReturn(LottoCalculator lottoCalculator) {
        System.out.println("총 수익률은 " + String.format("%.1f",lottoCalculator.RateOfReturn(purchaseMoney)) + "%입니다.");
    }
}
