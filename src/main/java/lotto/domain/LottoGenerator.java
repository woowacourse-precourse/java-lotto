package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoGenerator {
    private int count;
    public static List<List<Integer>> lottoList;

    public LottoGenerator() {
        countLotto();
    }
    public int countLotto(){
        System.out.println("구입금액을 입력해주세요 : ");
        Integer money = Integer.parseInt(Console.readLine());
        if(money % 1000 !=0){
            throw new IllegalArgumentException();
        }
        count = money/ 1000;
        return count;
    }

    public List<List<Integer>> LottoNumbers(){
        System.out.println(count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            System.out.println(createNumbers());
            lottoList.add(createNumbers());
        }
        return lottoList;
    }

    //중복되지 않는 로또 6자리 숫자 뽑기
    public List<Integer> createNumbers(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; ) {
            int num = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(num)) {
                numbers.add(num);
                i++;
            }
        }
        Collections.sort(numbers);
        return numbers;
    }

}
