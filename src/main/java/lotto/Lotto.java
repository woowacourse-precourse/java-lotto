package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Error.REDUPLICATION_LOTTO;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.stream().distinct().collect(Collectors.toList()).size() != 6) {
            throw new IllegalArgumentException(REDUPLICATION_LOTTO.getMessage());
        }
    }

    // get(0) -> 일치하는 당첨번호의 개수, get(1) -> 일치하는 보너스 번호의 개수
    public List<Integer> checkLottoNumber(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> lottoResult = new ArrayList<>();
        int sameNumberCount = 0;
        for (Integer winningNumber : winningNumbers) {
            if(numbers.contains(winningNumber))
                sameNumberCount++;
        }
        lottoResult.add(sameNumberCount);
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
