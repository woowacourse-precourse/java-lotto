package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;

public class Application {
    private static final int ticket_price = 1000;

    public static void main(String[] args) {
        final List<Integer> lotto_win;
        final List<Lotto> lotto_issuance;
        final int purchase, bonus;
        Scanner sc = new Scanner(System.in);
        purchase = sc.nextInt();

        validate(purchase);
        sc.nextLine();
        lotto_win = Arrays.asList(sc.nextLine().split(",")).stream().map(s -> Integer.parseInt(((String) s).trim())).collect(Collectors.toList());
        Lotto winLotto = new Lotto(lotto_win);
        bonus = sc.nextInt();

        lotto_issuance = lotto_create(purchase);
        display_lottos(lotto_issuance);
        sc.close();
    }

    private static void validate(Integer purchase){
        if (purchase % ticket_price != 0 || purchase <= 0){
            System.out.println("[ERROR] 금액은 반드시 1,000원 이상, 1,000원 단위로 입력하세요.");
            throw new IllegalArgumentException();
        }
    }

    private static List<Lotto> lotto_create(int purchase){
        final int tickets = (int) purchase / ticket_price;
        final List<Lotto> lotto_issuance = new ArrayList<>();
        for (int i = 0; i < tickets; i++){
            lotto_issuance.add(new Lotto());
        }
        return lotto_issuance;
    }

    private static void display_lottos(List<Lotto> lotto_issuance){
        System.out.printf("%d개를 구매했습니다.\n", lotto_issuance.size());
        for (int i = 0; i < lotto_issuance.size(); i++){
            lotto_issuance.get(i).display_num();
        }
    }
}
