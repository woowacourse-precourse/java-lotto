package lotto.dto;

import lotto.system.holder.ConverterHolder;
import lotto.vo.WinningInfo;

public class WinningInfoDto {
    private String winningNumbers;
    private String bonus;

    public WinningInfoDto(String winningNumbers, String bonus) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public WinningInfo toWinningInfo() {
        return ConverterHolder.convert(this, WinningInfo.class);
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }

    public String getBonus() {
        return bonus;
    }
}
