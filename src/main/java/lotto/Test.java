package lotto;

import java.util.List;
import java.util.Map;

public class Test {
  public static void test1() {
    Money money = new Money();
    RandomNumberCreater randomMaker = new RandomNumberCreater();

    PrintOut.requestInputMessage();
    String userMoney = money.inputMoney();
    money.countLotto(userMoney);
    Map<Integer, List<Integer>> integerList = RandomNumberCreater.generateLottoNumber();
  }
  public static void main(String[] args){

  }
}
