package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person {
    private List<Lotto> lottos = new ArrayList<>();
    private int totalLottosPrice = 0;

    private List<Integer> createRandomLottoNum (){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
