package view;

import camp.nextstep.edu.missionutils.Console;
import controller.MoneyController;
import domain.Money;

public class GameView {
    private static final String INPUT_PURCHASE_AMOUNT = "구매 금액 입력해 주세요.";
    private static final String NUMBER_OF_PURCHASE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요";
    private static final String INPUT_BOUNUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String STATISTICS = "당첨 통계";
    private static final String DIVIDING_LINE = "---";
    private static final String MATCH_COUNT = "개 일치 (";
    private static final String MATCH_COUNT_WITH_BOUNUS = "개 일치 , 보너스 볼 일치 (";
    private static final String REWARD = "원) - ";
    private static final String NUMBER_OF_MATCHES = "개";
    MoneyController moneyController = new MoneyController();

    public void start() {
        Money money = moneyController.getPurchaseAmount(inputPurchaseAmount());

        // 몇 장의 로또를 발행할 것인지 계산
        int purchaseNumber = moneyController.getAvailablePurchaseNumber(money);
        System.out.println("\n" + purchaseNumber + NUMBER_OF_PURCHASE);
    }

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        return Console.readLine();
    }
}

