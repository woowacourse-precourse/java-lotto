package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size()!= numbers.size()){
            throw new IllegalArgumentException("[ERROR] 입력된 로또 번호에 중복된 번호가 있습니다.");
        }
    }

    // input 개수만큼 로또 발행
    public static List<Lotto> issueLotto(int count) {
        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumber = pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(lottoNumber);
            lotteries.add(lotto);
        }
        return lotteries;
    }
}
