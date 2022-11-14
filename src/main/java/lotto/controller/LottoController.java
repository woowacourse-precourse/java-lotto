package lotto.controller;

import lotto.controller.validator.BonusNumberValidator;
import lotto.controller.validator.MoneyValidator;
import lotto.controller.validator.WinningNumberValidator;
import lotto.domain.Lotto;
import lotto.service.LottoGameService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController implements Controller {

    private final LottoGameService service;

    public LottoController(LottoGameService service) {
        this.service = service;
    }

    public void inputMoney(String input) {
        validateInput(input, MoneyValidator.values());
        int money = Integer.parseInt(input);
        service.buyLottos(money);
    }

    public String outputLottoSize() {
        return String.valueOf(service.getLottosSize());
    }

    public String outputLottos() {
        return service.getLottosToString();
    }

    public void inputWinningNumber(String input) {
        validateInput(input, WinningNumberValidator.values());
        List<Integer> winningNumber = separateStringWithComma(input);
        Lotto winningLotto = new Lotto(winningNumber);
        service.setWinningLotto(winningLotto);
    }

    public List<Integer> separateStringWithComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void inputBonusNumber(String input) {
        validateInput(input, BonusNumberValidator.values());
        int number = Integer.parseInt(input);
        service.setBonusNumber(number);
    }

    public String outputStatics() {
        service.getStatics();
        return null;
    }
}
