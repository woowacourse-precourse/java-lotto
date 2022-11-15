package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import repository.LottoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class LottoService {
    private final LottoRepository lottoRepository;

    public LottoService() {
        this.lottoRepository = new LottoRepository();
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

    }

    private void validateWinningNumbers(String numbers) {
        checkWinningNumbersFormat(numbers);
    }

    private void checkWinningNumbersFormat(String numbers) {
        Format winningNumbers = Format.WINNING_NUMBERS;

        if (!Pattern.matches(winningNumbers.getRegex(), numbers)) {
            throw new IllegalArgumentException(Error.WINNING_NUMBERS_FORMAT.getText());
        }
    }
}
