package lotto.view;

import java.util.List;

public class LottoDto {
    private List<List<Integer>> lotteries;

    public LottoDto(List<List<Integer>> lotteries) {
        this.lotteries = lotteries;
    }

    public List<List<Integer>> getLotteries() {
        return lotteries;
    }

}
