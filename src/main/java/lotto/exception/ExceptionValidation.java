package lotto.exception;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ExceptionValidation {

    public static void validateException(int input) {
        if ((input % 1000) != 0) {
            throw new IllegalArgumentException("[ERROR] 복권 하나는 1000원입니다. 1000원 단위로 입력해주세요.");
        }
    }

    public static void inputException(List<Integer> winnningNum) {
        inputsizeException(winnningNum);
        inputduplicateException(winnningNum);
        inputrangeException(winnningNum);
    }

    private static boolean inputsizeException(List<Integer> input) {
        if (input.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6자리의 수를 입력해주세요.");
        }
        return false;
    }

    private static boolean inputduplicateException(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            int frequency = Collections.frequency(input, input.get(i));
            if (input.size() == 6 && frequency >= 2) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않는 6자리 수를 입력해주세요.");
            }
        }
        return false;
    }

    private static boolean inputrangeException(List<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) > 45 || input.get(i) < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return false;
    }

    public static void bonusException(int bonus, List<Integer> Winning) {
        checkDuplication(bonus, Winning);
        checkBonusSize(bonus);
    }

    private static boolean checkDuplication(int bonus, List<Integer> Winning) {
        for(int i=0; i<Winning.size(); i++){
            if(Winning.contains(bonus)){
                throw new IllegalArgumentException("[ERROR] 당첨 번호 6자리와 다른 수를 입력해주세요.");
            }
        }
        return false;
    }

    private static boolean checkBonusSize(int bonus) {
        if(bonus>45 || bonus<1){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return false;
    }
}
