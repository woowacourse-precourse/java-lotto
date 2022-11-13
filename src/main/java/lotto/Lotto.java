package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public static void checkMoney(String Money){
        if(Integer.valueOf(Money)%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하셔야 합니다.");
        }
    }

    public static int buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        String Money = readLine();
        checkMoney(Money);
        int numBuy = Integer.valueOf(Money)/1000;
        return numBuy;
    }
    public static List<Integer> generateLotto(){
        List<Integer> Lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(Lotto);
        return Lotto;
    }
}
