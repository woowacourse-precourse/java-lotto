package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrizeNum {
    private static List<Integer> prize = new ArrayList<>();

    public PrizeNum() {

    }

    public static void prizeClear() {
        prize.clear();
    }

    public static List<Integer> getPrize() {
        return prize;
    }

    private static String[] splitInputPrize(String inputPrize) {
        return inputPrize.replace(" ", "").split(",");
    }

    public static void setPrizeNum(String inputPrize) throws IllegalArgumentException {
        String[] splitInput = splitInputPrize(inputPrize);
        prize = new ArrayList<>();

        for (String input : splitInput) {
            prize.add(Integer.parseInt(input));
        }

        validatePrizeNum(prize);
    }

    private static void validatePrizeNum(List<Integer> prizeNum) throws IllegalArgumentException {
        if (prizeNum.size() != 6) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_PRIZE_NUM_SIX);
        }
        if (prizeNum.size() != prizeNum.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_PRIZE_NUM_UNIQUE);
        }
    }

    public static void setBonusNum(String bonusNum) throws IllegalArgumentException {
        int bonus = Integer.parseInt(bonusNum);

        validateBonusNum(bonus);

        prize.add(bonus);
    }

    private static void validateBonusNum(int bonus) throws IllegalArgumentException {
        if (prize.contains(bonus)) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_BONUS_NUM_UNIQUE);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(prize.toArray());
    }
}
