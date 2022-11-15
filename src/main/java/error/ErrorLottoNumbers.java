package error;

import java.util.Iterator;
import java.util.List;

import static constantValue.LottoUtilNumber.OVER_RANGE;
import static constantValue.LottoUtilNumber.UNDER_RANGE;

public class ErrorLottoNumbers {

  public static boolean isDuplicateInput(List<Integer> numbers, Integer new_number) {
    return numbers.contains(new_number);
  }

  public static boolean isOutBoundNumbers(List<Integer> numbers) {
    Iterator<Integer> it = numbers.iterator();
    int num;
    while (it.hasNext()) {
      num = it.next();
      if (num < UNDER_RANGE || num > OVER_RANGE) {
        return true;
      }
    }
    return false;
  }

  public static boolean isDuplicateLottos(List<Integer> numbers) {
    return numbers.size() != numbers.stream().distinct().count();
  }
}
