package lotto.service;

import static lotto.Constants.LOTTO_NUMBERS_SIZE;
import static lotto.Constants.MAXIMUM_LOTTO_NUMBER;
import static lotto.Constants.MINIMUM_LOTTO_NUMBER;
import static lotto.Constants.MINIMUM_PURCHASE_AMOUNT;
import static lotto.Constants.PURCHASE_AMOUNT_IS_NOT_DIVIDED_ERROR_MESSAGE;
import static lotto.Constants.PURCHASE_AMOUNT_IS_NOT_IN_RANGE_ERROR_MESSAGE;
import static lotto.Constants.PURCHASE_AMOUNT_IS_NOT_NUMBER_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.repository.UserLottoRepository;

public class UserLottoService {
    private static UserLottoService instance;
    private static UserLottoRepository userLottoRepository;

    private UserLottoService() {
        userLottoRepository = UserLottoRepository.getInstance();
    }

    public static UserLottoService getInstance() {
        if (instance == null) {
            instance = new UserLottoService();
        }
        return instance;
    }

    public void validate(String purchaseAmount) throws IllegalArgumentException {
        boolean isNumber = purchaseAmount.chars().allMatch(Character::isDigit);
        if (!isNumber) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_NOT_NUMBER_ERROR_MESSAGE);
        }
        long amount = Long.parseLong(purchaseAmount);
        if (amount < MINIMUM_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_NOT_IN_RANGE_ERROR_MESSAGE);
        }
        if (amount % MINIMUM_PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_IS_NOT_DIVIDED_ERROR_MESSAGE);
        }
    }

    public void issueLotto(long issueCnt) throws IllegalArgumentException {
        for (int i = 0; i < issueCnt; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER,
                    LOTTO_NUMBERS_SIZE));
            userLottoRepository.save(lotto);
        }
    }

    public List<Lotto> getLotteries() {
        return userLottoRepository.findAll();
    }
}
