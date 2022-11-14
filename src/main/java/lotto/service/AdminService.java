package lotto.service;

import java.util.Set;
import lotto.data.dao.AdminDao;
import lotto.data.dto.BonusNumberDto;
import lotto.data.dto.WinNumberDto;
import lotto.data.entity.WinNumber;
import lotto.data.entity.WinNumber.WinNumberBuilder;

public class AdminService {

    private final AdminDao adminDao;
    private final WinNumberBuilder winNumberBuilder;

    public AdminService() {
        adminDao = new AdminDao();
        winNumberBuilder = WinNumber.builder();
    }

    public void setWinNumber(WinNumberDto winNumberDto) {
        Set<Integer> winNumbers = winNumberDto.getWinNumbers();
        winNumberBuilder.winNumbers(winNumbers);
    }

    public void setBonusNumber(BonusNumberDto bonusNumberDto) {
        int bonusNumber = bonusNumberDto.getBonusNumber();
        winNumberBuilder.bonusNumber(bonusNumber);
    }

    public void finishRound() {
        WinNumber winNumber = winNumberBuilder.build();
        Long roundId = adminDao.getCurrentRoundId();
        winNumber.setRoundId(roundId);
        adminDao.insertWinNumber(winNumber);
        adminDao.setNextRound();
    }
}
