package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private static final String requestPurchaseAmountMessage = "구입금액을 입력해 주세요.";
    private static final String purchasedLottoCountMessage = "개를 구매했습니다.";
    private static final String requestWinningNumbersMessage = "당첨 번호를 입력해 주세요.";
    private static final String requestBonusNumberMessage = "보너스 번호를 입력해 주세요.";

    public String readLine(){
        return Console.readLine();
    }

    public void printInputMoneyMenu() {
        print(requestPurchaseAmountMessage);
    }
    public void printLottoCount(int lottoCount){
        print("");
        print(lottoCount+purchasedLottoCountMessage);
    }

    public void printInputWinningNumbersMenu(){
        print(requestWinningNumbersMessage);
    }

    public void printInputBonusNumberMenu(){
        print("");
        print(requestBonusNumberMessage);
    }

    public void printRankStatistic(String rankStatistic) {
        print("");
        print(rankStatistic);
    }

    public void print(String string){
        System.out.println(string);
    }
}
