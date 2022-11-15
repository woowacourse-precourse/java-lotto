package lotto;

import java.util.ArrayList;
import java.util.List;

import static constantValue.ErrorMessage.*;
import static constantValue.LottoUtilNumber.OVER_RANGE;
import static constantValue.LottoUtilNumber.UNDER_RANGE;
import static error.ErrorLottoNumbers.isDuplicateInput;
import static constantValue.RequestMessage.INPUT_BONUS_NUMBER;
import static constantValue.RequestMessage.INPUT_WINNING_NUMBERS;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static error.ErrorLottoNumbers.isOutBoundNumbers;

public class LottoAnswer {
  private final List<Integer> lotto_answer = new ArrayList<>();
  private int bonus_number;

  public LottoAnswer() {
  }

  public boolean setLottoAnswer() {
    if (!inputWinNumber())
      return false;
    if (isOutBoundNumbers(lotto_answer)) {
      throw new IllegalArgumentException(IS_NOT_IN_RANGE);
    }
    inputBonusNumber();
    System.out.println();
    return true;
  }

  private boolean inputWinNumber() {
    String answer;
    System.out.println(INPUT_WINNING_NUMBERS);
    answer = readLine();
    if (isInvalidWinNumbers(answer)) {
      System.out.println(INVALID_INPUT);
      return false;
    }
    System.out.println();
    String[] answer_arr = answer.split(",");
    for (int i = 0; i < 6; i++) {
      if (isDuplicateInput(lotto_answer, Integer.valueOf(answer_arr[i]))) {
        throw new IllegalArgumentException(IS_DUPLICATE);
      }
      lotto_answer.add(Integer.valueOf(answer_arr[i])); // try catch 문 작성하는 것 권장
    }
    return true;
  }

  private boolean isInvalidWinNumbers(String answer) {
    int num = 0;
    for (int i = 0; i < answer.length(); i++) {
      if (',' == answer.charAt(i)) {
        num++;
      }
//      if (',' != answer.charAt(i) || !(answer.charAt(i) >= '0' && answer.charAt(i) <= '9')) {
//        return true;
//      }
    }
    if (num != 5)
      return true;
    return false;
  }

  private void inputBonusNumber() {
    System.out.println(INPUT_BONUS_NUMBER);
    bonus_number = Integer.parseInt(readLine());
    if (isDuplicateInput(lotto_answer, bonus_number)) {
      throw new IllegalArgumentException();
    }
    if (bonus_number < UNDER_RANGE || bonus_number > OVER_RANGE) {
      throw new IllegalArgumentException(IS_NOT_IN_RANGE);
    }
  }

  public boolean haveNumber(Integer number) {
    return lotto_answer.contains(number);
  }

  public Integer getBonusNumber() {
    return this.bonus_number;
  }
}
