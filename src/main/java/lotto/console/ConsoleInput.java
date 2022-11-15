package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.WinningNumber;

public class ConsoleInput {

  public int inputMoney() {
    System.out.println(ConsoleMessage.INPUT_MONEY.getMesage());
    String money = Console.readLine();
    validateIsNumeric(money);
    return Integer.parseInt(money);
  }

  public WinningNumber inputWinningNumber() {
    List<Integer> winningNumber = getWinningNumber();
    int bonusNumber = getBonusNumber();
    duplicateCheck(winningNumber, bonusNumber);

    return new WinningNumber(winningNumber, bonusNumber);
  }

  private void duplicateCheck(List<Integer> integers, int bonusNumber) {
    List<Integer> distinctNumbers = integers.stream().distinct().collect(Collectors.toList());

    if (distinctNumbers.size() != 6) {
      throw new IllegalArgumentException("숫자가 중복됐습니다.");
    }

    if (distinctNumbers.contains(bonusNumber)) {
      throw new IllegalArgumentException("숫자가 중복됐습니다.");
    }
  }


  private int getBonusNumber() {
    System.out.println(ConsoleMessage.INPUT_BONUS_NUMBER.getMesage());
    String bonusNumberString = Console.readLine();
    validateLottoNumber(bonusNumberString);
    return Integer.parseInt(bonusNumberString);
  }

  private List<Integer> getWinningNumber() {
    System.out.println(ConsoleMessage.INPUT_WINNING_NUMBER.getMesage());
    String winningNumberString = Console.readLine();
    List<Integer> numbers = new ArrayList<>();

    String[] splitByStr = winningNumberString.split(",");
    for (String s : splitByStr) {
      validateLottoNumber(s);
      numbers.add(Integer.parseInt(s));
    }

    if (numbers.size() != 6) {
      throw new IllegalArgumentException("6자리 숫자를 입력해야 합니다.");
    }
    return numbers;
  }

  private void validateLottoNumber(String numberString) {
    if (!numberString.matches("[1-9]*")) {
      throw new IllegalArgumentException("숫자여야 합니다.");
    }
    int toInt = Integer.parseInt(numberString);
    if (toInt <= 0 || toInt > 45) {
      throw new IllegalArgumentException("로또 범위를 벗어났습니다.");
    }
  }

  private void validateIsNumeric(String str) {
    boolean check = str != null && str.matches("[0-9]*");
    if (!check) {
      throw new IllegalArgumentException("숫자여야 합니다.");
    }
  }

}
