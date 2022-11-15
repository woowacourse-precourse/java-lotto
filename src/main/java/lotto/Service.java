package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {
    public int getLottoCount(String input) {
        if (!input.matches("[0-9]+")) {
                throw new IllegalArgumentException("[ERROR] 입력 금액은 숫자로만 이루어져야 합니다.");
            }
            int money = Integer.parseInt(input);
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위로 입력해야 합니다.");
            }
            return money / 1000;
    }

    public List<Lotto> buyLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    public List<Integer> getMatches(List<Lotto> lottos, List<Integer> winNumbers, Integer bonusNumber) {
        List<Integer> matches = new ArrayList<>(Arrays.asList(0,0,0,0,0));  // 순서대로 [ 3개, 4개, 5개, 5개+보너스, 6개 ] 개수

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatches(winNumbers);
            if (matchCount == 5 && lotto.matchesBonus(bonusNumber)) {
                matches.set(3, matches.get(3) + 1);
            }
            if (matchCount >= 3 && matchCount < 6) {
                matches.set( matchCount - 3, matches.get(matchCount - 3) + 1);
            }
            if (matchCount == 6) {
                matches.set( 4, matches.get(4) + 1);
            }
        }

        return matches;
    }

    public double getRate(int lottoCount, List<Integer> matches) { // 순서대로 [ 3개, 4개, 5개, 5개+보너스, 6개 ] 개수
        int originMoney = lottoCount * 1000;
        long resultMoney = 0;
        resultMoney += matches.get(0) * 5000;
        resultMoney += matches.get(1) * 50000;
        resultMoney += matches.get(2) * 150000;
        resultMoney += matches.get(3) * 30000000;
        resultMoney += matches.get(4) * 2000000000;

        if (resultMoney == 0) return 0.0;
        return (double) resultMoney * 100.0 / (double) originMoney;
    }

    public int getLottoNumber(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 숫자로만 이루어져야 합니다.");
        }
        int lotto = Integer.parseInt(input);

        if (lotto < 1 || lotto > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        return lotto;
    }

    public List<Integer> getWinNumbers(String input) {
        List<Integer> lottos = new ArrayList<>();
        String[] inputs = input.split(",");

        if (inputs.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개이어야 합니다.");
        }

        for (int i = 0; i < 6; i++) {
            lottos.add(getLottoNumber(inputs[i]));
        }

        return lottos;
    }

    public void printStat(List<Lotto> lottos, List<Integer> winNumbers, Integer bonus) {
        List<Integer> matches = getMatches(lottos, winNumbers, bonus); // 순서대로 [ 3개, 4개, 5개, 5개+보너스, 6개 ] 개수
        String percent = String.format("%.1f", getRate(lottos.size(), matches));
        percent = percent.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
        System.out.println("3개 일치 (5,000원) - " + matches.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + matches.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matches.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matches.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matches.get(4) + "개");
        System.out.println("총 수익률은 " + percent + "%입니다.");
    }
}
