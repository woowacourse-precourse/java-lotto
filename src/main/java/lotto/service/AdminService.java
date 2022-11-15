package lotto.service;

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
        winNumberBuilder.winNumbers(winNumberDto.getWinNumbers());
    }

    public void setBonusNumber(BonusNumberDto bonusNumberDto) {
        winNumberBuilder.bonusNumber(bonusNumberDto.getBonusNumber());
    }

    public void finishRound() {
        winNumberBuilder.roundId(adminDao.getCurrentRoundId());
        adminDao.insertWinNumber(winNumberBuilder.build());
        adminDao.setNextRound();
    }
}
