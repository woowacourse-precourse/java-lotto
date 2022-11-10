package lotto.lotteryshop;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input.InputAgent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {

    public int getPurchaseMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        InputAgent inputAgent = new InputAgent();
        int inputValue = inputAgent.inputUserMoney();
        System.out.printf("\n%d개를 구매했습니다.\n", inputValue / 1000);
        return inputValue / 1000;
    }

    public List<List<Integer>> generateLottoNumber(int purchaseNumber) {
        List<List<Integer>> generatedLottoPaper = new ArrayList<>();

        for (int number = 0; number < purchaseNumber; number++) {
            generatedLottoPaper.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return generatedLottoPaper;
    }

    public void getPublishedLottoNumber(List<List<Integer>> generatedLottoPaper) {
        for (List<Integer> eachLottoPaper : generatedLottoPaper) {
            System.out.println(Arrays.toString(eachLottoPaper.toArray()));
        }
        System.out.println();
    }
}
