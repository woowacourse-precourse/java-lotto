package lotto.view;

import lotto.domain.constant.GuideMessage;

public class GuideView extends View{

  @Override
  public void print(String output) {
    System.out.println(output);
  }

  public void printPurchaseNum(int purchaseNum){
    System.out.println(purchaseNum + GuideMessage.OUTPUT_PURCHASE_NUM_OF_LOTTO.getMessage());
  }
}
