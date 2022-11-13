package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        System.out.println(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public static ArrayList<List<Integer>> randomNumberGenerate(int numberOfGame){
        int i = 0;
        ArrayList<List<Integer>> userNumber = new ArrayList<>();
        do{
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto num = new Lotto(numbers);
            userNumber.add(num.numbers);
            i ++;
        }while (i != numberOfGame);
        return userNumber;
    }
    // TODO: 추가 기능 구현
}
