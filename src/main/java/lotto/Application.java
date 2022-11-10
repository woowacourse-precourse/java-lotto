package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        int pay = inputPay();
        int lottoCount = pay/1_000;
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<List<Integer>> lottoNumbers = pickLottoNumbers(lottoCount);
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winNumbers = inputWinNumbers(Console.readLine());
        Lotto lotto = new Lotto(winNumbers);
        int bonusNum = lotto.inputBonusNumber();
        Map<List<Integer>, Integer> lottoResult = new HashMap<>();
        int result = 0;
        for (List<Integer> num : lottoNumbers) {
            int correctCount = 0;
            for (int i : num) {
                if (winNumbers.contains(i)) {
                    correctCount++;
                }
                if (correctCount == 5 && num.contains(bonusNum)) {
                    correctCount += 2;
                }
            }
            Rank rank = Rank.getRank(correctCount);
            System.out.println(rank);
            result += rank.getRank();
            lottoResult.put(num, correctCount);
        }
        int first = 0, second = 0, third = 0, fourth = 0, fifth = 0;
        for (int i : lottoResult.values()) {
            if (i == 7)
                second++;
            if (i == 6)
                first++;
            if (i == 5)
                third++;
            if (i == 4)
                fourth++;
            if (i == 3)
                fifth++;
        }
        int resultMoney = 2_000_000_000*first + 30_000_000*second + 1_500_000*third + 50_000*fourth + 5_000*fifth;
        double profit = Math.round(((double) resultMoney/(double) pay) * 10000);
        BigDecimal profitPercent = new BigDecimal(String.valueOf(Double.parseDouble(String.valueOf(profit/100))));
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifth + "개");
        System.out.println("4개 일치 (50,000원) - " + fourth + "개");
        System.out.println("5개 일치 (1,500,000원) - " + third + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + second + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + first + "개");
        System.out.println("총 수익률은 " + profitPercent.toPlainString() + "%입니다.");

    }

    public static int inputPay() {
        System.out.println("구입금액을 입력해 주세요.");
        return checkPay(Console.readLine());
    }

    public static int checkPay(String str) {
        int pay = 0;
        try {
            pay = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자만 입력하실 수 있습니다.");
            //throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력하실 수 있습니다.");
        }
        if (pay % 1_000 != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }
        return pay;
    }

    public static List<List<Integer>> pickLottoNumbers(int count) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            System.out.println(numbers);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    public static List<Integer> inputWinNumbers(String str) {

        List<Integer> winNumbers = new ArrayList<>();
        try {
            winNumbers = Arrays.stream(str.split(",")).map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 당첨 번호는 숫자만 입력하실 수 있습니다.");
            throw new IllegalArgumentException();
        }
        return winNumbers;
    }

}
