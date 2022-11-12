package lotto;

import java.util.List;

public class WinLotto extends Lotto{

    private final int bonusNumber;

    public WinLotto(List<Integer> winNumbers, int bonusNumber) {
        super(winNumbers);
        this.bonusNumber = bonusNumber;
    }
}
