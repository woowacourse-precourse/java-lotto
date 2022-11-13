package lotto.domain;

import lotto.domain.constant.BoundaryValue;
import lotto.domain.io.Multiple1000Validator;
import lotto.domain.io.NumberValidator;

public class PurchaseAmount {

  private final int amount;

  public PurchaseAmount(String amount) {
    validate(amount);
    this.amount = getLottoNum(amount);
  }

  private void validate(String amount) {
    NumberValidator numberValidator = new NumberValidator();
    Multiple1000Validator multiple1000Validator = new Multiple1000Validator();

    int input = numberValidator.validate(amount);
    multiple1000Validator.validate(input);
  }

  private int getLottoNum(String input) {
    int money = Integer.parseInt(input);
    money /= BoundaryValue.LOTTO_PRICE.getBoundaryValue();
    return money;
  }
}
