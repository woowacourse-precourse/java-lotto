package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine extends Lotto{

    private int bonusNumber;

    public LottoMachine(List<Integer> numbers) {
        super(numbers);
    }

    public static List<Integer> convertStringToNumber(String numbers) {
        List<Integer> convertNumbers = new ArrayList<>();

        for (String number : numbers.split(",")) {
            convertNumbers.add(Integer.parseInt(number));
        }

        return convertNumbers;
    }

    public static LottoMachine initLottoMachineNumber(String numbers) {
        return new LottoMachine(convertStringToNumber(numbers));
    }

    public void addBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
