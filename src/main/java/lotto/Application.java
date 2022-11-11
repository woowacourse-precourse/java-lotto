package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 구입금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        if(money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위로 입력해야 합니다.");
        }

        int lottoCnt = money/1000;


    }
}
