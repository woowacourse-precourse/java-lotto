package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoTickets {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;

    private final List<Lotto> lottoTickets;

    public LottoTickets(Purchase purchase) {
        this.lottoTickets = makeLottoTickets(purchase.getAmount());
    }

    public List<Lotto> getTickets() {
        return lottoTickets;
    }

    private List<Lotto> makeLottoTickets(int amount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE, LOTTO_SIZE);
            Lotto lotto = new Lotto(sortNumbers(numbers));
            lottoNumbers.add(lotto);
        }
        return lottoNumbers;
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> unmodifiableNumbers = Collections.unmodifiableList(numbers);
        List<Integer> mutableNumbers = new ArrayList<>(unmodifiableNumbers);
        Collections.sort(mutableNumbers);
        return mutableNumbers;
    }
}
