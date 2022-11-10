package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {

    private static String inputMoney = "구입금액을 입력해 주세요.";
    private static String howManyBought = "개를 구매했습니다.";
    private static String inputWinningNumber = "당첨 번호를 입력해 주세요";
    private static String inputBonusNumber = "보너스 번호를 입력해 주세요";
    private static List<String> result = List.of(
            "당첨 통계\n---",
            "3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
            "6개 일치 (2,000,000,000원) - "
    );

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lotto lotto;
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private static int getUserMoney(){
        int userMoney = Integer.parseInt(Console.readLine());
        // 예외처리
        return userMoney;
    }
}
