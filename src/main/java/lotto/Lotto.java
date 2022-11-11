package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;
    ExceptionHandling exceptionHandling = new ExceptionHandling();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public long lottoCount(long amount) {
        exceptionHandling.notDivideException(amount); // 예외 검사
        return amount / 1000;
    }

    public List<List<Integer>> createLotto(long numberOfLotto) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> lotto = createLottoList();
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Integer> createLottoList(){
        List<Integer> lotto = createLottoNumber();
        sortLottoNumberAscending(lotto);
        return lotto;
    }

    public List<Integer> createLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public List<Integer> sortLottoNumberAscending(List<Integer> lotto) {
        Collections.sort(lotto);
        return lotto;
    }

    // TODO: 추가 기능 구현
}
