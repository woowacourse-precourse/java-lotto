package lotto.data.dao;

import lotto.data.entity.LottoRound;
import lotto.data.entity.WinNumber;
import lotto.data.repository.LottoRoundRepository;
import lotto.data.repository.WinNumberRepository;

public class AdminDao {

    private final LottoRoundRepository lottoRoundRepository;
    private final WinNumberRepository winNumberRepository;

    public AdminDao() {
        lottoRoundRepository = LottoRoundRepository.getInstance();
        winNumberRepository = WinNumberRepository.getInstance();
    }

    public Long getCurrentRoundId() {
        return (long) lottoRoundRepository.count();
    }

    public void insertWinNumber(WinNumber winNumber) {
        winNumberRepository.save(winNumber);
    }

    public void setNextRound() {
        Long nextRoundId = (long) (lottoRoundRepository.count()+1);
        lottoRoundRepository.save(new LottoRound(nextRoundId));
    }
}
