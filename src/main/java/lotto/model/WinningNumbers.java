package lotto.model;

import lotto.Enum.Error;
import lotto.Enum.Number;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final Lotto lottoNumbers;
    private final int bonusNumber;

    public WinningNumbers(String inputNumbers, String inputBonus){
        List<Integer> numbers = splitNumbers(inputNumbers);
        this.lottoNumbers = new Lotto(numbers);
        int bonus = isNumberInteger(inputBonus);
        isNumberInRange(bonus);
        this.bonusNumber = bonus;
    }

    public List<Integer> getWinningNumbers(){
        return lottoNumbers.getLottoNumbers();
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    private List<Integer> splitNumbers(String input){
        String[] splitInput = input.split(",");
        List<Integer> list = new ArrayList<>();

        for (String split : splitInput) {
            int number = isNumberInteger(split);
            isNumberInRange(number);
            list.add(number);
        }
        return list;
    }

    private Integer isNumberInteger(String split){
        try{
            return Integer.parseInt(split);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(Error.NUMBER.getMessage());
        }
    }

    private void isNumberInRange(int number){
        if((number > Number.MAX.getValue() || number < Number.MIN.getValue())){
            throw new IllegalArgumentException(Error.NUMBER.getMessage());
        }
    }
}
