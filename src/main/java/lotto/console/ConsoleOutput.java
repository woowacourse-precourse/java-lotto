package lotto.console;

import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class ConsoleOutput {

  private final StringBuilder stringBuilder = new StringBuilder();

  public void printLotto(List<Lotto> lottos) {
    for (Lotto lotto : lottos) {
      List<Integer> numbers = lotto.getNumbers();
      Collections.sort(numbers);
      formattingNumbers(numbers);
    }
    System.out.print(stringBuilder.toString());
    stringBuilder.setLength(0);
  }

  private void formattingNumbers(List<Integer> integers) {
    stringBuilder.append("[");
    for (int i = 0; i < integers.size(); i++) {
      if (i == integers.size() - 1) {
        stringBuilder.append(integers.get(i)).append("]");
        break;
      }
      stringBuilder.append(integers.get(i)).append(", ");
    }
    stringBuilder.append("\n");
  }
}
