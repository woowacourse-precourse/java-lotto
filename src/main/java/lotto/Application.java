package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.ui.Guide;
import lotto.ui.LottoWin;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int askPurchaseAmount() {
        Guide.ASK_PURCHASE_AMOUNT.print();
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> askWinningNumbers() {
        Guide.ASK_WINNING_NUMBER.print();

        String[] winningNumbers = Console.readLine().split(",");
        return Arrays.stream(winningNumbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static Integer askBonusNumber() {
        Guide.ASK_BONUS_NUMBER.print();

        String bonusNumber = Console.readLine();
        validate(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void validate(String bonusNumber) {
        Pattern correctInputPattern = Pattern.compile("^([1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5])$");
        if (!correctInputPattern.matcher(bonusNumber).find()) {
            throw new IllegalArgumentException(Error.IS_NOT_CORRECT_NUMBER.getMessage());
        }
    }

    private static void printWinningDetails(LinkedHashMap<LottoWin, Integer> result) {
        Guide.WINNING_STATISTICS.print();
        result.forEach((LottoWin::print));
    }

    private static double getYield(LinkedHashMap<LottoWin, Integer> result, int purchaseAmount) {
        double totalWinningAmount = 0;
        for (Entry<LottoWin, Integer> entry : result.entrySet()) {
            LottoWin lottoWin = entry.getKey();
            Integer count = entry.getValue();
            totalWinningAmount += lottoWin.getWinningAmount(count);
        }
        return (totalWinningAmount - purchaseAmount) / purchaseAmount;
    }

    private static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }
}
