package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public static int scanPurchaseAmount(){
        String money = readLine();
        try {
            int ret = Integer.parseInt(money);
            if(ret < 0){
                throw new IllegalArgumentException("[ERROR] 음수가 아닌 정수를 입력해야 합니다.");
            }
            if(ret % 1000 != 0){
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.");
            }
            return ret;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
    }
    public static List<Integer> scanWinningLotto(){
        String winningLotto = readLine();
        List<String> splitted = Arrays.asList(winningLotto.split(","));
        try{
            List<Integer> ret = splitted.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validateLength(ret);
            validateUnique(ret);
            validateRange(ret);
            return ret;
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 쉼표를 기준으로 구분되고 정수를 입력해야합니다.");
        }
    }

    public static void validateLength(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }
    }
    public static void validateUnique(List<Integer> numbers){
        int numOfUniqueNumber = (int)numbers.stream()
                .distinct()
                .count();
        if(numOfUniqueNumber != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 서로 다른 숫자여야 합니다.");
        }
    }
    public static void validateRange(List<Integer> numbers){
        int numOfOutOfRangeNumber = (int) numbers.stream()
                .filter(n -> n>45 || n<1)
                .count();
        if(numOfOutOfRangeNumber > 0){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
