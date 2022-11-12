package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static lotto.Converter.convertToInteger;
import static lotto.Converter.convertToIntegerList;

import static lotto.Printer.printProfits;

import static lotto.Rank.calculateRank;

import lotto.Constant.RequestMessage;

import java.util.List;




public class Application {
    public static void calculateRanks(Buyer buyer, WinningLotto winningLotto) {
        for (Lotto userLotto : buyer.getLottos()) {
            Rank rank = calculateRank(userLotto, winningLotto);

            buyer.addRank(rank);
        }
    }

    public static Buyer createBuyer() {
        System.out.println(RequestMessage.INPUT_MONEY);

        int money = convertToInteger(readLine());
        Buyer buyer = new Buyer(money);

        buyer.showLottos();

        return buyer;
    }

    public static WinningLotto createWinningLotto() {
        try {
            System.out.println(RequestMessage.INPUT_NUMBERS);
            List<Integer> winningNumbers = convertToIntegerList(readLine());
            LottoNumberValidator.validateNumbers(winningNumbers);

            System.out.println(RequestMessage.INPUT_BONUS_NUMBER);
            int bonusNumber = convertToInteger(readLine());

            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (Exception exception) {
            throw exception;
        }
    }

    public static void main(String[] args) {
        try {
            Buyer buyer = createBuyer();
            WinningLotto winningLotto = createWinningLotto();

            calculateRanks(buyer, winningLotto);
            buyer.showWinnings();

            printProfits(buyer.getProfit());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
