package lotto;

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
    public static void main(String[] args) {

        System.out.println("구입 금액을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        int input_money = sc.nextInt();
        if ((input_money % 1000) > 0){
            System.out.println("[ERROR] 로또 구입 금액은 1000원 단위로 받을 수 있습니다.");
            throw new IllegalArgumentException();
        }
        get_lotto_numbers(input_money);
        // TODO: 프로그램 구현
    }
}
