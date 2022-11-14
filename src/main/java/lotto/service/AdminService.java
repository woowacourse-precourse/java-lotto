package lotto.service;

import java.util.Set;
import lotto.data.dto.BonusNumberDto;
import lotto.data.dto.WinNumberDto;
import lotto.data.entity.WinNumber;
import lotto.data.entity.WinNumber.WinNumberBuilder;
import lotto.data.repository.WinNumberRepository;

public class AdminService {

    private final WinNumberRepository winNumberRepository;
    private final WinNumberBuilder winNumberBuilder;

    public AdminService() {
        winNumberRepository = WinNumberRepository.getInstance();
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

    public void confirmWinNumber() {
        WinNumber winNumber = winNumberBuilder.build();
        Long roundId = winNumberRepository.getCurrentRoundId();
        winNumber.setRoundId(roundId);
        winNumberRepository.save(winNumber);
    }
}
