package lotto.dto;

import java.util.List;

public class LottoMatchDto {
    private Double winningRate;
    private List<Integer> winningCount;

    public LottoMatchDto(Double winningRate, List<Integer> winningCount) {
        this.winningRate = winningRate;
        this.winningCount = winningCount;
    }

    public Double getWinningRate() {
        return winningRate;
    }

    public List<Integer> getWinningCount() {
        return winningCount;
    }
}
