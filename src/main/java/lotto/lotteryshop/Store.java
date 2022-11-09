package lotto.lotteryshop;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.InputAgent;

import java.util.ArrayList;
import java.util.List;

public class Store {

    List<List<Integer>> generatedLottoPaper = new ArrayList<>();
    public int getPurchaseNumberOfLotto() {
        System.out.println("구매금액을 입력해 주세요.");
        InputAgent inputAgent = new InputAgent();
        int inputValue = inputAgent.inputUserMoney();
        System.out.printf("%d개를 구매했습니다.", inputValue / 1000);
        return inputValue;
    }

    public List<List<Integer>> generateLottoNumber(int purchaseNumber) {
        for (int number = 0; number < purchaseNumber; number++) {
            this.generatedLottoPaper.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return this.generatedLottoPaper;
    }
}
