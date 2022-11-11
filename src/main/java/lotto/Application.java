package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    public static void main(String[] args) {
        long price = askPrice();
        List<Lotto> lottos = makeLotto(price);
        List<Integer> winningLotto = askWinning();
        int bonusNumber = askBonus();
        Rank.calcRank(price, lottos, winningLotto, bonusNumber);
    }

    public static int askBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = readLine();
        int num = validateNumber(input);
        return num;
    }

    public static List<Integer> askWinning() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        List<Integer> nums = new ArrayList<>();
        for (String str : input.split(",")) {
            int num = validateNumber(str);
            nums.add(num);
        }

        new Lotto(nums); // 로또 당첨 번호 유효성 검사
        return nums;
    }

    public static int validateNumber(String str) {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
        if(num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 ~ 45여야 합니다.");
        }
        return num;
    }

    public static List<Lotto> makeLotto(long price) {
        if(price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 가격은 1000원 단위여야 합니다.");
        }
        long amount = price / 1000;
        System.out.println(amount + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        while(lottos.size() < amount) {
            List<Integer> nums = pickUniqueNumbersInRange(1, 45, 6);
            nums = nums.stream().sorted().collect(Collectors.toList());
            Lotto lotto = new Lotto(nums);
            lottos.add(lotto);
        }

        for(Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        return lottos;
    }

    public static long askPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        return Long.parseLong(input);
    }

}
