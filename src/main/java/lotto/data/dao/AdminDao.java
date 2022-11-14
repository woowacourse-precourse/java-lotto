package lotto.data.dao;

import lotto.data.entity.WinNumber;
import lotto.data.repository.LottoBundleRepository;
import lotto.data.repository.WinNumberRepository;

public class AdminDao {

    private final LottoBundleRepository lottoBundleRepository;
    private final WinNumberRepository winNumberRepository;

    public AdminDao() {
        lottoBundleRepository = LottoBundleRepository.getInstance();
        winNumberRepository = WinNumberRepository.getInstance();
    }

    public Long getCurrentRoundId() {
        return winNumberRepository.getCurrentRoundId();
    }

    public void insertWinNumber(WinNumber winNumber) {
        winNumberRepository.save(winNumber);
    }

    public Long setNextRound() {
        Long nextRoundId = winNumberRepository.increaseRoundId();
        lottoBundleRepository.createNewColumn(nextRoundId);
        return nextRoundId;
    }
}
