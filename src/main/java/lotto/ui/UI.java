package lotto.ui;

import lotto.machine.Lotto;

import java.util.List;

public class UI {
    public static void insert_money() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void money(Integer money) {
        System.out.println(money+"\n");
    }

    public static void lotto_count(Integer lotto_count) {
        System.out.println(lotto_count+"개를 구매했습니다.");
    }

    public static void lotto(List<Lotto> lotto) {
        for(int index = 0; index<lotto.size(); index++){
            System.out.println(lotto.get(index).get_value());
        }
        System.out.println();
    }

    public static void insert_Winning_number() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void Winning_number(List<Integer> Winning_numbers) {
        System.out.println(Winning_numbers+"\n");
    }

    public static void statistics(List<Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("--------------------------");
        statistic_3(statistics.get(0));
        statistic_4(statistics.get(1));
        statistic_5(statistics.get(2));
        statistic_Bonus(statistics.get(3));
        statistic_6(statistics.get(4));
    }

    private static void statistic_3(Integer statistic_3) {
        System.out.println("3개 일치 (5,000원) - " + statistic_3 + "개");
    }

    private static void statistic_4(Integer statistic_4) {
        System.out.println("4개 일치 (50,000원) - " + statistic_4 + "개");
    }

    private static void statistic_5(Integer statistic_5) {
        System.out.println("5개 일치 (1,500,000원) - " + statistic_5 + "개");
    }

    private static void statistic_Bonus(Integer statistic_Bonus) {
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + statistic_Bonus + "개");
    }

    private static void statistic_6(Integer statistic_6) {
        System.out.println("6개 일치 (2,000,000,000원) - " + statistic_6 + "개");
    }

    public static void rate(Double rate) {
        System.out.println("총 수익률은 "+ String.format("%.1f", rate) + "%입니다.");
    }
}
