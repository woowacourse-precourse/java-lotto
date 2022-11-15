package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static lotto.AscendingSorter.sortAscendingOrder;
import static resource.GeneralMessage.*;

public class LottoGame {
    public void startLottoGame() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        Purchaser purchaser = new Purchaser();
        int purchaseAmount = countPurchaseAmount(purchaser);

        NumbersMaker numbersMaker = new NumbersMaker();
        List<List<Integer>> purchaserNumbers = getPurchaserNumbers(purchaseAmount, numbersMaker);
        List<Integer> winningNumbers = inputWinningNumbers(numbersMaker);
        int bonusNumber = inputBonusNumber(numbersMaker);

        System.out.println(SHOW_PRIZE_MESSAGE);
        Calculator calculator = new Calculator();
        Integer[] answerNumbers = calculator.calculatePrizeNumber(purchaserNumbers, winningNumbers, bonusNumber);
        printWinnings(answerNumbers);
        printRate(purchaseAmount, calculator, answerNumbers);
    }

    private static List<List<Integer>> getPurchaserNumbers(int purchaseAmount, NumbersMaker numbersMaker) {
        List<List<Integer>> purchaserNumbers = numbersMaker.makePurchaserNumbers(purchaseAmount);
        printPurchaserNumbers(sortAscendingOrder(purchaserNumbers));
        return purchaserNumbers;
    }

    private static int countPurchaseAmount(Purchaser purchaser) {
        int purchaseAmount = purchaser.inputPurchaseAmount();
        countPurchaseGame(purchaser, purchaseAmount);
        return purchaseAmount;
    }

    private static void countPurchaseGame(Purchaser purchaser, int purchaseAmount) {
        int purchaseGame = purchaser.countPurchaseGame(purchaseAmount);
        System.out.println(purchaseGame + PRINT_PURCHASE_AMOUNT);
    }

    private static List<Integer> inputWinningNumbers(NumbersMaker numbersMaker) {
        System.out.println(INPUT_WINNING_NUMBER);
        String numbersWithComma = Console.readLine();
        List<Integer> winningNumbers = numbersMaker.makeWinningNumbers(numbersWithComma);
        return winningNumbers;
    }

    private static int inputBonusNumber(NumbersMaker numbersMaker) {
        System.out.println(INPUT_BONUS_NUMBER);
        int bonusNumber = numbersMaker.makeBonusNumber();
        return bonusNumber;
    }

    private static void printWinnings(Integer[] answerNumbers) {
        System.out.println(Rank.FIFTH.getCountingMessage() + answerNumbers[0] + "개");
        System.out.println(Rank.FOURTH.getCountingMessage() + answerNumbers[1] + "개");
        System.out.println(Rank.THIRD.getCountingMessage() + answerNumbers[2] + "개");
        System.out.println(Rank.SECOND.getCountingMessage() + answerNumbers[3] + "개");
        System.out.println(Rank.FIRST.getCountingMessage() + answerNumbers[4] + "개");
    }

    private static void printRate(int purchaseAmount, Calculator calculator, Integer[] answerNumbers) {
        double rate = calculator.calculateRate(calculator.sumPrize(answerNumbers), purchaseAmount);
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    public static void printPurchaserNumbers(List<List<Integer>> purchaserNumbers) {
        for (int i = 0; i < purchaserNumbers.size(); i++) {
            System.out.println(purchaserNumbers.get(i));
        }

    }
}
