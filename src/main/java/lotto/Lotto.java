package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
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

    // get(0) -> 일치하는 당첨번호의 개수, get(1) -> 일치하는 보너스 번호의 개수
    public List<Integer> checkLottoNumber(List<Integer> lottoNumbers, int bonusNumber) {
        List<Integer> lottoResult = new ArrayList<>();
        numbers.removeAll(lottoNumbers);
        lottoResult.add(6 - numbers.size());
        if (numbers.contains(bonusNumber)) {
            lottoResult.add(1);
            return lottoResult;
        }

        lottoResult.add(0);
        return lottoResult;
    }

    public void printLotto() {
        System.out.println("[" + numbers.get(0) +", "+
                numbers.get(1) + ", " +
                numbers.get(2) + ", " +
                numbers.get(3) + ", " +
                numbers.get(4) + ", " +
                numbers.get(5) + "]" );
    }
}
