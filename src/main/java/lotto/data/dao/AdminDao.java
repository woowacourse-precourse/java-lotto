package lotto.data.dao;

import lotto.data.entity.WinNumber;
import lotto.data.repository.WinNumberRepository;

public class AdminDao {

    private final WinNumberRepository winNumberRepository;

    public AdminDao() {
        winNumberRepository = WinNumberRepository.getInstance();
    }

    public Long getCurrentRoundId() {
        return winNumberRepository.getCurrentRoundId();
    }

    public void insertWinNumber(WinNumber winNumber) {
        winNumberRepository.save(winNumber);
    }
}
