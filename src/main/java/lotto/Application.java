package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        
    }

    // num개의 lotto를 발행하는 함수
    public static List<Lotto> makeLottoNumber(List<Lotto> lottos, int num){
        for(int i = 0; i < num; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public static int checkPayMoney(int money){
        if(money%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액만 가능합니다.");
        }
        return money/1000;
    }

    public static int checkLottoSame(Lotto winningLotto, Lotto lotto){
        int same = 0;
        List<Integer> winNum = winningLotto.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();
        for(int i : lottoNumbers){
            if(winNum.contains(i)){
                same++;
            }
        }
        return same;
    }

    public static void printLottos(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers.toString());
        }
    }

    // string배열을 int List로 변환하는 함수
    public static List<Integer> stringToIntList(String[] str){
        List<Integer> nums = new ArrayList<>();
        int[] numbers = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        for(int i : numbers){
            nums.add(i);
        }
        return nums;
    }
}