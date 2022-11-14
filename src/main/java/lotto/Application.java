package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.Winning;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        int number = 0;

        try {
            if (Integer.parseInt(amount) % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000 단위로 입력해 주세요.");
            }
            number = Integer.parseInt(amount) / 1000;
        }catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해주세요.");
        }

        System.out.println();
        System.out.println(number +"개를 구매했습니다.");

        User user = new User();
        List<Lotto> list = user.randomLotto(number);

        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).getNumbers());
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        String win = Console.readLine();
        Winning winning = new Winning();
        Lotto lotto = new Lotto(winning.winning(win));

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        try {
            int bonusNum = Integer.parseInt(Console.readLine());

            if (lotto.getNumbers().contains(bonusNum)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복 됩니다.");
            }

            if (bonusNum<0 || bonusNum>46) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 46의 숫자만 입력해 주세요.");
            }

            user.setBonusNum(bonusNum);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }

        winning.score(list, lotto.getNumbers(), user.getBonusNum());

        List<Integer> score = winning.score();

        double rate = winning.rate(score, Integer.parseInt(amount));

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " +winning.win5 +"개");
        System.out.println("4개 일치 (50,000원) - " +winning.win4 +"개");
        System.out.println("5개 일치 (1,500,000원) - " +winning.win3 +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +winning.win2 +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " +winning.win1 +"개");
        System.out.println("총 수익률은 " +rate +"%입니다.");
    }
}
