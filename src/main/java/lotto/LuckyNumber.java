package lotto;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {
  public boolean isOnlyDigit(String userNumber) {
    for (int i = 0; i < userNumber.length(); i += 2) {
      if (!Character.isDigit(userNumber.charAt(i))) {
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
      }
    }
    return true;
  }
  public boolean isSplittedComma(String userNumber) {
    for (int i = 1; i < userNumber.length(); i += 2) {
      if (userNumber.charAt(i) == ',' ) {
        throw new IllegalArgumentException("[ERROR] 쉼표로만 구분해주세요.");
      }
    }
    return true;
  }

  public List<Integer> splitLuckyNumber(String userNumber) {
    String[] numbers = userNumber.split(",");
    List<Integer> validNumber = new ArrayList<>();
    for (String s : numbers) {
      validNumber.add(Integer.parseInt(s));
    }
    return validNumber;
  }


  public boolean numberRangeCheck(List<Integer> userNumber) {
    for (Integer integer : userNumber) {
      if (integer < 1 || integer > 45) {
        return false;
      }
    }
    return true;
  }
}
