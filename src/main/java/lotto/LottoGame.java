package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottoList = new ArrayList<>();
    private int purchaseAmount;
    private int lottoAmount;
    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public LottoGame() {
        this.purchaseAmount = Input.EnterPurchaseAmount();
        this.lottoAmount = lottoAmount(purchaseAmount);
        makeLotto();
        printLottoList();
        winningNumbers = Input.EnterWinningNumber();
        bonusNumber = Input.EnterBonusNumber();
    }

    private int lottoAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return purchaseAmount / 1000;
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
}
