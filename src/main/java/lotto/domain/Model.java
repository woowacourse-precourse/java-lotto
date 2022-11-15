package lotto.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.HashMap;

public class Model {

    public List<List<Integer>> USERS_LOTTOS;
    public HashMap <Integer, Integer> PRIZE_RANKINGS;
    private int MONEY;
    private int BONUS_NUMBER;

    // 로또 번호 비교하는 시작점, 입력한 금액, 보너스 번호를 필드값에 입력
    public HashMap<Integer, Integer> checkPrize(int money, int bonusNumber, List<Integer> lottoNumbers) {
        this.MONEY = money;
        this.BONUS_NUMBER = bonusNumber;
        RandomLotto randomLotto = new RandomLotto(MONEY);
        this.USERS_LOTTOS = randomLotto.getLottos();
        checkLottoNumber(lottoNumbers);

        return PRIZE_RANKINGS;
    }

    // 계산된 수익률을 반환하는 메서드
    public double getRateOfProfit () {
        return calculateRateOfIncome(MONEY);
    }

    // 생성된 로또 마다 입력한 로또 번호랑 비교하는 메서드
    public void checkLottoNumber (List<Integer> lottoNumbers) {
        List<Integer> duplicatedNumbers = new ArrayList<>();

        for (List<Integer> lotto: USERS_LOTTOS){
            List<Integer> comparingNumbers = lotto.stream()
                    .filter(lottoNumbers::contains)
                    .collect(Collectors.toList());

                duplicatedNumbers.add(comparingNumbers.size());
            }

        checkPrizeLotto(duplicatedNumbers);
    }

    // 입력한 로또 번호랑 생성된 로또 번호 비교값을 순위로 변환해서 반환하는 메서드
    public void checkPrizeLotto (List<Integer> duplicatedNumbers) {
        List<Integer> prizeRankings = new ArrayList<>();

        for (int number: duplicatedNumbers) {
            prizeRankings.add(addPrizeRanking(number));
        }

        checkBonusNumber(prizeRankings);

        PRIZE_RANKINGS = makeNumberByRanking(prizeRankings);
    }

    // 입력한 로또 번호가 5개 이상인 로또를 대상으로 보너스 번호가 포함되어 있는지 확인하는 메서드
    private void checkBonusNumber(List<Integer> prizeRankings){
        int changedRanking;

        for (int temp = 0; temp < prizeRankings.size(); temp++) {

            if (prizeRankings.get(temp) == Prize.THIRD.getRanking()) {
                changedRanking = upRanking(USERS_LOTTOS.get(temp), BONUS_NUMBER);
                prizeRankings.set(temp, changedRanking);
            }
        }
    }

    // 순위 별로 값이 0인(텅 빈) Map 생성
    private HashMap<Integer, Integer> makeNumberByRanking (List<Integer> prizeRankings) {
        HashMap<Integer, Integer> numberByRanking = new HashMap<>();

        for (int temp = Prize.FIFTH.getRanking(); temp >= Prize.FIRST.getRanking(); temp--) {
            numberByRanking.put(temp, 0);
        }

        inputNumberByRanking(prizeRankings, numberByRanking);

        return numberByRanking;
    }

    // 5개가 일치한 로또가 보너스 번호가 포함되어 있다면 순위를 올리는 메서드
    private int upRanking (List<Integer> usersLotto, int bonusNumber) {
        if (usersLotto.contains(bonusNumber)) {
            return Prize.SECOND.getRanking();
        }
        return Prize.THIRD.getRanking();
    }

    // 순위 리스트를 받아 Map으로 값을 추가시키는 메서드
    private void inputNumberByRanking (List<Integer> prizeRankings, HashMap<Integer, Integer> numberByRanking) {

        for (int ranking: prizeRankings) {
            if (ranking > 0) {
                numberByRanking.put(ranking, numberByRanking.get(ranking) + 1);
            }
        }
    }

    // 일치하는 값을 순위로 변환시키는 메서드
    private int addPrizeRanking(int duplicatedNumber) {
        if (duplicatedNumber == 3) return Prize.FIFTH.getRanking();
        if (duplicatedNumber == 4) return Prize.FORTH.getRanking();
        if (duplicatedNumber == 5) return Prize.THIRD.getRanking();
        if (duplicatedNumber == 6) return Prize.FIRST.getRanking();
        return 0;
    }

    // 수익률 계산하는 메서드
    public double calculateRateOfIncome (int money) {
        int totalIncome = 0;

        for (int ranking: PRIZE_RANKINGS.keySet()) {
            totalIncome += incomeByRanking(ranking, PRIZE_RANKINGS.get(ranking));
        }

        return (double)totalIncome / money;
    }

    // 당첨된 순위에 해당하는 금액을 반환하는 메서드
    public int incomeByRanking (int ranking, int numberOfRanking) {
        if (ranking == 1) return Prize.FIRST.getPrize() * numberOfRanking;
        if (ranking == 2) return Prize.SECOND.getPrize() * numberOfRanking;
        if (ranking == 3) return Prize.THIRD.getPrize() * numberOfRanking;
        if (ranking == 4) return Prize.FORTH.getPrize() * numberOfRanking;
        if (ranking == 5) return Prize.FIFTH.getPrize() * numberOfRanking;
        return 0;
    }


    // 순위 별 당첨금액이 저장된 enum클래스
    private enum Prize {
        FIRST(2_000_000, 1),
        SECOND(30_000, 2),
        THIRD(1_500, 3),
        FORTH(50, 4),
        FIFTH(5, 5);

        final private int prize;
        final private int ranking;
        private int getPrize() {
            return prize;
        }
        private int getRanking() {
            return ranking;
        }
        Prize(int prize, int ranking) {
            this.prize = prize;
            this.ranking = ranking;
        }
    }
}
