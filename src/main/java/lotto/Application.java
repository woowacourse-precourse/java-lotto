package lotto;

import lotto.input.UserInput;
import lotto.verifiable.CheckPrize;
import lotto.verifiable.CheckProfit;
import lotto.verifiable.PrizeMoney;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        CheckPrize prize = new CheckPrize();

        Integer prizeAmount = userInput.getPurchasePrice();
        Integer bounsNumber = userInput.getBounsNumber();

        Lotto lotto = userInput.getPrizeNumber();
        List<List<Integer>> purchaseNumbers = lotto.generateRandomValues(prizeAmount);
        List<Integer> prizeNumber = lotto.getNumbers();

        Map<PrizeMoney, Integer> gradeIntegerMap = prize.checkPrizes(purchaseNumbers, prizeNumber, bounsNumber);
        printGrade(gradeIntegerMap);
        CheckProfit.printBenefit(gradeIntegerMap,prizeAmount);
    }


    private static void printGrade(Map<PrizeMoney, Integer> gradeIntegerMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + gradeIntegerMap.get(PrizeMoney.FIVE) + "개");
        System.out.println("4개 일치 (50,000원) - " + gradeIntegerMap.get(PrizeMoney.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + gradeIntegerMap.get(PrizeMoney.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + gradeIntegerMap.get(PrizeMoney.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + gradeIntegerMap.get(PrizeMoney.FIRST) + "개");
    }
}