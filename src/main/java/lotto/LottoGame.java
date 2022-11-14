package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottoList = new ArrayList<>();
    private long purchaseAmount;
    private int lottoAmount;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Integer> statistics = new ArrayList<>();
    private double proceeds = 0;

    public LottoGame() {
        this.purchaseAmount = Input.EnterPurchaseAmount();
        this.lottoAmount = lottoAmount(purchaseAmount);
        makeLotto();
        printLottoList();
        winningNumbers = Input.EnterWinningNumber();
        bonusNumber = Input.EnterBonusNumber();
        for (int i = 0; i < 5; i++) {
            statistics.add(0);
        }
        calculationLottoStatistics();
        calculateProceeds();
        printLottoStatistics();
    }

    private int lottoAmount(long purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return (int) (purchaseAmount / 1000);
    }

    private void makeLotto() {
        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
    }

    private void printLottoList() {
        System.out.println(lottoAmount + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
        System.out.println();
    }

    private void calculationLottoStatistics() {
        for (Lotto lotto : lottoList) {
            List<Integer> lottoResult = lotto.checkLottoNumber(winningNumbers, bonusNumber);
            if (firstPlace(lottoResult)) continue;
            if (secondPlace(lottoResult)) continue;
            if(thirdPlace(lottoResult)) continue;
            if(fourthPlace(lottoResult)) continue;
            fifthPlace(lottoResult);
        }
    }

    private boolean firstPlace(List<Integer> lottoResult) {
        if (lottoResult.get(0) == 6) {
            statistics.set(0, statistics.get(0) + 1);
            return true;
        }
        return false;
    }

    private boolean secondPlace(List<Integer> lottoResult) {
        if (lottoResult.get(0) == 5 && lottoResult.get(1) == 1) {
            statistics.set(1, statistics.get(1) + 1);
            return true;
        }
        return false;
    }

    private boolean thirdPlace(List<Integer> lottoResult) {
        if (lottoResult.get(0) == 5 && lottoResult.get(1) == 0) {
            statistics.set(2, statistics.get(2) + 1);
            return true;
        }
        return false;
    }

    private boolean fourthPlace(List<Integer> lottoResult) {
        if (lottoResult.get(0) == 4) {
            statistics.set(3, statistics.get(3) + 1);
            return true;
        }
        return false;
    }

    private void fifthPlace(List<Integer> lottoResult) {
        if (lottoResult.get(0) == 3) {
            statistics.set(4, statistics.get(4) + 1);
        }
    }

    private void printLottoStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + statistics.get(4) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get(3) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistics.get(1) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get(0) + "개");
        System.out.println("총 수익률은 "+ Math.abs((double)(proceeds * 100) / (double)purchaseAmount) + "%입니다.");
    }

    private void calculateProceeds() {
        proceeds += statistics.get(0) * 2000000000;
        proceeds += statistics.get(1) * 30000000;
        proceeds += statistics.get(2) * 1500000;
        proceeds += statistics.get(3) * 50000;
        proceeds += statistics.get(4) * 5000;
    }
}
