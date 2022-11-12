package lotto;

import java.util.List;

public class Message {
    public static void buyLottos() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void lottosNum(Integer n) {
        System.out.println(n + "개를 구매했습니다.");
    }

    public static void lottos(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void winningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void lankings(Match match) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + match.getMatches().get(Lanking.rank5) + "개");
        System.out.println("4개 일치 (50,000원) - " + match.getMatches().get(Lanking.rank4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + match.getMatches().get(Lanking.rank3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + match.getMatches().get(Lanking.rank2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) -  " + match.getMatches().get(Lanking.rank1) + "개");
    }

    public static void yield(Double yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
