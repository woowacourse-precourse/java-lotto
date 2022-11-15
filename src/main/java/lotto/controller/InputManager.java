package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoGenerator;
import lotto.model.lotto.LottoNumber;
import lotto.model.payment.Payment;

import lotto.view.ConsoleInputView;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    private final ConsoleInputView inputView;
    private final LottoGenerator lottoGenerator;

    public InputManager() {
        this.inputView = new ConsoleInputView();
        this.lottoGenerator = new LottoGenerator();
    }

    public Payment getAndProcessPaymentInput() {
        int amount = readInteger();
        return new Payment(amount);
    }

    public LottoNumber getAndProcessLottoNumberInput() {
        int number = readInteger();
        return new LottoNumber(number);
    }

    public Lotto getAndProcessLottoInput() {
        List<Integer> numbers = readIntegers();
        return lottoGenerator.generate(numbers);
    }

    private int readInteger() {
        String inputText = inputView.readInput();
        if(isNotInt(inputText)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        inputText = inputText.trim();
        return Integer.parseInt(inputText);
    }

    private List<Integer> readIntegers() {
        List<Integer> output = new ArrayList<>();

        String inputText = inputView.readInput();
        if(isNotIntegerList(inputText)) {
            throw new IllegalArgumentException("숫자를 ,로 구분하여 입력해주세요.");
        }

        inputText = inputText.trim();
        String[] splitByComma = inputText.split(",");

        for(String piece: splitByComma) {
            output.add(Integer.parseInt(piece));
        }
        return output;
    }

    private boolean isNotInt(String input) {
        input = input.trim();
        return !input.matches("-?\\d+");
    }

    private boolean isNotIntegerList(String input) {
        input = input.trim();
        if(input.startsWith(",") || input.endsWith(",")) {
            return true;
        }

        String[] splitByComma = input.split(",");
        for (String piece : splitByComma) {
            piece = piece.trim();
            if(isNotInt(piece)) {
                return true;
            }
        }
        return false;
    }
}
