package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Service service = new Service();

        try {
            view.lottoStartMsg();
            String moneyInput = service.getMoneyInput();

            view.purchaseMsg(moneyInput);
            List<List<Integer>> lottoNumberList = service.createNumber(moneyInput);

            view.registerWinningNumberMsg();
            String winningNumberInput = service.getWinningNumberInput();

            view.registerLuckyNumberMsg();
            String luckyNumberInput = service.getLuckyNumberInput(winningNumberInput);

            view.resultInitMsg();
            List<Integer> winnerList = service.countWinner(lottoNumberList, winningNumberInput, luckyNumberInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
