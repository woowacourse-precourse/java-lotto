package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //구입 가격 입력
        System.out.println("구매금액을 입력해 주세요.");
        String input_price = Console.readLine().trim();
        System.out.println(input_price);
        //구입 가격 숫자인지 확인
        price check_price = new price(input_price);
        //구입 가격이 숫자라면 통과
        if (check_price.program_out == 0) {
            int input_price_calculation = Integer.parseInt(input_price);
            int buy_paper = input_price_calculation / 1000;
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
            당첨통계
            */
            System.out.println("\n당첨 통계\n---");
        }
    }
}
