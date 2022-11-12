package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static lotto.Converter.convertToInteger;
import static lotto.Converter.convertToIntegerList;

import static lotto.Printer.printProfits;
import static lotto.Rank.calculateRank;

import java.util.List;



public class Application {
    public static void calculateRanks(Buyer buyer, WinningLotto winningLotto) {
        for (Lotto userLotto : buyer.getLottos()) {
            Rank rank = calculateRank(userLotto, winningLotto);

            buyer.addRank(rank);
        }
    }

    public static void main(String[] args) {
        try {
            int money = convertToInteger(readLine());

            Buyer buyer = new Buyer(money);
            buyer.showLottos();

            List<Integer> winningNumbers = convertToIntegerList(readLine());
            int bonusNumber = convertToInteger(readLine());

            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

            calculateRanks(buyer, winningLotto);
            buyer.showWinnings();

            printProfits(buyer.getProfit());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
