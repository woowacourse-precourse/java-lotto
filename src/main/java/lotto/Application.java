package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static lotto.Constant.RequestMessage.INPUT_BONUS_NUMBER;
import static lotto.Constant.RequestMessage.INPUT_MONEY;
import static lotto.Constant.RequestMessage.INPUT_NUMBERS;

import static lotto.Rank.calculateRank;

import static lotto.Util.Converter.convertToInteger;
import static lotto.Util.Converter.convertToIntegerList;

import static lotto.Util.Printer.printProfits;

import java.util.List;
import lotto.Util.LottoNumberValidator;



public class Application {
    public static void calculateRanks(Buyer buyer, WinningLotto winningLotto) {
        for (Lotto userLotto : buyer.getLottos()) {
            Rank rank = calculateRank(userLotto, winningLotto);

            buyer.addRank(rank);
        }
    }

    public static Buyer createBuyer() {
        System.out.println(INPUT_MONEY);

        int money = convertToInteger(readLine());
        Buyer buyer = new Buyer(money);

        buyer.showLottos();

        return buyer;
    }

    public static WinningLotto createWinningLotto() {
        System.out.println(INPUT_NUMBERS);
        List<Integer> winningNumbers = convertToIntegerList(readLine());
        LottoNumberValidator.validateNumbers(winningNumbers);

        System.out.println(INPUT_BONUS_NUMBER);
        int bonusNumber = convertToInteger(readLine());

        return new WinningLotto(winningNumbers, bonusNumber);
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
