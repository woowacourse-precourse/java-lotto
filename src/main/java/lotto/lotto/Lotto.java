package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.LottoException;
import lotto.ui.Message;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicationNumbers(numbers);
        validationNumbersInRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(Message.NUMBERS_SIZE_SIX_FIT_ERROR);
        }
    }

    // TODO: 추가 기능 구현
    private static List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static List<Lotto> buyLotto(int count) {
        List<Lotto> lottoes = new ArrayList<>();

        for (int buyCount = 0; buyCount < count; buyCount++) {
            Lotto lotto =
                    new Lotto(Lotto.createLottoNumbers()
                            .stream()
                            .sorted()
                            .collect(Collectors.toList()));
            lottoes.add(lotto);
        }

        return lottoes;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void duplicationNumbers(List<Integer> numbers) { // 배열의 값이 6인지와 중복 값이 있는지 확인
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        validate(new ArrayList<>(checkNumbers));
    }

    public boolean duplicationBonusNumber(int number) { // 보너스 번호가 이미 배열에 있는지
        if (this.numbers.contains(number)) {
            throw new LottoException(Message.HAS_BONUS_NUMBER_ERROR);
        }
        return true;
    }

    public void validationNumbersInRange(List<Integer> numbers) { // 입력한 로또배열의 유효값 확인
        for (int number : numbers) {
            validationNumberInRange(number);
        }
    }

    public void validationNumberInRange(int number) { // 입력한 로또 부분이 1 ~ 45의 값인지
        if (!(1 <= number && number <= 45)) {
            throw new LottoException(Message.NO_NUMBER_RANGE_ERROR);
        }
    }
}
