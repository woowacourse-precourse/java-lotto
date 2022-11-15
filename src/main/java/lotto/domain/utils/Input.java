package lotto.domain.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
  public static final String STRING_SPLIT_DELIMETER = ",";

  public static String toStrings() {
    return Console.readLine();
  }

  public static Integer toInteger() {
    String input = Console.readLine();
    return Integer.valueOf(input);
  }

  public static List<Integer> toIntegerArray() {
    String[] input = Console.readLine().split(STRING_SPLIT_DELIMETER);
    int[] intInput = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
    return Arrays.stream(intInput).boxed().collect(Collectors.toList());
  }
}
