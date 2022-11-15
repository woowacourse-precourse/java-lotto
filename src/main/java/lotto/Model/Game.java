package lotto.Model;

import lotto.io.Input;
import lotto.io.Output;
import lotto.io.OutputScreen;
import lotto.io.InputKeyboard;

import lotto.resources.Sentence;
import lotto.resources.ExceptionCatcher;

import java.util.List;

public class Game {

    private final Input input;
    private final Output output;

    public Game() {
        this.input = new InputKeyboard();
        this.output = new OutputScreen();
    }

    public void run() {
        try {
            controlSector();
        } catch (ExceptionCatcher e) {
            output.printOutput(e.getMessage());
        }
    }

    private void controlSector() {
        Money moneyUserTyped = generateMoney();
        output.printOutput(Money.HowManyLottosToPrint());
        LottoContainer lottoBox = createLottoContainer(moneyUserTyped);
        output.printOutput(lottoBox.toString());
        Lotto answer = generateAnswer();
        output.printOutput(" ");
        Lotto bonus = generateBonus(answer);
        output.printOutput("\n" + Sentence.WIN_STATISTICS.getValue());
        TotalResultMaker totalResultMaker = calculateResult(lottoBox, answer, bonus);
        output.printOutput(totalResultMaker.printLottoResult());
        output.printOutputComma(totalResultMaker.calculateYieldRate(Money.getLottoCntForCalculate()));
    }

    private Money generateMoney() {
        String userInput = input.getInput(Sentence.INPUT_MONEY.getValue(), output);
        if (userInput == null) {
            throw new IllegalArgumentException("[ERROR] Input is null");
        }
        return new Money(userInput.trim());
    }

    private Lotto generateAnswer() {
        String answerInputByUser = input.getInput(Sentence.INPUT_ANSWER.getValue(), output);
        return new Lotto(Answer.lottoAnswerGenerator(answerInputByUser));
    }

    private LottoContainer createLottoContainer(Money moneyUserTyped) {
        return new LottoContainer(
                SixDigitGenerator.generateLottoDigits(moneyUserTyped.getLottoCntForCalculate()));
    }

    private TotalResultMaker calculateResult(LottoContainer lottoBox, Lotto answer, Lotto bonus) {
        List<Integer> answerResult = lottoBox.getAnswerCompareResult(answer);
        List<Integer> bonusResult = lottoBox.getBonusCompareResult(bonus);
        return new TotalResultMaker(answerResult, bonusResult);
    }

    private Lotto generateBonus(Lotto answer) {
        String userBonusInput = input.getInput(Sentence.INPUT_BONUS.getValue(), output).trim();
        Bonus.inputValidity(userBonusInput, answer);
        return (new Lotto(List.of(Integer.parseInt(userBonusInput.trim()), 0, 0, 0, 0, 0)));
    }
}