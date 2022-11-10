package lotto;

public class Test {
  public static void test1() {
    Money money = new Money();

    PrintOut.requestInputMessage();
    String userMoney = money.inputMoney();
    money.countLotto(userMoney);
  }
  public static void main(String[] args){
    test1();
  }
}
