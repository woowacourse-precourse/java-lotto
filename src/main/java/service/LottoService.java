package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import repository.LottoRepository;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoService {
    private final LottoRepository lottoRepository;

    public LottoService(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void publishLotto(int purchaseAmount) {
        Rule lotto = Rule.PER_LOTTO;

        int lottoCount = purchaseAmount / lotto.getPrice();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(lotto.getMinNumber(), lotto.getMaxNumber(), lotto.getCount());
            numbers.sort(Comparator.naturalOrder());
            Lotto publishLotto = new Lotto(numbers);

            lottoRepository.save(publishLotto);
        }
    }

    public List<Lotto> getPublishedLotto() {
        return lottoRepository.getPublishedLotto();
    }

    public void saveWinningNumbers(String numbers) {
        List<Integer> winningNumbers = validateWinningNumbers(numbers);
        lottoRepository.saveWinningNumbers(winningNumbers);
    }

    private List<Integer> validateWinningNumbers(String numbers) {
        checkWinningNumbersFormat(numbers);

        List<Integer> winningNumbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        checkIncludeSameNumber(winningNumbers);

        return winningNumbers;
    }

    private void checkWinningNumbersFormat(String numbers) {
        Format winningNumbers = Format.WINNING_NUMBERS;

        if (!Pattern.matches(winningNumbers.getRegex(), numbers)) {
            throw new IllegalArgumentException(Error.WINNING_NUMBERS_FORMAT.getText());
        }
    }

    private void checkIncludeSameNumber(List<Integer> winningNumbers) {
        int uniqueNumberCount = (int) winningNumbers.stream()
                .distinct()
                .count();

        if (uniqueNumberCount != Rule.PER_LOTTO.getCount()) {
            throw new IllegalArgumentException(Error.WINNING_NUMBERS_INCLUDE_SAME_NUMBER.getText());
        }
    }

    public void saveBonusNumber(String number) {
        validateBonusNumber(number);
        lottoRepository.saveBonusNumber(Integer.parseInt(number));
    }

    private void validateBonusNumber(String number) {
        checkBonusNumberFormat(number);

        int bonusNumber = Integer.parseInt(number);
        checkBonusNumberInWinningNumber(bonusNumber);
    }

    private void checkBonusNumberFormat(String number) {
        Format bonusNumber = Format.BONUS_NUMBER;

        if (!Pattern.matches(bonusNumber.getRegex(), number)) {
            throw new IllegalArgumentException(Error.BONUS_NUMBER_FORMAT.getText());
        }
    }

    private void checkBonusNumberInWinningNumber(int number) {
        List<Integer> winningNumbers = lottoRepository.getWinningNumbers();

        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(Error.BONUS_NUMBER_IN_WINNING_NUMBER.getText());
        }
    }

    public void saveWinners() {
        List<Lotto> publishedLotto = lottoRepository.getPublishedLotto();
        List<Integer> winningNumbers = lottoRepository.getWinningNumbers();
        int bonus = lottoRepository.getBonusNumber();

        EnumMap<Winner, Integer> winners = checkWin(publishedLotto, winningNumbers, bonus);
        lottoRepository.saveWinners(winners);
    }

    private EnumMap<Winner, Integer> checkWin(List<Lotto> publishedLotto, List<Integer> winningNumbers, int bonus) {
        EnumMap<Winner, Integer> winners = new EnumMap<>(Winner.class);

        publishedLotto.stream().map(Lotto::getNumbers)
                .forEach(numbers -> {
                    int match = (int) numbers.stream().filter(winningNumbers::contains).count();

                    if (match == Winner.THIRD_PLACE.getMatch() && numbers.contains(bonus)) {
                        winners.put(Winner.SECOND_PLACE, winners.getOrDefault(Winner.SECOND_PLACE, 0) + 1);
                        return;
                    }
                    winners.put(Winner.getByMatch(match), winners.getOrDefault(Winner.getByMatch(match), 0) + 1);
                });
        return winners;
    }

    public EnumMap<Winner, Integer> getWinners() {
        return lottoRepository.getWinners();
    }

}
