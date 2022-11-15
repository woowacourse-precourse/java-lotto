package lotto.domain.user;

import lotto.constant.LottoPrice;
import lotto.domain.utils.Input;

public class User {
  private Integer money;
  public static final String INPUT_MESSAGE_OF_GETTING_USER_MONEY = "구입금액을 입력해 주세요.";
  public static final String ERROR_MESSAGE_OF_USER_MONEY = "[ERROR] 구입금액은 천원 단위여야 합니다.";

  public User() {
    printMoneyInputMessage();
    Integer money = Input.toInteger();
    validateInputMoney(money);
    this.money = money;
  }

  private void printMoneyInputMessage() {
    System.out.println(INPUT_MESSAGE_OF_GETTING_USER_MONEY);
  }

  private void validateInputMoney(Integer money) {
    if(money % getLottoPrice() != 0){
      throw new IllegalArgumentException(ERROR_MESSAGE_OF_USER_MONEY);
    }
  }

  private Integer getLottoPrice() {
    return LottoPrice.LOTTO_PRICE.getPrice();
  }

  public int getTicketCount(){
    return money / getLottoPrice();
  }
}
