package lotto;

import lotto.ui.Input;
import lotto.ui.Output;
import lotto.ui.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoConsole {
    private final Input input;
    private final Output output;
    private final Validator validator;

    LottoConsole() {
        this.input = new Input();
        this.output = new Output();
        this.validator = new Validator();
    }

    private void validate(String input) {
        this.validator.throwIfEmtpy(input);
        this.validator.throwIfNotNumber(input);
    }

    private Integer convertInputToNumber(String input) {
        return Integer.parseInt(input);
    }

    private List<Integer> convertInputToIntegers(String input) {
        List<Integer> numbers = Arrays.asList(input.split(",")).stream().map(String::trim).map(Integer::parseInt)
                .collect(Collectors.toList());
        return numbers;
    }

    public PurchaseAmount getPurchaseAmount() {
        String input = this.input.getPurchaseAmount();
        this.validate(input);
        Integer purchaseAmount = this.convertInputToNumber(input);
        return new PurchaseAmount(purchaseAmount);
    }

    public Lotto getWinningLottoNumbers() {
        String input = this.input.getWinningLottoNumbers();
        List<Integer> numbers = this.convertInputToIntegers(input);
        return new Lotto(numbers);
    }

    public LottoNumber getBonusLottoNumber() {
        String input = this.input.getBonusLottoNumber();
        this.validate(input);
        Integer bonusNumber = this.convertInputToNumber(input);
        return new LottoNumber(bonusNumber);
    }

    public void printLottos(List<Lotto> lottos) {
        this.output.printNumberOfPurchase(lottos.size());
        for (Lotto lotto : lottos) {
            this.output.printLotto(lotto);
        }
    }

    public void printResult(Result result) {
        this.output.printResult(result);
        this.output.printBlankLine();
        this.output.printStatics(result.getPrizePerPurchaseAmount());
    }

    public void printBlank() {
        this.output.printBlankLine();
    }
}
