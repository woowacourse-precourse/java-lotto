package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoManager {
    private final LottoGenerator lottoGenerator;
    private List<Integer> luckyNumbers = new ArrayList<>();
    private int bonusNumber = 0;
    private final Map<List<Integer>, String> prize = new HashMap<>();

    public LottoManager() {
        lottoGenerator = new LottoGenerator();
        prize.put(Arrays.asList(6, 0), "FIRST");
        prize.put(Arrays.asList(5, 1), "SECOND");
        prize.put(Arrays.asList(5, 0), "THIRD");
        prize.put(Arrays.asList(4, 0), "FOURTH");
        prize.put(Arrays.asList(4, 1), "FOURTH");
        prize.put(Arrays.asList(3, 0), "FIFTH");
        prize.put(Arrays.asList(3, 1), "FIFTH");
    }

    public List<Lotto> createLottos(int count) {
        Lotto lotto;
        List<Integer> lottoNumbers;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoNumbers = lottoGenerator.createLottoNumbers();
            lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    public void setLuckyNumbers(String inputNumbers) {
        luckyNumbers = Stream.of(inputNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        validateLuckyNumber(luckyNumbers);
    }

    public void setBonusNumbers(String inputNumber) {
        bonusNumber = Integer.parseInt(inputNumber);
        checkDuplication(luckyNumbers, bonusNumber);
    }

    private static boolean isEmptyOrNull(String value) {
        return value == null || value.isEmpty();
    }

    public int getRankingIndex(Lotto lotto) {
        PrizeMoney rankingValue;
        int rankingIndex = -1;
        List<Integer> matched = lotto.getPrized(luckyNumbers, bonusNumber);
        String ranking = prize.get(matched);

        if (!isEmptyOrNull(ranking)) {
            rankingValue = PrizeMoney.valueOf(ranking);
            rankingIndex = rankingValue.ordinal();
        }

        return rankingIndex;
    }

    private void validateLuckyNumber(List<Integer> numbers) {
        if (!checkLength(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR.getMessage());
        }
        if (!checkUniqueNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getMessage());
        }
        for (int number : numbers) {
            checkRange(number);
        }
    }

    private static void checkDuplication(List<Integer> luckyNumbers, int bonusNumber) {
        if (luckyNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getMessage());
        }
    }

    private static boolean checkLength(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private static boolean checkUniqueNumber(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        return numbers.size() == checkNumbers.size();
    }

    private static void checkRange(int number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getMessage());
        }
    }
}
