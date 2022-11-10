package lotto.view;

import lotto.service.BuyLotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputOutputView {

    public int buyMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(readLine());
    }

    public void buyFin(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void myLottos(List<List<Integer>> lottos) {
        for (int idx = 0; idx < lottos.size(); idx++) {
            System.out.println(lottos.get(idx).toString());
        }
    }
}
