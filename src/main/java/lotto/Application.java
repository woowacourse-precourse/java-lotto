package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Compare;
import lotto.NumberSplit;
import lotto.MoneyException;

public class Application {
    public static void main(String[] args) {
        int count = 0;
        // 입력
        int money = Integer.parseInt(Console.readLine());

        // 입력 예외 처리
        MoneyException moneyException = new MoneyException(money);

        // 입력 수 만큼 6개의 랜덤 숫자 생성
        count = money / 1000;
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            // 사용자로부터 번호 입력 받음
            String userNumbers = Console.readLine();
            NumberSplit numberSplit = new NumberSplit(userNumbers);

            // 사용자 입력 검증
            Lotto lotto = new Lotto(numberSplit.getNumber());
        }
        // 보너스 번호
        // 당첨 내역
        // 수익률
    }
}
