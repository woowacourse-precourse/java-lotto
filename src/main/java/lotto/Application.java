package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int ticket_price = 1000;
    private static final List<Integer> prize = List.of(5000, 50000, 1500000, 30000000, 2000000000);
    private static List<Integer> prize_num = List.of(0, 0, 0, 0, 0);

    public static void main(String[] args) {
        final List<Integer> lotto_win;
        final List<Lotto> lotto_issuance;
        final Integer purchase, bonus;
        Lotto winLotto;
        purchase = input_validate();

        validate(purchase);
        lotto_issuance = lotto_create(purchase);
        display_lottos(lotto_issuance);

        lotto_win = Arrays.asList(Console.readLine().split(",")).stream().map(s -> Integer.parseInt(((String) s).trim())).collect(Collectors.toList());
        winLotto = new Lotto(lotto_win);
        bonus = input_validate();

        get_prize_num(winLotto, lotto_issuance, bonus);
        display_result(purchase);
    }

    private static void validate(int purchase){
        if (purchase % ticket_price != 0 || purchase <= 0){
            System.out.println("[ERROR] 금액은 반드시 1,000원 이상, 1,000원 단위로 입력하세요.");
            throw new IllegalArgumentException();
        }
    }

    private static int input_validate(){
        Integer num;
        String input = Console.readLine();
        try{
            num = Integer.parseInt(input);
            return num;
        } catch (NumberFormatException e){
            System.out.println("[ERROR] 정수를 입력하세요.");
            throw new IllegalArgumentException();
        }
    }

    private static List<Lotto> lotto_create(int purchase){
        final int tickets = (int) purchase / ticket_price;
        final List<Lotto> issuance = new ArrayList<>();
        for (int i = 0; i < tickets; i++){
            issuance.add(new Lotto());
        }
        return issuance;
    }

    private static void display_lottos(List<Lotto> issuance){
        System.out.printf("%d개를 구매했습니다.\n", issuance.size());
        for (int i = 0; i < issuance.size(); i++){
            issuance.get(i).display_num();
        }
    }

    private static void get_prize_num(Lotto winLotto, List<Lotto> issuance, int bonus){
        int same;
        for (int i = 0; i < issuance.size(); i++){
            same = issuance.get(i).compare_win(winLotto, bonus);
            if (same >= 3){
                prize_num.set(prize_num.get(same - 3), prize_num.get(same - 3) + 1);
            }
        }
    }

    private static void display_result(int purchase){
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", prize_num.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", prize_num.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", prize_num.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", prize_num.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", prize_num.get(4));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", get_yield(purchase));
    }

    private static double get_yield(int purchase){
        double yield;
        int total_prize = 0;
        for (int i = 0; i < prize.size(); i++){
            total_prize += prize.get(i) * prize_num.get(i);
        }
        yield = total_prize / purchase * 100;
        return yield;
    }
}
