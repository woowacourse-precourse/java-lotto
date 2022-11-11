package lotto.view;

import lotto.domain.constant.RateOfReturnMessage;

public class RateOfReturnView implements View{
  @Override
  public void print(String rateOfReturn) {
    System.out.println(RateOfReturnMessage.RATE_OF_RETURN_MESSAGE.print(rateOfReturn));
  }
}
