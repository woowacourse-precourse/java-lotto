package domain;

import dto.WinningNumberDto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    public static final String ERROR_INVALID_INPUT = "[ERROR] Invalid Input";
    private List<Integer> mainNumbers = new ArrayList<>();
    private Integer bonusNumber;

    public WinningNumber(List<Integer> announcedNumbers, Integer bonus) {
        checkValidity(announcedNumbers,bonus);
        mainNumbers = announcedNumbers;
        bonusNumber = bonus;
    }
    private void checkValidity(List<Integer> announcedNumbers, Integer bonus){
        if (bonus<1 || bonus > 45){
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
        for(Integer number : announcedNumbers){
            if(number<1 || number >45){
                throw new IllegalArgumentException(ERROR_INVALID_INPUT);
            }
        }

    }
    public WinningNumberDto sendDTO(){
        return new WinningNumberDto(mainNumbers,bonusNumber);
    }
}
