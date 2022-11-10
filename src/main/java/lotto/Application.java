package lotto;

import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    public static void main(String[] args) {
        int price = askPrice();
        List<Lotto> lottos = makeLotto(price);
    }

    public static List<Lotto> makeLotto(int price) {
        if(price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] price must divided by 1000");
        }
        int amount = price / 1000;
        List<Lotto> lottos = new ArrayList<>();
        while(lottos.size() < amount) {
            List<Integer> nums = pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto;
            try {
                lotto = new Lotto(nums);
            } catch (IllegalArgumentException e) {
                continue;
            }
            lottos.add(lotto);
        }
        return lottos;
    }

    public static int askPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();

        return Integer.parseInt(input);
    }

}
