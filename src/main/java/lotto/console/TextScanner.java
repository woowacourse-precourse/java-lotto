package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.tool.LottoChecker;
import lotto.tool.LottoTool;

public class TextScanner {
  public static int scanPrice() throws IllegalArgumentException{
    String input= Console.readLine();
    LottoChecker.checkIsNumber(input);
    int price=Integer.parseInt(input);
    LottoChecker.checkDivideThousand(price);
    return price;
  }

  public static Lotto scanWinnerNumberList() throws IllegalArgumentException{
    String[] inputList=Console.readLine().split(",");
    LottoChecker.checkIsNumber(inputList);
    List<Integer> winnerNumberList=LottoTool.convertToIntegerList(inputList);
    return new Lotto(winnerNumberList);
  }
  //TODO : 입력으로 winnerNumberList 받는 거 말고 다른 방법 찾아보기
  public static int scanBonnusNumber(Lotto winnerLotto) throws IllegalArgumentException{
    String input= Console.readLine();
    LottoChecker.checkIsNumber(input);
    int bonnusNumber=Integer.parseInt(input);
    LottoChecker.checkInRangeNumber(bonnusNumber);
    LottoChecker.checkDuplicate(winnerLotto.getNumbers(),bonnusNumber);
    return bonnusNumber;
  }

}
