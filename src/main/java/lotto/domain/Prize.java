package lotto.domain;

import lotto.Util.InputPrint;
import lotto.Util.OutputPrint;
import lotto.valid.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prize {
    private List<Integer> prizeNumbers;

    private int bonusNumber;

    public void inputPrizeNumbers(){
        prizeNumbers = Arrays.stream(InputPrint.prizeNumberInput().split(","))
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toList());
        Collections.sort(prizeNumbers);
        Validation.prizeNumbersValid(prizeNumbers);
    }

    public void inputBonusNumber(){
        String bonus = InputPrint.bonusNumberInput();
        Validation.bonusNumberValid(bonus);
        this.bonusNumber = Integer.parseInt(bonus);
    }

    public int match(Lotto lotto){
        List<Integer> subList = new ArrayList<>(prizeNumbers);
        subList.removeAll(lotto.getNumbers());
        int resultSize = 6 - subList.size();
        if (resultSize == 1 && matchBonusNumber(lotto.getNumbers())){
            return 7;
        }
        return resultSize;
    }

    private boolean matchBonusNumber(List<Integer> numbers){
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getPrizeNumbers() {
        return prizeNumbers;
    }

    public void setPrizeNumbers(List<Integer> prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
