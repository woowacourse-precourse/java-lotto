package lotto;

import java.util.regex.Pattern;

public class InputMoney {
  private static final String ONLY_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
  private static final String CHARGE_ERROR_MESSAGE = "[ERROR] 1000단위의 숫자를 입력해 주세요.";
  private Integer ableCount;

  public InputMoney(String money) {
    this.ableCount = checkChange(money);
  }

  private Integer checkChange(String money){
    if (!Pattern.matches("^[0-9]*$", money)){
      throw new IllegalArgumentException(ONLY_NUMBER_ERROR_MESSAGE);
    }
    if (Integer.valueOf(money) % 1000 != 0){
      throw new IllegalArgumentException(CHARGE_ERROR_MESSAGE);
    }
    return Integer.valueOf(money) / 1000;
  }

  public Integer getAbleCount() {
    return ableCount;
  }

}
