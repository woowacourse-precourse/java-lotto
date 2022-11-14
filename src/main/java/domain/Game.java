package domain;

import java.util.List;

public class Game {

    public static final int LottoPrice = 1000;

    public static String winningNumbers_Input;
    public static int bonusNumber;
    public static int paymentAmount;
    public static List<Integer> winning_numbers;
    public static int total_gain = 0;

    public static int getLottoCount() {
        return paymentAmount / LottoPrice;
    }

    public static List<Integer> getWinning_numbers() {
        return winning_numbers;
    }

}
