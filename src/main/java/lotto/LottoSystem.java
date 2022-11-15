package lotto;

import java.util.*;

public class LottoSystem {
    private LottoSystem(){}

    public static LottoSystem newLottoSystem() {
        return new LottoSystem();
    }

    public void run() {
        try {
            int money = Integer.parseInt(UserInput.getLottoMoney());
            validateMoneyOver(money);
            validateMoneyDivison(money);
            List<List<Integer>> lottoUser = LottoFunction.buyLottoUserPaid(money);
            WinningNumbers winningNum = LottoFunction.makeWinningLotto();
            Map<Integer,Integer> matchLottos = LottoFunction.matchAllLottos(lottoUser, winningNum);
            Map<String, Integer> countLottos = LottoFunction.printAllMatchResult(matchLottos);
            LottoFunction.printYield(countLottos, money);
        }
        catch (NumberFormatException e) {
            System.out.println("[ERROR]금액은 정수만 입력 가능합니다.");
        }
    }

    private void validateMoneyOver(int money) {
        if (money < 1_000) {
            System.out.println("[ERROR] 로또 구입을 위한 최소 금액은 " + 1_000 + "원 입니다.");
        }
    }

    private void validateMoneyDivison(int money) {
        if (money % 1_000 != 0){
            System.out.println("[ERROR] 로또는 " + 1_000 + "원 단위로만 구매할 수 있습니다.");
        }
    }

}
