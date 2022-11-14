package lotto;

import camp.nextstep.edu.missionutils.Console;
public class BuyLotto {
    private final String money;

    public BuyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        this.money = Console.readLine();
        checkMoney(money);
    }

    public void checkMoney(String money) {
        try{
            int check_money = Integer.parseInt(money);
            if(check_money < 1000) {
                throw new IllegalArgumentException("[ERROR] 1000원 이상 입력해 주세요.");
            }
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수만 입력해 주세요");
        }
        getLotto(Integer.parseInt(money));
    }
    public void getLotto(int money) {
        GetLotto getlotto = new GetLotto(money);
    }
}
