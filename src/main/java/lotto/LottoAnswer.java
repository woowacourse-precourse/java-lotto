package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoAnswer {
  private List<Integer> lotto_answer = new ArrayList<>();
  private int bonus_number;

  public LottoAnswer() {
    setLottoAnswer();
  }

  private void setLottoAnswer() {
    String answer;
    System.out.println("당첨 번호를 입력해 주세요.");
    answer = readLine();
    String answer_arr[] = answer.split(",");
    for (int i = 0; i < 6; i++) {
      lotto_answer.add(Integer.valueOf(answer_arr[i]));
    }
    System.out.println("보너스 번호를 입력해 주세요.");
    bonus_number = Integer.parseInt(readLine());
  }

  public boolean haveNumber(Integer number) {
    return lotto_answer.contains(number);
  }

  public Integer getBonusNumber() {
    return this.bonus_number;
  }
}
