package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoMachine {
    private final int LOTTO_PRICE = 1000;
    private int paid;

    public LottoMachine() {}

    public void getInputMoney(){
        System.out.println("구입 금액을 입력해 주세요");
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);
        this.paid = Integer.parseInt(Console.readLine());
    }

    private void validateMoney(int money){
        if(money % LOTTO_PRICE != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요");
        }
    }


}
