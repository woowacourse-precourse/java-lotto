package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    Validator validator = new Validator();

    /**
     * 로또 구입
     * - 구입 금액 입력
     * <p>
     * 로또 발행
     * - 구매 갯수 출력
     * - 발행 번호 출력
     * <p>
     * 당첨 번호 입력
     * - 당첨 번호 6자리 입력
     * - 보너스 번호 입력
     * <p>
     * 당첨 통계, 총 수익률 출력
     */

    public void run() {
        int lottoCount = buyLotto();
        System.out.println();



    }



    public int buyLotto() {
        System.out.println("구입 금액을 입력해 주세요.");
        String userMoney = Console.readLine();
        validator.validateMoneyNumber(userMoney);
        validator.validateMoneyUnit(userMoney);
        Money money = new Money(userMoney);
        return money.getLottoCount();
    }

   


}
