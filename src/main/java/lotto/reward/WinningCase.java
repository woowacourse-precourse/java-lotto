package lotto.reward;

import lotto.utils.DuplicatedLottoException;

import java.util.List;

public class WinningCase {
    private final Lotto winningLotto;
    private final Numbers bonus;

    public WinningCase(Lotto winningLotto, Numbers bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
        if(winningLotto.containLottoNumber(bonus.getNumber())){
            throw new DuplicatedLottoException();
        }
    }
    public long matchCount(List<Numbers> numbers) {
        return winningLotto.winningCount(numbers);
    }

    public boolean matchBonus(List<Numbers> numbers) {
        return numbers.contains(bonus);
    }
}
