package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final int ticket_price = 1000;
    private static final List<Integer> prize = List.of(5000, 50000, 1500000, 30000000, 2000000000);
    // 당첨 통계를 카운팅하기 위한 배열
    private static final int[] prize_num_arr = {0, 0, 0, 0, 0}; 
    private static final List<Integer> prize_num = Arrays.stream(prize_num_arr).boxed().collect(Collectors.toList());

    public static int main(String[] args) throws IllegalArgumentException{
        final List<Integer> lotto_win;
        final List<Lotto> lotto_issuance;
        final Integer purchase, bonus;
        Lotto winLotto;

        purchase = input_validate();
        if (purchase == -1) return 0;

        validate(purchase);
        lotto_issuance = lotto_create(purchase);
        display_lottos(lotto_issuance);

        lotto_win = Arrays.asList(Console.readLine().split(",")).stream().map(s -> Integer.parseInt(((String) s).trim())).collect(Collectors.toList());
        winLotto = new Lotto(lotto_win);
        bonus = input_validate();
        if (bonus == -1) return 0;

        get_prize_num(winLotto, lotto_issuance, bonus);
        display_result(purchase);
        return 0;
    }

    private static void validate(int purchase) throws IllegalArgumentException{
        if (purchase % ticket_price != 0 || purchase <= 0){
            throw new IllegalArgumentException("[ERROR] 금액은 반드시 1,000원 이상, 1,000원 단위로 입력하세요.");
        }
    }

    private static int input_validate() throws IllegalArgumentException{
        Integer num;
        String input = Console.readLine();
        if (input != null && input.matches("-?\\d+")){
            num = Integer.parseInt(input);
            return num;
        }
        IllegalArgumentException e = new IllegalArgumentException();
        System.out.println("[ERROR] 정수를 입력하세요. " + e.toString());
        return -1;
    }

    private static List<Lotto> lotto_create(int purchase){
        final int tickets = (int) purchase / ticket_price;
        final List<Lotto> issuance = new ArrayList<>();
        for (int i = 0; i < tickets; i++){
            issuance.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
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
        yield = (double)total_prize * 100 / (double)purchase;
        return yield;
    }
}
