package lotto;

import java.util.List;

public class Checker extends LottoKiosk {
    public static void compare(List<Integer> buyerNumbers, List<Integer> winningNumbers) {
        int numberOfFirstPrizes = drawFirstPrize(buyerNumbers, winningNumbers);
        int numberOfSecondPrizes = drawSecondPrize(buyerNumbers, winningNumbers);
        int numberOfThirdPrizes = drawThirdPrize(buyerNumbers, winningNumbers);
        int numberOfFourthPrizes = drawFourthPrize(buyerNumbers, winningNumbers);
        int numberOfFifthPrizes = drawFifthPrize(buyerNumbers, winningNumbers);
    }

    public static int drawFirstPrize(List<Integer> buyerNumbers, List<Integer> winningNumbers) {
        if (buyerNumbers.equals(winningNumbers)) {
            return 1;
        }
        return 0;
    }

    public static int drawSecondPrize(List<Integer> buyerNumbers, List<Integer> winningNumbers) {
        return 0;
    }

    public static int drawThirdPrize(List<Integer> buyerNumbers, List<Integer> winningNumbers) {
        return 0;
    }

    public static int drawFourthPrize(List<Integer> buyerNumbers, List<Integer> winningNumbers) {
        return 0;
    }

    public static int drawFifthPrize(List<Integer> buyerNumbers, List<Integer> winningNumbers) {
        return 0;
    }
}
