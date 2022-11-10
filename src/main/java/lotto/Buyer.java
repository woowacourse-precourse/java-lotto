package lotto;

public class Buyer {
    final int purchaseAmount;
    int lottoAmount;

    public Buyer(int purchaseAmount) {
        amountRange(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }
    private void amountRange(int purchaseAmount){
        if(purchaseAmount%1000 !=0){
            throw new IllegalArgumentException("[ERROR] 입력금액의 단위는 1000입니다.");
        }
    }
    public int lottoAmount(int purchaseAmount){
       return this.lottoAmount = purchaseAmount/1000;
    }
    public void lottoAmountMessage(){
        System.out.println(lottoAmount + "개를 구매하셨습니다.");
    }


    public void buyMessage(){
        System.out.println("구입금액을 입력해 주세요.");
    }
}
