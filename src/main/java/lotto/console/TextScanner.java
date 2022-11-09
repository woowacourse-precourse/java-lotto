package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.tool.InputChecker;
import lotto.tool.InputType;
import lotto.tool.LottoTool;

public class TextScanner {
  public static int scanPrice() throws IllegalArgumentException{
    String input= Console.readLine();
    InputChecker.checkIsNumber(input,InputType.PRICE);
    int price=Integer.parseInt(input);
    InputChecker.checkDivideThousand(price, InputType.PRICE);
    return price;
  }

  public static List<Integer> scanWinnerNumberList() throws IllegalArgumentException{
    String[] inputList=Console.readLine().split(",");
    InputChecker.checkListSize(inputList,InputType.WINNER);
    InputChecker.checkIsNumber(inputList, InputType.WINNER);
    List<Integer> winnerNumberList=LottoTool.convertToIntegerList(inputList);
    InputChecker.checkInRangeNumber(winnerNumberList, InputType.WINNER);
    InputChecker.checkDuplicate(winnerNumberList,InputType.WINNER);
    return winnerNumberList;
  }
  //TODO : 입력으로 winnerNumberList 받는 거 말고 다른 방법 찾아보기
  public static int scanBonnusNumber(List<Integer> winnerNumberList) throws IllegalArgumentException{
    String input= Console.readLine();
    InputChecker.checkIsNumber(input, InputType.BONNUS);
    int bonnusNumber=Integer.parseInt(input);
    InputChecker.checkInRangeNumber(bonnusNumber, InputType.BONNUS);
    InputChecker.checkDuplicate(winnerNumberList,bonnusNumber,InputType.WINNER);
    return bonnusNumber;
  }

}
