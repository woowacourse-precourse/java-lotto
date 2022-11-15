package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    Lotto lotto;
    User user = new User();

    public void run() {
        List<User> userLottoList = new ArrayList<>();
        // 구입 금액 입력
        // 발행 로또 출력
        System.out.println("구매금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        int lottoCount = lottoCount(money);
        // 로또 수량 출력
        // 로또 번호 출력

        // 당첨 번호 입력 (Lotto)
        // 보너스 번호 입력
        // 당첨 확인
        // 당첨 통계 출력

        // 일치 항목 출력
        // 수익률 출력
    }

    // 발행 로또 출력
    public int lottoCount(int purchaseAmount) {
        int lottoCount = 0;
        // 1,000원 단위로 나눈다.
        if (purchaseAmount % 1000 == 0) {
            return purchaseAmount / 1000;
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 떨어져야 합니다.");
        }
        return lottoCount;
    }

    public static void main(String[] args) {
        Application app = new Application();
        // TODO: 프로그램 구현
        app.run();
    }
}
