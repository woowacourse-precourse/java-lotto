package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputMessage {
  private static final String ABLE_BUY_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
  private static final String LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
  private static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

  public static void messageAbleBuyMoney(){
    System.out.println(ABLE_BUY_MONEY_MESSAGE);
  }
  public static String messageLottoInput(){
    System.out.println();
    System.out.println(LOTTO_INPUT_MESSAGE);

    return Console.readLine();
  }
  public static String messageBonusInput(){
    System.out.println();
    System.out.println(BONUS_INPUT_MESSAGE);

    return Console.readLine();
  }
}
