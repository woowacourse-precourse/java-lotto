package lotto;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {
  public List<Integer> splitNumber(String userNumber) {
    String[] numbers = userNumber.split(",");
    List<Integer> validNumber = new ArrayList<>();
    for (String s: numbers) {
      validNumber.add(Integer.parseInt(s));
    }
    return validNumber;
  }

  public boolean numberRange(List<Integer> userNumber) {
    for (Integer integer : userNumber) {
      if (integer < 1 || integer > 45) {
        return false;
      }
    }
    return true;
  }
}
