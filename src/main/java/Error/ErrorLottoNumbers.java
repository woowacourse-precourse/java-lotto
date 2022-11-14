package Error;

import java.util.List;

public class ErrorLottoNumbers {

  public static boolean isDuplicateInput(List<Integer> numbers, Integer new_number) {
    if (numbers.contains(new_number)) {
      return true;
    }
    return false;
  }

  public static boolean isDuplicateLottos(List<Integer> numbers) {
    if (numbers.size() != numbers.stream().distinct().count()) {
//      throw new IllegalArgumentException();
      return true;
    }
    return false;
  }
}
