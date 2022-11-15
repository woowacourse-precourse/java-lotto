package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Customer {
    private int asset;

    public Customer(){

    }
    public void setAsset() {
        System.out.println("구입금액을 입력해 주세요.");
        String asset = Console.readLine();
        this.asset = Integer.parseInt(asset);
    }

    public int payMoney(){
        return this.asset;
    }
}
