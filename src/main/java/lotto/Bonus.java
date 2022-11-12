package lotto;

import java.util.List;

public class Bonus {
    private static int bonus;

    public Bonus(int bonus) {
        this.bonus = bonus;
    }

    public static ContainStatus isBonus(List<Integer> lottoNums) {
        if (lottoNums.contains(bonus)) {
            return ContainStatus.Contain;
        }
        return ContainStatus.NotContain;
    }
    public static int getInputToInt(String readLine) {
        validNum(readLine);
        return Integer.parseInt(readLine);
    }

    private static void validNum(String s) {
        if(!isNum(s)){
            throw new IllegalArgumentException("[ERROR] 로또 번호 문자열에 숫자가 아닌 문자가 있습니다.");
        }
        if(!isValidNumber(s)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static boolean isValidNumber(String s) {
        int n = Integer.parseInt(s);
        return n >= 1 && n <= 45;
    }

    private static boolean isNum(String s) {
        for (int i = 0; i <s.length() ; i++) {
            char inspection = s.charAt(i);
            if (!(inspection >= '0' && inspection <= '9')) {
                return false;
            }
        }
        return true;
    }

}
