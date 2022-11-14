package lotto.view;

import lotto.domain.constant.RateOfReturnMessage;

public class RateOfReturnView {

  public void print(String output) {
    System.out.println(RateOfReturnMessage.RATE_OF_RETURN_MESSAGE.print(output));
  }
}
