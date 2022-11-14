package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import lotto.data.Lotto;
import lotto.util.Parser;
import lotto.player.House;
import lotto.player.User;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            //User 생성 : 구매금액에 따른 티켓 수 생성 및 출력
            System.out.println("구입금액을 입력해 주세요.");
            int payment = Parser.parseInteger(sc.next());
            User user = new User(payment);
            System.out.println(user);

            //하우스 생성 : 당첨번호 및 보너스 번호에 따라 생성
            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winnerNumbers = Parser.parseListInteger(sc.next());
            Lotto win = new Lotto(winnerNumbers);

            System.out.println("보너스 번호를 입력해주세요.");
            int bonus = Parser.parseInteger(sc.next());
            win.addBonus(bonus);
            House house = new House(win);

            //결과 통계 출력
            house.printResultOf(user);

            //수익률통계
            house.printRevenueOf(user);

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
