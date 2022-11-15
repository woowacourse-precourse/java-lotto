package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }


    //1.사용자의 구입 금액 입력
    public static int how_many_lotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String user_input = Console.readLine();
        exception_how_many_lotto(user_input);
        int amount = Integer.parseInt(user_input);
        return amount;
    }

    //1.사용자의 구입 금액 입력 예외 검사
    private static void exception_how_many_lotto(String user_input) {
        int money = 0;
        try{
            money = Integer.parseInt(user_input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    //2.구입 금액만큼의 로또 번호 생성, 출력
    public static List<List> createLotto(int lotto_amount) {
        System.out.println(lotto_amount + "개를 구매하였습니다.");
        List<List> lotto_list = new ArrayList<>();
        for(int i=0; i<lotto_amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            new Lotto(numbers);
            System.out.println(numbers);
            lotto_list.add(numbers);
        }
        return lotto_list;
    }
}
