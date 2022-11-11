package lotto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int ticket_price = 1000;

    public static void main(String[] args) {
        final List<Integer> lotto_win;
        final List<Lotto> lotto_issuance;
        final Integer purchase, bonus;
        purchase = input_validate();

        validate(purchase);
        lotto_issuance = lotto_create(purchase);
        display_lottos(lotto_issuance);

        lotto_win = Arrays.asList(Console.readLine().split(",")).stream().map(s -> Integer.parseInt(((String) s).trim())).collect(Collectors.toList());
        Lotto winLotto = new Lotto(lotto_win);
        bonus = input_validate();
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
