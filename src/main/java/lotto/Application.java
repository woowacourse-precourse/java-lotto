package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.Winning;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();
        int number = Integer.parseInt(amount) / 1000;
        System.out.println();
        System.out.println(number +"개를 구매했습니다.");

        User user = new User();
        List<List<Integer>> list = user.randomLotto(number);

        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        String win = Console.readLine();
        Winning winning = new Winning();
        Lotto lotto = new Lotto(winning.winning(win));

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        user.setBonusNum(Integer.parseInt(Console.readLine()));

        
    }
}
