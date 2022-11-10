package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구매금액을 입력해 주세요.");
        String input_price = Console.readLine().trim();
        int price = Integer.parseInt(input_price);
        // 입력값 검수
        int buy_payper = price/1000;
        System.out.println(buy_payper + "개를 구매했습니다.");
        //Lotto.computer 에서 램덤수 6세트 받기
    }
}
