package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoWithBonusNum {
    private final Lotto lotto;
    private final BonusNum bonusNum;

    public LottoWithBonusNum() {
        this(Randoms.pickUniqueNumbersInRange(1, 45, 7));
    }

    public LottoWithBonusNum(List<Integer> lottoNumbers) {
        validate(lottoNumbers);

        lotto = new Lotto(lottoNumbers.subList(0, 6));
        bonusNum = new BonusNum(lottoNumbers.get(6));

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 입력한 숫자들의 개수가 7개가 아닙니다.");
        }
        numbers.forEach((number) -> {
            if (!isOnceAppear(numbers, number)) {
                throw new IllegalArgumentException("[ERROR] 중복이 되는 숫자가 존재합니다.");
            }
        });

    }

    private boolean isOnceAppear(List<Integer> numbers, int number) {
        return numbers.indexOf(number) == numbers.lastIndexOf(number);
    }
}
