package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("구매금액을 입력해 주세요.");
        String input_price = Console.readLine().trim();
        System.out.println(input_price);
        //
        price check_price = new price(input_price);
        //
        int input_price_calculation = Integer.parseInt(input_price);
        int buy_paper = input_price_calculation/1000;
        System.out.println("\n" + buy_paper + "개를 구매했습니다.");
        //
        Pick pick_number = new Pick(buy_paper);
        //
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input_number = Console.readLine().trim();
        System.out.println(input_number);
        //
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input_bonus_number = Console.readLine().trim();
        System.out.println(input_bonus_number);
        /*
        당첨분석
         */
        System.out.println("\n당첨 통계\n---");
    }
}
