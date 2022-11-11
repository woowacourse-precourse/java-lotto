package lotto.domain.constant;

import java.util.function.Function;

public enum RateOfReturnMessage {
  RATE_OF_RETURN_MESSAGE(x -> "총 수익률은 " + x + "입니다.");

  private Function<String, String> template;

  RateOfReturnMessage(Function<String, String> template) {
    this.template = template;
  }

  public String print(String rateOfReturn) {
    return this.template.apply(rateOfReturn);
  }
}
