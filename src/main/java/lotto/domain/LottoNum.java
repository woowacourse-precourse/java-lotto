package lotto.domain;

import lotto.domain.constant.BoundaryValue;
import lotto.domain.constant.LottoPrice;
import lotto.domain.io.Multiple1000Validator;
import lotto.domain.io.NumberValidator;

public class LottoNum {

  private final int lottoNum;

  public LottoNum(String purchaseAmount) {
    validate(purchaseAmount);
    this.lottoNum = getLottoNum(purchaseAmount);
  }

  private void validate(String amount) {
    NumberValidator numberValidator = new NumberValidator();
    Multiple1000Validator multiple1000Validator = new Multiple1000Validator();

    int input = numberValidator.validate(amount);
    multiple1000Validator.validate(input);
  }

  private int getLottoNum(String input) {
    int money = Integer.parseInt(input);
    money /= LottoPrice.LOTTO_PRICE.getLottoPrice();
    return money;
  }
}
