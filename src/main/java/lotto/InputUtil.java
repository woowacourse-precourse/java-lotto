package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {
  public static int getIntegerInput() {
    return stringToInt(Console.readLine());
  }

  private static int stringToInt(String s) {
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닙니다.");
    }
  }
}
