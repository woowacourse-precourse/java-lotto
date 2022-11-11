package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class test {

    private List<Integer> numbers;

    public test(int want) {
        want = want / 1000;
        this.numbers = createRandomNumbers(want);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> createRandomNumbers(int want) {

        numbers = new ArrayList<>();
        List<Integer> basket = new ArrayList<>();
        List<List<Integer>> tt = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        for (int i = 0; i < want; i++) {
//            basket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            System.out.println("test : "+basket);
//            tt.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
//            numbers.add(basket);
        }

        for (int i = 0; i < want; i++) {
//            basket = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            basket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            for (int j = 0; j < basket.size(); j++) {
                Collections.sort(basket, Collections.reverseOrder());
                numbers.add(basket.get(j));
            }
            tt.add(basket);
        }

        for (List<Integer> integers : tt) {
            System.out.println(integers);
        }


        return numbers;
    }
}
