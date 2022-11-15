package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    public static final int TICKET_PRICE = 1000;
    public static final int MIN = 1;
    public static final int MAX = 45;
    public static final int SELECTED_NUMBER = 6;
    public static final int PERCENT = 100;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SELECTED_NUMBER) {
            throw new IllegalArgumentException();
        }
        Set<Integer> checkDupe = new HashSet<Integer>(numbers);
        if (checkDupe.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 숫자들은 달라야 합니다");
        }
        for (Integer i: numbers) {
            if (i < MIN || i > MAX) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자들은 1~45 의 범위 안에 있어야합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
    public static List<List<Integer>> generateLotto(Integer count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i=0; i < count; i++) {
            List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN, MAX, SELECTED_NUMBER));
            lotto.sort(Comparator.naturalOrder());
            System.out.println(lotto);
            lottos.add(lotto);
        }
        return lottos;
    }

    public static void checkBuyAmount(Integer amount) {
        if (amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위");
        }
    }

    public void validBonus(Integer bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 로또 당첨번호 중 하나입니다.");
        }
        if (bonus < MIN || bonus > MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 숫자 범위는 1~45 입니다.");
        }
    }

    public List<Integer> countWins(List<List<Integer>> lottos, Integer bonus) {
        List<Integer> places = new ArrayList<Integer>(Collections.nCopies(5, 0));
        for (List<Integer> lotto: lottos) {
            List<Integer> copiedNumbers = new ArrayList<>(numbers);
            copiedNumbers.removeAll(lotto);
            Integer matched = SELECTED_NUMBER - copiedNumbers.size();
            if (matched == 3) { places = incrementPlace(places, 0); }
            if (matched == 4) { places = incrementPlace(places, 1); }
            if (matched == 5 && lotto.contains(bonus)) { places = incrementPlace(places, 3); }
            if (matched == 5) { places = incrementPlace(places, 2); }
            if (matched == 6) { places = incrementPlace(places, 4); }
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

    public static void printStats(List<Integer> places, Integer tickets) {
        System.out.println("당첨 통계\n" + "---");
        long totalWinnings = 0;
        for (LottoStats lottoStat: LottoStats.values()) {
            int wonTickets = places.get(lottoStat.getIndex());
            System.out.printf(lottoStat.getMessage(), wonTickets);
            totalWinnings += lottoStat.getPrize() * wonTickets;
        }
        printEarnings(totalWinnings, tickets);
    }

    private static void printEarnings(long total, Integer tickets) {
        float profitPercentage = (float) total/ tickets * PERCENT;
        System.out.printf("총 수익률은 %.1f%%입니다.", profitPercentage);
    }
}
