package lotto.service;

import lotto.domain.WinningNumber;
import lotto.repository.WinningNumberRepository;

public class WinningNumberService {

    private final WinningNumberRepository winningNumberRepository;

    public WinningNumberService(WinningNumberRepository winningNumberRepository) {
        this.winningNumberRepository = winningNumberRepository;
    }

    public void saveWinningNumber(WinningNumber winningNumber) {
        winningNumberRepository.save(winningNumber);
    }

    public WinningNumber findWinningNumber() {
        return winningNumberRepository.findWinningNumber();
    }
}
