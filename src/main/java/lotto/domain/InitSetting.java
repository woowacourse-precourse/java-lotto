package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.MoneyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InitSetting {
    // 초기화
    int money=0;
    int count = 0;
    boolean bonusCheck = false;
    int price = 0;
    String msg = "";
    List<List<Integer>> lottoNumbers = new ArrayList<>();

    // 입력
    public void setInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    // 입력 예외 처리
    public void setException() {
        try {
            money = Integer.parseInt(Console.readLine());
            count=money/1000;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
        try {
            MoneyException moneyException = new MoneyException(money);
            money = money / (moneyException.result());
        } catch (ArithmeticException e) {
            System.out.println("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public void setLottoNumbers(List<List<Integer>> list){
        this.lottoNumbers=list;
    }
    public List<List<Integer>> getLottoNumbers(){return lottoNumbers;}
    public int getMoney(){return money;}
    public void setMoney(int money){this.money=money;}
    public int getCount(){return count;}
    public void setCount(int count){this.count=count;}
    public boolean getBonusCheck(){return bonusCheck;}
}
// 입력 수 만큼 6개의 랜덤 숫자 생성
class SetRandomSixNumber {
    public List<List<Integer>> randomNumber(int money, List<List<Integer>> lottoNumbers) {
        int count = money / 1000;
        for (int i = 0; i < count; i++) {
            List<Integer> lottoNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
        // 생성한 랜덤 숫자 배열 출력
        System.out.println("\n" + count + "개를 구매했습니다.");
        for (int i = 0; i < count; i++) {
            System.out.println(lottoNumbers.get(i));
        }
        return lottoNumbers;
    }
}

