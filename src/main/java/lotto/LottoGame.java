package lotto;

import java.util.List;
import java.util.Map;

public class LottoGame {
  private final Input input;
  private final Output output;

  public LottoGame() {
    this.input = new Input();
    this.output = new Output();
  }

  public void start() {
    int purchase = input.inputPurchase();

    output.buyLottoCount(purchase);

    NumberGenerator generator = new NumberGenerator();
    List<List<Integer>> generatorNumbers = generator.createNumbers(purchase / 1000);

    output.everyLottoNumber(purchase, generatorNumbers);

    Lotto lotto = new Lotto(input.inputLottoNumber());
    System.out.println();

    int bonusNumber = lotto.bonusValidate(input.inputBonusNumber());
    System.out.println();

    CountRate countRate = new CountRate();

    Map<Rank, Integer> ranking = countRate.findNumber(generatorNumbers, bonusNumber, lotto);

    output.result(purchase, countRate, ranking);// 출력
  }


}