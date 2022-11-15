package lotto.view;

import lotto.domain.constant.GuideMessage;
import lotto.domain.model.Lotto;

import java.util.List;

public class MyLottosView{

  public void print(List<Lotto> lottos) {
    System.out.println();
    System.out.println(lottos.size() + GuideMessage.OUTPUT_PURCHASE_NUM_OF_LOTTO.getMessage());
    lottos.forEach(it -> System.out.println(it.getNumbers()));
    System.out.println();
  }
}