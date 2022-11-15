package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
    // TODO: 추가 기능 구현

    //구매 횟수만큼 로또 출력
    private List lottoGenerator() {
        Purchaser purchaser = new Purchaser();
        System.out.printf("로또 %d개를 구매했습니다.", purchaser.dividePurchaseSum());

        List<List> lottos = new ArrayList<>(purchaser.dividePurchaseSum());

        for (int i = 0; i < lottos.size(); i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            lottos.add(i, numbers);
        }
        return lottos;
    }
}
