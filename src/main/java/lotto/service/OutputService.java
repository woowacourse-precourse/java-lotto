package lotto.service;

import lotto.Prize;

import java.util.HashMap;
import java.util.List;

public class OutputService {

    public void requestMoney() {
        System.out.println("구입금액을 입력해주세요");
    }

    public void printAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printLotto(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void requestWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printPerior() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public boolean printPrize(int sameAmount, int reward, int count) {
        if (reward == 30_000_000) {
            System.out.println("5개 일치, 보너스 볼 일치 ("+reward+"원) - " + count);
            return true;
        }
        System.out.println(sameAmount + "개 일치 ("+reward+"원) - " + count);
        return true;
    }

    public void getRate(int price, int money) {
        double result = (double) price / (double) money * 100.0;
        System.out.println("총 수익률은 " + String.format("%.2f", result) + "%입니다." );
    }
}
