package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Lotto> lottos;
    private int money;

    public void inputBuyLottoPrice() {
        String money = Console.readLine();
        // 숫자 입력이 아닐 때 예외처리
        // 1000원으로 나누어 떨어지지 않을 때 예외처리
        this.money = Integer.parseInt(money);
        // 로또 구입 금액만큼 로또 번호 자동 발행
    }
}
