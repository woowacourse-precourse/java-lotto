package lotto.domain.lotto;

import static lotto.domain.utils.Number.validateRange;

import lotto.domain.utils.Input;

public class LottoBonusNumber {

  private Integer number;
  public static final String INPUT_MESSAGE_OF_GETTING_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

  public LottoBonusNumber() {
    printBonusNumberMessage();
    Integer bonus = Input.toInteger();
    validateRange(bonus);
    this.number = bonus;
  }

  private void printBonusNumberMessage() {
    System.out.println();
    System.out.println(INPUT_MESSAGE_OF_GETTING_BONUS_NUMBER);
  }

  public Integer getBonusNumber() {
    return number;
  }
}
