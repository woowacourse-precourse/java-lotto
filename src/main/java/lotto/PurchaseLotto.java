package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

// 1. 구입금액 입력
// 2. 구입금액을 1000원 단위로 나누기
// 3. 나누어 떨어지지 않는 경우 예외 처리
// 4. 나누어 떨어지는 경우 구매갯수 처리
public class PurchaseLotto {
    public List<Integer> purchaseLotto() {
        System.out.println("구입금액을 입력해주세요");
        List<Integer> myLotto = new ArrayList<>();
        String moneyInput = Console.readLine();
        int inputMoney = Integer.parseInt(moneyInput);
        if (inputMoney % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 로또 가격은 1000원 단위입니다!");
        for (String lottoMoney : moneyInput.split("")) {
            myLotto.add(Integer.parseInt(lottoMoney));
        }
        return myLotto;
    }
    private static void lottoCount(int inputMoney) {
        int myCount = inputMoney / 1000;
        for (int i = 0; i < myCount; i++) ;
    }
}
