package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> checkDupe = new HashSet<Integer>(numbers);
        if (checkDupe.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 숫자들은 달라야 합니다");
        }
        for (Integer i: numbers) {
            if (i < 1 || i > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자들은 1~45 의 범위 안에 있어야합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
    public static List<List<Integer>> generateLotto(Integer count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i=0; i < count; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(lotto);
            System.out.println(lotto);
        }
        return lottos;
    }

    public static void checkBuyAmount(Integer amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위");
        }
    }

    public void validBonus(Integer bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호가 이미 로또 당첨번호 중 하나입니다.");
        }
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("보너스 번호의 숫자 범위는 1~45 입니다.");
        }
    }

    public List<Integer> countWins(List<List<Integer>> lottos, Integer bonus) {
        List<Integer> places = new ArrayList<Integer>(Collections.nCopies(5, 0));
        for (List<Integer> lotto: lottos) {
            List<Integer> copiedNumbers = new ArrayList<>(numbers);
            copiedNumbers.removeAll(lotto);
            Integer matched = 6 - copiedNumbers.size();
            if (matched == 3) {
                places = incrementPlace(places, 0);
            }
            if (matched == 4) {
                places = incrementPlace(places, 1);
            }
            if (matched == 5 && lotto.contains(bonus)) {
                places = incrementPlace(places, 3);
            }
            if (matched == 5) {
                places = incrementPlace(places, 2);
            }
            if (matched == 6) {
                places = incrementPlace(places, 4);
            }
            //I could do less ifs with different list order but this is easier to read
        }
        return places;
    }

    private List<Integer> incrementPlace(List<Integer> places, int index) {
        Integer count = places.get(index);
        count += 1;
        places.set(index, count);
        return places;
    }

    public static void printStats(List<Integer> places, Integer amount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", places.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", places.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", places.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", places.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", places.get(4));
        if (amount == 0) {
            System.out.printf("총 수익률은 0%%입니다.");
            return;
        }
        Integer total = 0;
        total += places.get(0) * 5000;
        total += places.get(1) * 50000;
        total += places.get(2) * 1500000;
        total += places.get(3) * 30000000;
        total += places.get(4) * 2000000000;
        float profitRate = (float)total/amount * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);

    }
}
