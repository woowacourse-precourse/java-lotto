package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int getLottoCount(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 숫자로만 이루어져야 합니다.");
        }

        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력 금액은 1000원 단위로 입력해야 합니다.");
        }

        return money / 1000;
    }

    public static List<Lotto> buyLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    public static List<Integer> getMatches(List<Lotto> lottos, List<Integer> winNumbers, Integer bonusNumber) {
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

    public static double getRate(int lottoCount, List<Integer> matches) { // 순서대로 [ 3개, 4개, 5개, 5개+보너스, 6개 ] 개수
        int originMoney = lottoCount * 1000;
        long resultMoney = 0;
        resultMoney += matches.get(0) * 5000;
        resultMoney += matches.get(1) * 50000;
        resultMoney += matches.get(2) * 150000;
        resultMoney += matches.get(3) * 30000000;
        resultMoney += matches.get(4) * 2000000000;

        return (double) originMoney / (double) resultMoney;
    }
}