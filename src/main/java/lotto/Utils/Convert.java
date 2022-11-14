package lotto.Utils;

import java.util.ArrayList;
import java.util.List;
import lotto.Constant.Message;

public class Convert {

    private static final String COMMA = ",";

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
            lottoNum.add(n);
        }
        return lottoNum;
    }
}
