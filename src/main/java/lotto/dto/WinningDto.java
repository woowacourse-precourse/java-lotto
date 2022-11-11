package lotto.dto;

import lotto.system.holder.ConverterHolder;
import lotto.vo.Winning;

public class WinningDto {
    private String winning;
    private String bonus;

    public WinningDto(String winning, String bonus) {
        this.winning = winning;
        this.bonus = bonus;
    }

    public Winning toWinning() {
        return ConverterHolder.convert(this, Winning.class);
    }

    public String getWinning() {
        return winning;
    }

    public String getBonus() {
        return bonus;
    }
}
