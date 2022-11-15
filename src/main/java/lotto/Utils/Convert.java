package lotto.Utils;

import java.util.ArrayList;
import java.util.List;
import lotto.Constant.Constants.Error;
import lotto.Constant.Constants.Number;

public class Convert {

    private static final String COMMA = ",";

    public static int StrToInt(final String number) {
        try {
            return isBuySum(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.NUMBER);
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

    private static void isLottoNumber(final int n) {
        if (!(Number.START_NUM <= n && n <= Number.END_NUM)) {
            throw new IllegalArgumentException(Error.ONE_TO_FORTYFIVE);
        }
    }

    private static int isBuySum(final String number) {
        int check = Integer.parseInt(number);
        if(!(Number.ZERO < check && check <= Integer.MAX_VALUE)) {
            throw new IllegalArgumentException(Error.MONEY);
        }
        return check;
    }


}
