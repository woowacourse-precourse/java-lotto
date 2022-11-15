package lotto;

import java.util.ArrayList;
import java.util.List;

import static Error.ErrorLottoNumbers.isDuplicateInput;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoAnswer {
  private final List<Integer> lotto_answer = new ArrayList<>();
  private int bonus_number;

  public LottoAnswer() {
    setLottoAnswer();
  }

  private void setLottoAnswer() {
    inputWinNumber();
    inputBonusNumber();
    System.out.println();
  }

  private void inputWinNumber() {
    String answer;
    System.out.println("당첨 번호를 입력해 주세요.");
    answer = readLine();
    System.out.println();
    String[] answer_arr = answer.split(",");
    for (int i = 0; i < 6; i++) {
      if (isDuplicateInput(lotto_answer, Integer.valueOf(answer_arr[i]))) {
        throw new IllegalArgumentException();
      }
      lotto_answer.add(Integer.valueOf(answer_arr[i])); // try catch 문 작성하는 것 권장
    }
  }

  private void inputBonusNumber() {
    System.out.println("보너스 번호를 입력해 주세요.");
    bonus_number = Integer.parseInt(readLine());
    if (isDuplicateInput(lotto_answer, bonus_number)) {
      throw new IllegalArgumentException();
    }
  }

  public boolean haveNumber(Integer number) {
    return lotto_answer.contains(number);
  }

  public Integer getBonusNumber() {
    return this.bonus_number;
  }
}
