package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    private static List<Lotto> lotto_list = new ArrayList<>(); //전체 로또 담을 리스트

    public static List<Integer> makeRandom() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static int buyLotto() {
        System.out.println("구매금액을 입력해주세요.");
        String money = Console.readLine();
        int lottoNumber = Integer.parseInt(money) / 1000;

        return lottoNumber;
    }

    public static void printLotto(int lottoNumber) {
        System.out.println(lottoNumber + "개를 구매했습니다.");

        for (int cnt = 0; cnt < lottoNumber; cnt++) {
            List<Integer> numbers = makeRandom();
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lotto_list.add(lotto); //로또 리스트에 담기
            lotto.getNumbers(); //로또 번호 출옴
        }
    }

    public static List<Integer> winningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        List<Integer> winningNumbersList = new ArrayList<>(); //당첨 번호 담긴 리스트
        StringTokenizer st = new StringTokenizer(numbers, ",");

        while(st.hasMoreTokens()) {
            int element = Integer.parseInt(st.nextToken());
            winningNumbersList.add(element);
        }

        return winningNumbersList;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int lottoNumber = buyLotto();
        printLotto(lottoNumber);
        Lotto winningLotto = new Lotto(winningNumber());
    }
}
