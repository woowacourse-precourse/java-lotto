package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Customer {
    private int asset;
    private List<Lotto> userLotto;

    public Customer(){

    }
    public void setAsset() {
        System.out.println("구입금액을 입력해 주세요.");
        String asset = Console.readLine();
        try{
            this.asset = Integer.parseInt(asset);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    public int payMoney(){
        return this.asset;
    }

    public void purchaseLotto(List<Lotto> lotto){
        this.userLotto = lotto;
    }
}
