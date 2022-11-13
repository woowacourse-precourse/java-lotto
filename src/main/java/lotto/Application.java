package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        List<Lotto> lottoList;

        try {
            lottoList = buyLotteries(getLottoBuyCount());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    private static Integer getLottoBuyCount() {
        Integer money;

        System.out.println("구입금액을 입력해 주세요.");
        try {
            money = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        if (money % 1000 > 0)
            throw new IllegalArgumentException("1000으로 나누어지는 값을 입력해야 합니다.");

        return money / 1000;
    }

    private static Lotto buyLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(numbers);
    }

    private static List<Lotto> buyLotteries(Integer count) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int num = 0;num < count;num++)
            lottoList.add(buyLotto());

        return lottoList;
    }
}
