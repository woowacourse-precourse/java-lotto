package lotto;

import java.util.List;
import java.util.Map;

public class Test {
  public static void test1() {
    Money money = new Money();

    PrintOut.requestInputMessage();
    String userMoney = money.inputMoney();
    money.countLotto(userMoney);
    Lotto lotto = new Lotto();
    Map<Integer, List<Integer>> integerList = lotto.generateLottoNumber();
  }
  public static void main(String[] args){

  }
}
