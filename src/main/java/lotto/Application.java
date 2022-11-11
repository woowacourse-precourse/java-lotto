package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {

  static final int LOTTO_AMOUNT = 1000;

  public static void main(String[] args) {
    // TODO: 프로그램 구현
  }

  private static int enterPurchaseAmount() {
    System.out.println("구매금액을 입력해 주세요.");
    String purchaseAmount = Console.readLine();
    return Integer.parseInt(purchaseAmount);
  }

  private static int getNumberOfBuyLotto(int purchaseAmount) {
    valid(purchaseAmount);
    return purchaseAmount / LOTTO_AMOUNT;
  }

  private static void valid(int purchaseAmount){
    if(purchaseAmount%LOTTO_AMOUNT>0){
      throw new IllegalArgumentException("[ERROR] 구매 금액이 1000원 단위여야 합니다.");
    }
  }
}
