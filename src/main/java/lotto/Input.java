package lotto;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private int bonus;

    public Input(int bonus) {
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

    public static void bonusNotIncludeWinningNumbers(int bonus, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 로또번호에 포함되어 있습니다.");
        }
    }

    public static List<Integer> getWinningNumber(String readLine) {
        String[] tempNumberList = readLine.split(",");
        List<Integer> result = new ArrayList<>();
        validNumberCount(tempNumberList.length);
        for (int i = 0; i <6 ; i++) {
            int num = getInputToInt(tempNumberList[i]);
            result.add(num);
        }
        duplicateCheck(result);
        return result;
    }

    private static void duplicateCheck(List<Integer> result) {
        if(result.stream().distinct().count()!=6){
            throw new IllegalArgumentException("[ERROR] 입력 숫자가 중복되었습니다.");
        };
    }

    private static void validNumberCount(int n) {
        if (n != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 숫자가 6개가 아닙니다.");
        }
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
            if (!(inspection >= '1' && inspection <= '9')) {
                return false;
            }
        }
        return true;
    }

}
