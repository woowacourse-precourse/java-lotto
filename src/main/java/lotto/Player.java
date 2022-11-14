package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Player {
    private int PurchaseMoney;
    private Manager manager;

    public Player(Manager manager){
        this.manager = manager;
    }

    public void InputPurchaseMoney(){
        String input = readLine();
        if(!manager.isNumber(input))
            throw new IllegalArgumentException("[ERROR] : 금액은 숫자로만 구성된 문자열이어야 합니다.");
        int money = Integer.parseInt(input);
        if(money < 1000)
            throw new IllegalArgumentException("[ERROR] : 최소 1000원 이상의 금액을 입력해주세요.");
        if(money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] : 금액은 1000원으로 나누어 떨어져야 합니다.");
        this.PurchaseMoney = money;
    }
}
