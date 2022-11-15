package lotto.reward;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.MoneyFalseException;
import lotto.utils.WinningType;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Numbers> numbers; //인스턴스 변수

    public Lotto(NumberStrategy numberStrategy) {
        numbers = new ArrayList<>(numberStrategy.getLottoNumbers());
    }
    public List<Numbers> getNumbers() {
        return new ArrayList<>(numbers);
    }
    public WinningType matchWinningLotto(WinningCase winningLotto) {
        return WinningType.of(winningLotto.matchCount(numbers), winningLotto.matchBonus(numbers));
    }
    public long winningCount(List<Numbers> lottoNumbers) {
        return this.numbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }
    public boolean containLottoNumber(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }
    // TODO: 추가 기능 구현
}
