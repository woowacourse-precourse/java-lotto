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
}
