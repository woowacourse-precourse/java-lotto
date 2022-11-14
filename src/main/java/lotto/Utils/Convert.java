package lotto.Utils;

import java.util.ArrayList;
import java.util.List;
import lotto.Constant.Message;

public class Convert {

    private static final String COMMA = ",";
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;

    public static int StrToInt(final String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_NUMBER.getMessage());
        }
    }

    public static List<Integer> StrToList(final String winningNum) {
        String[] number = winningNum.split(COMMA);
        List<Integer> lottoNum = new ArrayList<>();

        for (String num : number) {
            int n = StrToInt(num);
            isLottoNumber(n);
            lottoNum.add(n);
        }
        return lottoNum;
    }

    private static void isLottoNumber(final int num) {
        if (!(MIN_NUM <= num && num <= MAX_NUM)) {
            throw new IllegalArgumentException(Message.ERROR_ONE_TO_FORTYFIVE.getMessage());
        }
    }
}
