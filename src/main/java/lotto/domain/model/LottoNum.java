package lotto.domain.model;

import lotto.domain.constant.LottoInfo;
import lotto.domain.io.Multiple1000Validator;
import lotto.domain.io.NumberValidator;
import lotto.domain.io.ZeroAndMinusValidator;

public class LottoNum {

  private final int lottoNum;

  public LottoNum(String purchaseAmount) {
    validate(purchaseAmount);
    this.lottoNum = getLottoNum(purchaseAmount);
  }

  private void validate(String amount) {
    NumberValidator numberValidator = new NumberValidator();
    ZeroAndMinusValidator zeroAndMinusValidator = new ZeroAndMinusValidator();
    Multiple1000Validator multiple1000Validator = new Multiple1000Validator();

    int input = numberValidator.validate(amount);
    zeroAndMinusValidator.validate(input);
    multiple1000Validator.validate(input);
  }

  private int getLottoNum(String input) {
    int money = Integer.parseInt(input);
    money /= LottoInfo.LOTTO_PRICE.getValue();
    return money;
  }

  public int getLottoNum() {
    return lottoNum;
  }
}
