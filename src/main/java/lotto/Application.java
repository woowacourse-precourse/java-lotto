package lotto;

import UserInterface.InputValues;
import UserInterface.OutputValues;
import domain.Generator;
import domain.Lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        final Generator generator = new Generator();
        final InputValues inputValues = new InputValues();
        final OutputValues outputValues = new OutputValues();

        try {
            int totalPayment = inputValues.inputTotalPayment();

            List<List<Integer>> generatedLotto = generator.generateLottoNumber(totalPayment);
            outputValues.showLottoPaymentReceipt(totalPayment, generatedLotto);

            List<Integer> winningLottoNumbers = inputValues.inputLottoNumber();
            int bonusNumber = inputValues.inputBonusNumber();

            Lotto lotto = new Lotto(winningLottoNumbers);

            List<Integer> result = lotto.calculateLottoResult(generatedLotto, bonusNumber);
            String yield = lotto.calculateYield(result, totalPayment);
            outputValues.showTotalWinningResult(result, yield);

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
