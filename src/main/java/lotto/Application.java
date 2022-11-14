package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Lotto> lotto_list = new ArrayList<>(); //전체 로또 담을 리스트

    public static List<Integer> makeRandom() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구매금액을 입력해주세요.");
        String money = Console.readLine();
        int lottoNumber = Integer.parseInt(money) / 1000;
        System.out.println(lottoNumber + "개를 구매했습니다.");

        for (int cnt = 0; cnt < lottoNumber; cnt++) {
            List<Integer> numbers = makeRandom();
            Lotto lotto = new Lotto(numbers);
            lotto_list.add(lotto); //로또 리스트에 담기
            lotto.getNumbers(); //로또 번호 출옴
        }
    }
}
