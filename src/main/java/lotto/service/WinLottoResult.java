package lotto.service;

import lotto.view.Output;

import java.util.List;

public class WinLottoResult {
    Output output = new Output();
    public void checkWinLottoResult(List<Integer> answerLotto, List<List<Integer>> dataLotto) {
        output.winStatistics();
    }
}
