package lotto.domain;

import lotto.domain.io.Multiple1000Validator;
import lotto.domain.io.NumberValidator;

public class PurchaseAmount {

  private final int amount;

  public PurchaseAmount(String amount) {
    this.amount = validate(amount);
  }

  private int validate(String amount) {
    NumberValidator numberValidator = new NumberValidator();
    Multiple1000Validator multiple1000Validator = new Multiple1000Validator();

    int input = numberValidator.validate(amount);
    multiple1000Validator.validate(input);
    return input;
  }
}
