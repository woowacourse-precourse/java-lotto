package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int[] counts = new int[6];
        int bonus = 0;
        long purchaseMoney = 0, lottoCounts = 0, profit = 0;
        String inputPurchaseMoney = "", inputBonus = "", inputWinNumbers = "", profitRate = "";
        List<Integer> winNumbers = new ArrayList<>();
        List<Lotto> purchasedLotteries = new ArrayList<>();

        System.out.println(Notification.INPUT_PURCHASE_AMOUNT.getMessage());
        inputPurchaseMoney = Console.readLine();
        if (!checkInputPurchaseMoney(inputPurchaseMoney))
            return;
        purchaseMoney = Long.parseLong(inputPurchaseMoney);

        lottoCounts = purchaseMoney / 1000;
        System.out.println(String.format(Notification.PURCHASE_COUNT.getMessage(), lottoCounts));
        for (int i = 0; i < lottoCounts; i++) {
            Lotto lotto = new Lotto(Creation.lotto());
            purchasedLotteries.add(lotto);
            System.out.println(lotto.getLotto());
        }

        System.out.println(Notification.INPUT_WIN_NUMBERS.getMessage());
        inputWinNumbers = Console.readLine();
        if (!checkInputWinNumbers(inputWinNumbers))
            return;
        winNumbers = Calculation.toIntegerList(inputWinNumbers);
        if (!checkWinNumbers(winNumbers))
            return;

        System.out.println(Notification.INPUT_BONUS_NUMBER.getMessage());
        inputBonus = Console.readLine();
        if (!checkInputBonus(winNumbers, inputBonus))
            return;
        bonus = Integer.parseInt(inputBonus);
        for (Lotto purchasedLotto : purchasedLotteries) {
            int rank = Calculation.compareLotto(winNumbers, bonus, purchasedLotto.getLotto());
            counts[rank]++;
        }

        profit = Calculation.getProfit(counts);
        profitRate = Calculation.getProfitRate(purchaseMoney, profit);

        String winResult = Calculation.getWinResult(counts, profitRate);
        System.out.println(winResult);
    }

    private static boolean checkInputPurchaseMoney(String inputPurchaseMoney) {
        try {
            Validation.isIncludeNotNumber(inputPurchaseMoney);
            Validation.isMultipleOf1000(inputPurchaseMoney);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static boolean checkInputWinNumbers(String inputWinNumbers) {
        try {
            for (String inputWinNumber : inputWinNumbers.split(",")) {
                Validation.isIncludeNotNumber(inputWinNumber);
                Validation.isNumberBetween1And45(Integer.parseInt(inputWinNumber));
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static boolean checkWinNumbers(List<Integer> winNumbers) {
        try {
            Validation.isLottoDuplicate(winNumbers);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    private static boolean checkInputBonus(List<Integer> winNumbers, String inputBonus) {
        try {
            Validation.isIncludeNotNumber(inputBonus);
            int bonus = Integer.parseInt(inputBonus);
            Validation.isNumberBetween1And45(bonus);
            Validation.isBonusInLotto(winNumbers, bonus);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}