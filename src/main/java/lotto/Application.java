package lotto;

import lotto.input.UserInput;
import lotto.verifiable.CheckPrize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<List<Integer>> purchaseNumbers = new ArrayList<>();
        UserInput userInput = new UserInput();
        CheckPrize prize = new CheckPrize();
        Integer prizeAmount = userInput.getPurchasePrice();
        System.out.println(prizeAmount + "개를 구매했습니다.");

        for (int i = 0; i < prizeAmount; i++) {
            List<Integer> integers = Lotto.generateRandomValue();
            System.out.println("integers = " + integers);
            purchaseNumbers.add(integers);
        }
        List<Integer> prizeNumber = userInput.getPrizeNumber();
        Integer bounsNumber = userInput.getBounsNumber(prizeNumber);

        Map<Grade, Integer> gradeIntegerMap = prize.checkPrizes(purchaseNumbers, prizeNumber, bounsNumber);
        printGrade(gradeIntegerMap);
    }

    private static void printGrade(Map<Grade, Integer> gradeIntegerMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + gradeIntegerMap.get(Grade.FIVE) + "개");
        System.out.println("4개 일치 (50,000원) - " + gradeIntegerMap.get(Grade.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + gradeIntegerMap.get(Grade.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + gradeIntegerMap.get(Grade.SECOND) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + gradeIntegerMap.get(Grade.FIRST) + "개");
    }
}