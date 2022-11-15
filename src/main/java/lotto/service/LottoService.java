package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.util.ParsingUtils;
import lotto.view.LottoView;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위입니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATED_ERROR_MESSAGE = "[ERROR] 중복된 로또 번호가 존재합니다.";
    private static final LottoService INSTANCE = new LottoService();

    private final LottoView lottoView;

    private LottoService() {
        lottoView = LottoView.getInstance();
    }

    public static LottoService getInstance() {
        return INSTANCE;
    }

    public void start() {
        lottoView.printMoneyInputMessage();
        int inputMoney = getInputMoney();

        Lottos lottos = new Lottos(inputMoney / LOTTO_PRICE);
        lottoView.printLottos(lottos);

        lottoView.printWinningNumberInputMessage();
        Lotto winningNumber = new Lotto(ParsingUtils.stringToNumbers(Console.readLine()));

        Result result = new Result(inputMoney, lottos, winningNumber, getBonusNumber(winningNumber));
        lottoView.printResult(result);
    }

    private int getInputMoney() {
        int inputMoney = ParsingUtils.stringToInt(Console.readLine());

        if (inputMoney <= 0 || inputMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
        }

        return inputMoney;
    }

    private int getBonusNumber(Lotto winningNumbers) {
        lottoView.printBonusNumberInputMessage();
        int bonusNumber = ParsingUtils.stringToInt(Console.readLine());

        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATED_ERROR_MESSAGE);
        }

        return bonusNumber;
    }
}
