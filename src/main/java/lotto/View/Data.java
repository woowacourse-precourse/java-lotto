package lotto.View;

import static lotto.Model.Error.No_input;
import static lotto.Model.Error.getErrorMessage;
import static lotto.View.Variable.Bonus_nbr;
import static lotto.View.Variable.Right_nbr;
import static lotto.View.Variable.Stat_Lotto;
import static lotto.View.Variable.Winning_Rate;
import static lotto.View.Variable.Buy_lotto;
import static lotto.View.Variable.Earning_rate;

import java.util.Map;
import lotto.Model.Rank;
import lotto.Model.Result;
import lotto.Model.Price;
import lotto.Model.User;

import camp.nextstep.edu.missionutils.Console;

public abstract class Data {
    public static String BuyLotto() {
        System.out.println(Stat_Lotto.getMessage());
        return inputData();
    }

    public static String FirstRate() {
        System.out.println(Right_nbr.getMessage());
        return inputData();
    }

    public static String Bonus() {
        System.out.println();
        System.out.println(Bonus_nbr.getMessage());
        return inputData();
    }

    private static String inputData() {
        String inputData = Console.readLine();
        validate(inputData);
        return inputData;
    }

    private static void validate(final String inputData) {
        if (inputData == null) {
            throw new IllegalArgumentException(getErrorMessage(No_input));
        }
    }
    public static final double Percent = 10.0;

    public static void printUser(final User userLotto, final Price pay) {
        System.out.println();
        System.out.println(pay.calculateQuantity() + Buy_lotto.getMessage());
        for (String lotto : userLotto.getUserLotto()) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printResult(final Result lottoResult, final Price pay) {
        System.out.println();
        System.out.println(Winning_Rate.getMessage());
        printRate(lottoResult);
        printEarning(lottoResult, pay);
        System.out.println();
    }

    private static void printRate(final Result lottoResult) {
        Map<Rank, Long> result = lottoResult.getLottoResult();
        for (Rank lottoRank : result.keySet()) {
            System.out.println(Rank.createStatisticsForm(lottoRank, result.get(lottoRank)));
        }
    }

    private static void printEarning(final Result lottoResult, final Price pay) {
        System.out.printf((Earning_rate.getMessage()) + "%n",
                Math.round(lottoResult.calculateYield(pay) * Percent) / Percent);

    }
}
