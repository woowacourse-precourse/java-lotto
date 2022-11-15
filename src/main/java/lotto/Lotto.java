package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.view.Input.input;

public class Lotto {
    private final List<Integer> numbers;

    public static List randomLottoNum(){
        List<Integer> randomLotto = new ArrayList<>();

        int num = 0;
        while(num != 6){
            int number = Randoms.pickNumberInRange(1, 45);
            if(!randomLotto.contains(number)){
                num++;
                randomLotto.add(number);
            }
        }
        return randomLotto;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static int lottoNum(){
        int amount = input();
        if(amount % 1000 != 0){
            throw new IllegalArgumentException();
        }
        int num = amount / 1000;
        return num;
    }

    // TODO: 추가 기능 구현
}
