package lotto;

import java.util.ArrayList;
import java.util.List;

public class PrizeNum {
    private static List<Integer> prize = new ArrayList<>();

    private PrizeNum() {

    }

    public static List<Integer> getPrize() {
        return prize;
    }

    private static String[] splitInputPrize() {
        return Input.inputPrize().split(",");
    }

    public static void setPrizeNum() throws IllegalArgumentException {
        String[] splitInput = splitInputPrize();
        prize = new ArrayList<>();

        for(String input : splitInput) {
            prize.add(Integer.parseInt(input));
        }

        validatePrizeNum(prize);
    }

    private static void validatePrizeNum(List<Integer> prizeNum) throws IllegalArgumentException {
        if(prizeNum.size()!=6) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_PRIZE_NUM_SIX);
        }
        if(prizeNum.size()!=prizeNum.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_PRIZE_NUM_UNIQUE);
        }
    }
}
