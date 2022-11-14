package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = getLotto();
        if (str.equals("ERROR")) {
            return;
        }
        Integer price = Integer.valueOf(str);

        List<Lotto> randomLottoList = getLottoList(price);

        Lotto lotto = getNums();

        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNum = Integer.getInteger(Console.readLine());

        float[] match = {0F, 0F, 0F, 0F, 0F, 0F};

        System.out.println("당첨통계");
        System.out.println("---");
        for (int i = 0; i < randomLottoList.size(); i++) {
            int matchCount = matchCount(randomLottoList.get(i), lotto.getNumbers());

            boolean bonusResult = false;
            if (lotto.getNumbers().contains(bonusNum)) {
                bonusResult = true;
            }

            int result = getResult(matchCount, bonusResult).getValue();

            match[result]++;
        }

        Float sum = match[0] * 5000 + match[1] * 50000 + match[2] * 1500000 + match[3] * 30000000 + match[4] * 2000000000;
        System.out.println(String.format("3개 일치 (5,000원) - %.0f개", match[0]));
        System.out.println(String.format("4개 일치 (50,000원) - %.0f개", match[1]));
        System.out.println(String.format("5개 일치 (1,500,000원) - %.0f개", match[2]));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %.0f개", match[3]));
        System.out.println(String.format("6개 일치 (2,000,000,000원) - %.0f개", match[4]));
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", sum/Float.valueOf(price) * 100));

    }

    public enum matching{
        three(0), four(1), five(2), fiveAndBonus(3), six(4), none(5);

        private final int value;

        matching(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private static matching getResult(int matchCount, boolean bonusResult) {
        if (matchCount == 6) {
            return matching.six;
        }
        if (matchCount == 5 && bonusResult) {
            return matching.fiveAndBonus;
        }
        if (matchCount == 5) {
            return matching.five;
        }
        if (matchCount == 4) {
            return matching.four;
        }
        if (matchCount == 3) {
            return matching.three;
        }
        return matching.none;
    }

    public static String getLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        try {
            Integer.valueOf(price);
        } catch (Exception e) {
            System.out.println("[ERROR] 숫자 변환이 불가능한 경우");
            return "ERROR";
//            throw new IllegalArgumentException("[ERROR] 숫자 변환이 불가능한 경우");
        }
        if (Integer.valueOf(price)%1000 != 0) {
            System.out.println("[ERROR] 1000으로 나누어 떨어지지 않는 경우");
            return "ERROR";
//            throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지지 않는 경우");
        }
        return price;
    }

    public static Lotto getNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNums = Console.readLine();
        List<Integer> nums = new ArrayList<>();
        while (winningNums.contains(",")) {
            String substring = winningNums.substring(0, winningNums.indexOf(","));
            nums.add(Integer.valueOf(substring));
            winningNums = winningNums.substring(winningNums.indexOf(",") + 1, winningNums.length());
        }
        nums.add(Integer.valueOf(winningNums));
        Lotto lotto = new Lotto(nums);
        return lotto;
    }

    public static List<Lotto> getLottoList(Integer price) {

        Integer count = Integer.valueOf(price)/1000;
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> randomNumsList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> randomNums = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            List<Integer> sortedRandomNums = new ArrayList(randomNums);
            sortedRandomNums.sort(Comparator.naturalOrder());
            Lotto lotto = new Lotto(sortedRandomNums);
            randomNumsList.add(lotto);
            System.out.println(lotto.getNumbers());
        }

        return randomNumsList;
    }

    public static int matchCount(Lotto randomNums, List<Integer> nums) {
        int matchCount = 0;
        for (int j = 0; j < nums.size(); j++) {
            if (randomNums.getNumbers().contains(nums.get(j))) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
