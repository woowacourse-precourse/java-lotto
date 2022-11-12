package lotto;

import java.util.List;

public class Checker extends LottoKiosk {
    public static void compare(List<Lotto> buyerLottos, int buyerBonusNumber) {
        for (Lotto lotto : buyerLottos) {
            int countSameNumbers = countSameNumbers(lotto);
        }

        int numberOfFirstPrizes = drawFirstPrize(buyerLottos);
        int numberOfSecondPrizes = drawSecondPrize();
        int numberOfThirdPrizes = drawThirdPrize(buyerNumbers);
        int numberOfFourthPrizes = drawFourthPrize(buyerNumbers);
        int numberOfFifthPrizes = drawFifthPrize(buyerNumbers);
    }

    public static int countSameNumbers(Lotto lotto) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (lotto.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    public static int drawFirstPrize(List<Integer> buyerNumbers) {
        if (buyerNumbers.equals(LottoKiosk.winningNumbers)) {
            return 1;
        }
        return 0;
    }

    public static int drawSecondPrize(List<Integer> buyerNumbers, List<Integer> winningNumbers,) {
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
