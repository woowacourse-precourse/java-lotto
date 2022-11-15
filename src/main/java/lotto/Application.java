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
        try {
            int money = convertToInteger(readLine());
            Buyer buyer = new Buyer(money);

            buyer.showLottos();

            return buyer;
        } catch (Exception exception) {
            throw exception;
        }

    }

    public static List<Integer> inputNumbers() {
        System.out.println(INPUT_NUMBERS);

        try {
            List<Integer> winningNumbers = convertToIntegerList(readLine());
            LottoNumberValidator.validateNumbers(winningNumbers);

            return winningNumbers;
        } catch (Exception exception) {
            throw exception;
        }
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        
        try {
            int bonusNumber = convertToInteger(readLine());

            return bonusNumber;
        } catch (Exception exception) {
            throw exception;
        }
    }

    public static WinningLotto createWinningLotto() {
        try {
            List<Integer> winningNumbers = inputNumbers();
            int bonusNumber = inputBonusNumber();

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
