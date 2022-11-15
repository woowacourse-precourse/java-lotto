package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO = 6;
    private static final String DELIMITER = "";
    private static final String NEW_LINE = "\n";

    private int generated_lotto;
    private List<Lotto> lottoOfBuyer;

    public LottoGenerator() {

        lottoOfBuyer = new ArrayList<>();
    }

    public List<Integer> createLotto() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, NUMBER_OF_LOTTO);
    }

    public List<Lotto> generateLottoOfBuyer(int numberOfTickets) {
        lottoOfBuyer = new ArrayList<>();
        while (LottoGenerator.this.generated_lotto < numberOfTickets) {
            List<Integer> lottoNumbers = createLotto();
            lottoOfBuyer.add(new Lotto(lottoNumbers));
            ++LottoGenerator.this.generated_lotto;
        }
        return lottoOfBuyer;
    }

    public List<Lotto> getLottoOfBuyer() {
        return lottoOfBuyer;
    }

    public Stream<Integer> sortLottoNumbers(Lotto lotto) {
        return lotto.getLotto().stream().sorted(Comparator.naturalOrder());
    }

    public String createLottoNumberFormat(Stream<Integer> sortedLottoNumbers) {
        return Arrays.toString(sortedLottoNumbers.toArray()) + NEW_LINE;
    }

    @Override
    public String toString() {
        List<String> lottoNumbers = new ArrayList<>();
        Stream<Integer> sortLottoNumbers;
        for (Lotto lotto : lottoOfBuyer) {
            sortLottoNumbers = sortLottoNumbers(lotto);
            lottoNumbers.add(createLottoNumberFormat(sortLottoNumbers));
        }
        return String.join(DELIMITER, lottoNumbers);
    }

}
