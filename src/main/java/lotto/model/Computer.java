package lotto.model;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private Lotto lotto;
    private BonusNumber bonusNumber;

    public Computer(){}

    public void saveWinningTicket(String lottoNumber){

    }

    public Lotto getComputerNumber(){
        return lotto;
    }

    private List<Integer> splitTicket(String input){
        return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    private void createTicket(int[] numbers){

    }

    public void saveBonusNumber(String bonusNumber){}

    private void validateBonusNumber(){

    }

    private void addBonusNumber(){

    }

    public int getBonusNumber(){
        return 1;
    }
}
