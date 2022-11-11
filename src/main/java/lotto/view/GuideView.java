package lotto.view;

import lotto.domain.constant.GuideMessage;

public class GuideView implements View{
  @Override
  public void print(String guideMessage) {
    System.out.println(guideMessage);
  }

  public void printPurchaseNum(int purchaseNum){
    System.out.println(purchaseNum + GuideMessage.OUTPUT_PURCHASE_NUM_OF_LOTTO.getMessage());
  }
}
