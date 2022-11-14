package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        List<Integer> dupleCheck  = new ArrayList<>();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int idx =0; idx <numbers.size();idx++) {
            if (dupleCheck.contains(numbers.get(idx))) {
                throw new IllegalArgumentException();
            }
            else if (numbers.get(idx)< 1 || numbers.get(idx) > 45) {
                throw new IllegalArgumentException();
            }
            dupleCheck.add(numbers.get(idx));
        }
    }
    // TODO: 추가 기능 구현
    public static List<List<Integer>> lottoNumber(int num) {
        User user = new User();
        List<List<Integer>> answer = new ArrayList<>();
        for (int idx = 0; idx <num; idx++) {
            List<Integer>  temp = new ArrayList<>();
            List<Integer>   ans= Randoms.pickUniqueNumbersInRange(1, 45, 6);
            //1~45사이의 숫자를 6개 뽑는 경우의 수
            for(int q =0;q<ans.size();q++){
                if (temp.contains(ans.get(q))){
                    throw new IllegalArgumentException();
                }
                temp.add(ans.get(q));
            }
            Collections.sort(temp);
            user.output(temp);
            answer.add(temp);
        }
        return answer;
    }
}
