package lotto;

import java.util.LinkedHashMap;
import java.util.Scanner;
import lotto.data.Rank;
import lotto.player.House;
import lotto.player.User;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //User 생성 : 구매금액에 따른 티켓 수 생성 및 출력
        System.out.println("구입금액을 입력해 주세요.");
        String payment = sc.next();
        User user = new User(payment);
        int ticketNum = user.getTicketNum();
        System.out.println("\n"+ticketNum+"개를 구매했습니다.");
        System.out.println(user);

        //하우스 생성 : 당첨번호 및 보너스 번호에 따라 생성
        System.out.println("당첨 번호를 입력해 주세요.");
        String winInput = sc.next();
        System.out.println("\n보너스 번호를 입력해 주세요");
        int bonus = sc.nextInt();
        House house = new House(winInput, bonus);

        //결과 통계 출력
        System.out.println("\n당첨통계");
        System.out.println("---");
        LinkedHashMap<Rank, Integer> statistics = house.getResultOf(user);
        for( Rank key : statistics.keySet() )
            System.out.println(key.getLabel()+" - " + statistics.get(key)+"개");

        //수익률통계
        double revenue = house.getRevenueOf(user);
        System.out.println("총 수익률은 "+(Math.round(revenue * 100) / 100.0)+"%입니다.");

        sc.close();
    }
}
