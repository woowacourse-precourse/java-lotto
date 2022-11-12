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
        System.out.println(bounsNumber.toString());
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Grade, Integer> gradeIntegerMap = prize.checkPrizes(purchaseNumbers, prizeNumber, bounsNumber);
    }
}