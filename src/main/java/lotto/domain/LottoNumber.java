package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private static final int LOTTO_MAX_SIZE = 6;
    private static final int ZERO = 0;

    public static List<Integer> makeInputToNumber(String lineNumber) {
        return lottoStringToInt(cutInput(removeWhiteSpace(lineNumber)));
    }

    private static String removeWhiteSpace(String existWhiteSpace){
        return existWhiteSpace.replaceAll("\\s", "");
    }

    private static String[] cutInput(String lineNumber) {
        return lineNumber.split(",");
    }

    private static List<Integer> lottoStringToInt(String[] cutInput) {
        List<Integer> cutLottoNumber = new ArrayList<>();
        for (String s : cutInput) {
            cutLottoNumber.add(Integer.parseInt(s));
        }
        return cutLottoNumber;
    }

    public static int returnBonusToInt(String bonusInput) {
        return Integer.parseInt(bonusInput);
    }
}
