package lotto;

import lotto.input.UserInput;
import lotto.verifiable.CheckPrize;
import lotto.verifiable.CheckProfit;
import lotto.verifiable.PrizeMoney;

import java.util.List;
import java.util.Map;

import static lotto.verifiable.CheckPrize.printGrade;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        CheckPrize prize = new CheckPrize();

        Integer prizeAmount = userInput.getPurchasePrice();
        Lotto lotto = userInput.getPrizeNumber();
        Integer bounsNumber = userInput.getBounsNumber();

        List<List<Integer>> purchaseNumbers = Lotto.generateRandomValues(prizeAmount);
        List<Integer> prizeNumber = lotto.getNumbers();

        Map<PrizeMoney, Integer> gradeIntegerMap = prize.checkPrizes(purchaseNumbers, prizeNumber, bounsNumber);
        printGrade(gradeIntegerMap);
        CheckProfit.printBenefit(gradeIntegerMap,prizeAmount);
    }
}