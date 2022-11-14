package lotto.domain;

import lotto.service.UserIOService;

import java.util.List;

public class WinningLotto extends Lotto {
    UserIOService ioService = new UserIOService();
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
        bonusNumber = ioService.scanBonusNumber(this.getNumbers());
    }


    @Override
    public String toString() {
        return super.getNumbers().toString()+" "+bonusNumber;
    }
}
