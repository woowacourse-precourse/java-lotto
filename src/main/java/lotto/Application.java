package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

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

    }
}


