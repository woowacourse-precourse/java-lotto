package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator validator = new Validator();

        validator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Map<Ranking,Integer> compareLottosWithLottoNumbers(List<Lotto> lottos, List<Integer> winningLottoNumbers) {
        Map<Ranking,Integer> map = new HashMap<>();

        List<Integer> winning6Numbers = winningLottoNumbers.subList(0, 6);
        winning6Numbers.sort(null);
        Integer bonusNumber = winningLottoNumbers.get(6);

        for (Lotto lotto : lottos) {
            Ranking ranking = compareEachLottoWithLottoNumbers(lotto, winning6Numbers,bonusNumber);
            map.put(ranking, map.getOrDefault(ranking, 0) + 1);
        }

        return map;
    }

    private static Ranking compareEachLottoWithLottoNumbers(Lotto lotto, List<Integer> winning6Numbers, Integer bonusNumber) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int matchingCount = 0;
        boolean isBonusNumberMatching = false;
        for (Integer number : lottoNumbers) {
            if(winning6Numbers.contains(number)){
                matchingCount ++;
            }
        }

        if(matchingCount != 6){
            isBonusNumberMatching = lottoNumbers.contains(bonusNumber);
        }

        return Ranking.findRanking(matchingCount,isBonusNumberMatching);
    }

    @Override
    public String toString() {
        List<String> stringNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            stringNumbers.add(number.toString());
        }

        return "[" + String.join(", ", stringNumbers) + "]";
    }

    public static List<Lotto> buyLottosByPurchaseMoney(int purchaseMoney) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoNum = purchaseMoney / 1000;

        for (int i = 0; i < lottoNum; i++) {
            Lotto tempLotto = new Lotto(createSortedLottoNumbers(6));
            lottos.add(tempLotto);
        }

        return lottos;
    }

    public static List<Integer> createSortedLottoNumbers(int count) {
        final int LOTTO_START_NUMBER = 1;
        final int LOTTO_END_NUMBER = 45;

        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, count);
        try {
            lottoNumbers.sort(null);
        }catch (Exception ignored) {

        }

        return lottoNumbers;
    }
}
