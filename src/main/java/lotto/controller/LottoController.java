package lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.console.TextPrinter;
import lotto.console.TextScanner;
import lotto.tool.LottoTool;
import lotto.tool.Rank;

public class LottoController {

  private int price;
  private List<Lotto> lottoList;
  private Lotto winnerLotto;
  private int bonnusNumber;
  private double profitRate;
  private HashMap<Rank, Integer> result;

  public void play() {
    try {
      TextPrinter.printGetPrice();
      price = TextScanner.scanPrice();

      makeLottoList(price);
      TextPrinter.printLotto(lottoList);

      TextPrinter.printGetWinnerNumber();
      winnerLotto = TextScanner.scanWinnerNumberList();

      TextPrinter.printGetBonnusNumber();
      bonnusNumber = TextScanner.scanBonnusNumber(winnerLotto);

      result = LottoTool.calcResult(lottoList, winnerLotto, bonnusNumber);
      profitRate = LottoTool.calcReturnRate(result, price);

      TextPrinter.printTotalResult(result);
      TextPrinter.printReturnRate(profitRate);


    } catch (IllegalArgumentException e) {
      TextPrinter.printErrorMessage(e);
    }

  }

  private void makeLottoList(int price) {
    int num = price / 1000;
    List<Lotto> lottoList = new ArrayList<>();

    for (int i = 0; i < num; i++) {
      lottoList.add(LottoTool.makeLotto());
    }
    this.lottoList = lottoList;
  }
}
