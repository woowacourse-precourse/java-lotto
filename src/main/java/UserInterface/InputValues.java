package UserInterface;

import Utils.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputValues {

    private final Validator validator;

    public InputValues(Validator validator) {
        this.validator = validator;
    }

    public int inputTotalPayment() {
        String payment = Console.readLine();
        validator.validatePayment(payment);
        return Integer.parseInt(payment);
    }

    public int inputBonusNumber() {
        String bonus = Console.readLine();
        validator.checkIfTheInputIsInteger(bonus);
        return Integer.parseInt(bonus);
    }

    public List<Integer> inputLottoNumber(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        List<Integer> winningLottoNumber = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String currentDigit = st.nextToken();

            validator.checkIfTheInputIsInteger(currentDigit);

            winningLottoNumber.add(Integer.parseInt(currentDigit));

        }

        return winningLottoNumber;
    }
}
