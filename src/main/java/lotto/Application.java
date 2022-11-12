package lotto;

import lotto.input.UserInput;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        List<List<Integer>> purchaseNumbers = new ArrayList<>();
        UserInput userInput = new UserInput();
        Integer prizeAmount = userInput.getPurchasePrice();
        System.out.println(prizeAmount + "개를 구매했습니다.");

        for (int i = 0; i < prizeAmount; i++) {
            List<Integer> integers = Lotto.generateRandomValue();
            System.out.println("integers = " + integers);
            purchaseNumbers.add(integers);
        }

        List<Integer> prizeNumber = userInput.getPrizeNumber();
        List<Integer> bounsNumber = userInput.getBounsNumber(prizeNumber);
        System.out.println(bounsNumber.toString());
        System.out.println("당첨 통계");
        System.out.println("---");

        Lotto lotto = new Lotto(bounsNumber);

        Integer integer = lotto.checkPrizes(purchaseNumbers, lotto);
        System.out.println("integer = " + integer + "개를 맞춤");
    }
}

/**
    구입금액을 입력해 주세요.
        8000

        8개를 구매했습니다.
        [8, 21, 23, 41, 42, 43]
        [3, 5, 11, 16, 32, 38]
        [7, 11, 16, 35, 36, 44]
        [1, 8, 11, 31, 41, 42]
        [13, 14, 16, 38, 42, 45]
        [7, 11, 30, 40, 42, 43]
        [2, 13, 22, 32, 38, 45]
        [1, 3, 5, 14, 22, 45]

        당첨 번호를 입력해 주세요.
        1,2,3,4,5,6

        보너스 번호를 입력해 주세요.
        7

        당첨 통계
        ---
        3개 일치 (5,000원) - 1개
        4개 일치 (50,000원) - 0개
        5개 일치 (1,500,000원) - 0개
        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
        6개 일치 (2,000,000,000원) - 0개
        총 수익률은 62.5%입니다.*/
