package domain;

import dto.WinningNumberDto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private List<Integer> mainNumbers = new ArrayList<>();
    private Integer bonusNumber;

    public WinningNumber(List<Integer> announcedNumbers, Integer bonus) {
        mainNumbers = announcedNumbers;
        bonusNumber = bonus;
    }

    public WinningNumberDto sendDTO(){
        return new WinningNumberDto(mainNumbers,bonusNumber);
    }
}
