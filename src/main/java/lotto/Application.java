package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Service service = new Service();

        // TODO: 프로그램 구현
        System.out.println(Situation.INPUT_MONEY.message);
        int purchaseAmount = service.getPurchaseAmount();

    }

    public enum Situation{
        INPUT_MONEY("구입금액을 입력해 주세요."),
        PURCHASE("개를 구입했습니다."),
        WIN_NUMBER("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요."),
        WIN_STATISTICS("당첨 통계");
        private final String message;
        Situation(String message) {
            this.message = message;
        }
    }


}
