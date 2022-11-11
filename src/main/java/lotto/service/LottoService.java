package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.message.ErrorMessage;
import lotto.repository.LottoRepository;
import lotto.validation.Validator;
import lotto.view.input.Input;
import lotto.view.output.Output;

import java.util.Collections;
import java.util.List;

public class LottoService {

    LottoRepository lottoRepository;
    Validator validator;

    Input input;

    Output output;
    public LottoService() {
        this.lottoRepository = new LottoRepository();
        this.validator = new Validator();
        this.input = new Input();
        this.output = new Output();
    }

    public int getMoney() throws IllegalArgumentException{
        String money = input.scanMoneyInput();
        if (!validator.isNumeric(money)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_TYPE_ERROR.getErrorMessage());
        }
        if (!validator.isCorrectUnit(money)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.getErrorMessage());
        }
        return Integer.parseInt(money);
    }

    public void buyLotto(int money) throws IllegalArgumentException {
        int buyCount = money/1000;
        output.printLottoCountForBuy(buyCount);
        pickAndSaveLotto(buyCount);
        List<Lotto> lottos = lottoRepository.findAll();
        output.printAllLottos(lottos);

    }

    public void pickAndSaveLotto(int buyCount) {
        while (buyCount-- > 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoRepository.add(lotto);
        }
    }
}
