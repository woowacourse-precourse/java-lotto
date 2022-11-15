package Error;

import java.util.List;

public class ErrorLottoNumbers {

  public static boolean isDuplicateInput(List<Integer> numbers, Integer new_number) {
    return numbers.contains(new_number);
  }

  public static boolean isDuplicateLottos(List<Integer> numbers) {
    return numbers.size() != numbers.stream().distinct().count();
  }
}
