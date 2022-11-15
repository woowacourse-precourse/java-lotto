package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.shell.WinningNumber;

public class MatchBuilder {

    List<Integer> buildWinningNumbers;
    Map<Integer, List<Integer>> buildLottoNumbers;
    final int ITERATOR_NUMBER;


    public MatchBuilder() {
        this.buildWinningNumbers = buildWinningNumbers();
        this.buildLottoNumbers = buildLottoNumbers();
        this.ITERATOR_NUMBER = ITERATOR_NUMBER();
    }

    public List<Integer> buildWinningNumbers() {
        return  new WinningNumber().buildWinningNumberList();
    }

    public Map<Integer, List<Integer>> buildLottoNumbers() {
        return new AutomaticDispenser().dispenseAutomatically();
    }

    public final int ITERATOR_NUMBER() {
        return new LottoTicket().publishLottoTicket();
    }

}
