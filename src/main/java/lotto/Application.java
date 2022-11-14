package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

class MoneyException {
    public MoneyException(int money) {
        if (money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }
}

public class Application {
    public static void main(String[] args) {
        int count=0;
        // 입력
        int money = Integer.parseInt(Console.readLine());

        // 입력 예외 처리
        MoneyException moneyException=new MoneyException(money);

        // 입력 수 만큼 6개의 랜덤 숫자 생성
        count=money/1000;
        for (int i=0;i<count;i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            // 사용자로부터 번호 입력 받음

        }
        // 보너스 번호
        // 당첨 내역
        // 수익률
    }
}
