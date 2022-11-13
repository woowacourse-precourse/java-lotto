package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static ArrayList<Lotto> get_lotto_numbers(int input_money){

        ArrayList<Lotto> lottos = new ArrayList<>();
        int number = input_money / 1000;
        System.out.printf("%d개를 구매했습니다.\n", number);

        for (int i=0; i < number; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lotto.sort();
            lotto.print_lotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    public static Lotto get_lotto_answer(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String get_lotto_answer = Console.readLine();
        System.out.println(get_lotto_answer);

        List<Integer> lotto_answer = new ArrayList<>();
        String[] answer_numbers = get_lotto_answer.split(",");

        for (int i=0; i < answer_numbers.length; i++){
            int number = Integer.valueOf(answer_numbers[i]);
            lotto_answer.add(number);
        }

        Lotto lotto = new Lotto(lotto_answer);
        return lotto;
    }

    public static int bonus(Lotto lotto){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.valueOf(Console.readLine());
        if (!lotto.return_lotto().contains(bonus)){
            System.out.println("[ERROR] 로또 번호와 보너스 번호가 동일합니다.");
            throw new IllegalArgumentException();
        }
        System.out.println(bonus);
        return bonus;
    }

    public static void main(String[] args) {

        System.out.println("구입 금액을 입력해주세요.");
        int input_money = Integer.valueOf(Console.readLine());
        if ((input_money % 1000) > 0){
            System.out.println("[ERROR] 로또 구입 금액은 1000원 단위로 받을 수 있습니다.");
            throw new IllegalArgumentException();
        }
        //ArrayList<Lotto> lottos = get_lotto_numbers(input_money);
        Lotto answer_lotto = get_lotto_answer();
        int Bonus = bonus(answer_lotto);
        // TODO: 프로그램 구현
    }
}
