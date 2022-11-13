package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoConsole {

    enum Prize {
        FIRST("5,000원"),
        SECOND("50,000원"),
        THIRD("1,500,000원"),
        FOURTH("30,000,000원"),
        FIFTH("2,000,000,000원");

        private final String value;

        Prize(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public String inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        System.out.println();
        return money;
    }

    public void outputLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void outputResult(List<Integer> winningList) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (%s) - %d개\n", Prize.FIRST.getValue(), winningList.get(0));
        System.out.printf("4개 일치 (%s) - %d개\n", Prize.SECOND.getValue(), winningList.get(1));
        System.out.printf("5개 일치 (%s) - %d개\n", Prize.THIRD.getValue(), winningList.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (%s) - %d개\n", Prize.FOURTH.getValue(), winningList.get(3));
        System.out.printf("6개 일치 (%s) - %d개\n", Prize.FIFTH.getValue(), winningList.get(4));
    }

    public String inputLuckyNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String luckyNumber = Console.readLine();
        System.out.println();

        return luckyNumber;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumbers = Console.readLine();
        System.out.println();

        return bonusNumbers;
    }
}
