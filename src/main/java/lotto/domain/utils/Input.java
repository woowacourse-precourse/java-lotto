package lotto.domain.utils;

import camp.nextstep.edu.missionutils.Console;

public class Input {
  public static String toStrings() {
    return Console.readLine();
  }

  public static Integer toInteger() {
    String input = Console.readLine();
    return Integer.valueOf(input);
  }

  public static void emptyBuffer() {
    Console.readLine();
  }
}
