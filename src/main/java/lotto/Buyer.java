package lotto;

import camp.nextstep.edu.missionutils.Console;


public class Buyer {
    int money = 0;
    int quantity = 0;
    public int purchase(){

        return 0;
    }
    public void Quantity (int quantity, int money) {
        System.out.println("구입금액을 입력해주세요: ");
        money = Integer.parseInt(Console.readLine());

        quantity = money/1000;
    }
    public void Purchase (int quantity) {

    }

}
