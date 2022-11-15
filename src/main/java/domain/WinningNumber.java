package domain;

import dto.WinningNumberDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    public static final String ERROR_INVALID_INPUT = "[ERROR] Invalid Input";
    private List<Integer> mainNumbers = new ArrayList<>();
    private Integer bonusNumber;

    public WinningNumber(List<Integer> announcedNumbers, Integer bonus) {
        try{
            checkValidity(announcedNumbers,bonus);
        } catch(IllegalArgumentException e){
            e.printStackTrace();
        }
        mainNumbers = announcedNumbers;
        bonusNumber = bonus;
    }
    private void checkValidity(List<Integer> announcedNumbers, Integer bonus){
        if (bonus<1 || bonus > 45){
            System.out.println(ERROR_INVALID_INPUT);
            throw new IllegalArgumentException();
        }
        for(Integer number : announcedNumbers){
            if(number<1 || number >45){
                System.out.println(ERROR_INVALID_INPUT);
                throw new IllegalArgumentException();
            }
        }
        if(announcedNumbers.size()>6){
            System.out.println(ERROR_INVALID_INPUT);
            throw new IllegalArgumentException();
        }
        Set<Integer> uniqueNumber = new HashSet<>(announcedNumbers);
        if(uniqueNumber.size()!=announcedNumbers.size()){
            System.out.println(ERROR_INVALID_INPUT);
            throw new IllegalArgumentException();
        }

    }
    public WinningNumberDto sendDTO(){
        return new WinningNumberDto(mainNumbers,bonusNumber);
    }
}
