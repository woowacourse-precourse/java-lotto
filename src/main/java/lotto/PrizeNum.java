package lotto;

import java.util.ArrayList;
import java.util.List;

public class PrizeNum {
    private final List<Integer> prizeNum;

    public PrizeNum(List<Integer> prizeNum) {
        this.prizeNum = prizeNum;
    }

    public static List<Integer> getPrize() {
        List<Integer> prize = new ArrayList<>();

        return prize;
    }

    private static String[] splitInputPrize() {
        return Input.inputPrize().split(",");
    }

    private static List<Integer> setPrizeNum() throws IllegalArgumentException {
        String[] splitInput = splitInputPrize();
        List<Integer> prizeNum = new ArrayList<>();

        for(String input : splitInput) {
            prizeNum.add(Integer.parseInt(input));
        }

        validatePrizeNum(prizeNum);

        return prizeNum;
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
