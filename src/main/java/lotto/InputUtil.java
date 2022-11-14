package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtil {
  public static int getIntegerInput() {
    return stringToInt(Console.readLine());
  }

  public static Lotto getPrizeLotto() {
    return stringToLotto(Console.readLine());
  }

  private static int stringToInt(String s) {
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닙니다.");
    }
  }

  private static Lotto stringToLotto(String str) {
    List<String> strList = Arrays.asList(str.split(","));
    return new Lotto(stringListToIntegerList(strList));
  }

  private static List<Integer> stringListToIntegerList(List<String> strList) {
    List<Integer> intList;
    try {
      intList = strList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자가 아닙니다.");
    }
    return intList;
  }
}
