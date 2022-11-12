package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class Application {

    static int lottoPrice = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();

        System.out.println("구매금액을 입력해 주세요.");
        String buyMoney = Console.readLine();

        int buyLottoMoney = Integer.parseInt(buyMoney);
        //로또 한장은 1000원이다

        int lottoAmount = buyLottoMoney / lottoPrice ;
        System.out.println(lottoAmount + "개를 구매했습니다.");

        for(int ticket = 1; ticket <= lottoAmount; ticket++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(numbers);
        }
    }
}


