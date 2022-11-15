package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;

public class Terminal implements View {
    @Override
    public String requestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public void printLottoCount(int count) {
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    @Override
    public void printLotto(List<Lotto> boughtLottoes) {
        for(Lotto lotto : boughtLottoes) {
            System.out.println(lotto.getNumbers());
        }
    }

    @Override
    public String requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public String requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public void printResult(double ratio) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for(Rank rank : Rank.values()) {
            System.out.println(rank.getMessage() + rank.getAchievedCount() + "개");
        }
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", ratio));
    }
}
