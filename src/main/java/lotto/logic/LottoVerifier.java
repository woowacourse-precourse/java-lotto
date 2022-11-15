package lotto.logic;

import lotto.model.ContainStatus;

import java.util.ArrayList;
import java.util.List;

public class LottoVerifier {
    private int bonus;

    public LottoVerifier(int bonus) {
        this.bonus = bonus;
    }

    public ContainStatus isBonus(List<Integer> lottoNums) {
        if (lottoNums.contains(bonus)) {
            return ContainStatus.Contain;
        }
        return ContainStatus.NotContain;
    }

    public static int getInputToInt(String readLine) {
        validNum(readLine);
        return Integer.parseInt(readLine);
    }



    public static List<Integer> getWinningNumber(String readLine) {
        String[] tempNumberList = readLine.split(",");
        List<Integer> result = new ArrayList<>();
        validNumberCount(tempNumberList.length);
        for (int i = 0; i <6 ; i++) {
            int num = getInputToInt(tempNumberList[i]);
            result.add(num);
        }
        return result;
    }



    private static void validNumberCount(int n) {
        if (n != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자가 6개가 아닙니다.");
        }
    }

    private static void validNum(String readLine) {
        if(!isNum(readLine)){
            throw new IllegalArgumentException("[ERROR] 로또 번호 문자열에 숫자가 아닌 문자가 있습니다.");
        }
        if(!isValidNumber(readLine)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }


    private static boolean isValidNumber(String undefinedNumber) {
        int n = Integer.parseInt(undefinedNumber);
        return n >= 1 && n <= 45;
    }

    private static boolean isNum(String undefinedNumber) {
        for (int i = 0; i <undefinedNumber.length() ; i++) {
            char inspection = undefinedNumber.charAt(i);
            if (!(inspection >= '0' && inspection <= '9')) {
                return false;
            }
        }
        return true;
    }

}
