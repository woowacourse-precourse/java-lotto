package lotto.service;

import lotto.domain.WinningNumber;

import java.util.List;

public class LotteryDrawService {
    public WinningNumber draw (List<Integer> numbers, int bonusNumber) {
        return new WinningNumber(numbers, bonusNumber);
    }
}
