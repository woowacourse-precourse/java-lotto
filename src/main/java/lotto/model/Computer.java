package lotto.model;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {

    private static final int MINIMUM_NUMBER_IN_RANGE = 1;
    private static final int MAXIMUM_NUMBER_IN_RANGE = 45;
    private static final String BONUS_NUMBER_EXCEPTION = "[ERROR] 보너스 넘버는 1부터 45까지 로또에 존재하지 않는 숫자여야 합니다.";

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

    private void createTicket(List<Integer> numbers){
        lotto = new Lotto(numbers);
    }

    public void saveBonusNumber(String bonusNumber){}

    private void validateBonusNumber(int bonusNumber){
        if(isOutOfBound(bonusNumber) || isAlreadyInLotto(bonusNumber))
            notValidBonusNumberException();
    }

    private boolean isOutOfBound(int bonusNumber){
        return bonusNumber < MINIMUM_NUMBER_IN_RANGE || bonusNumber > MAXIMUM_NUMBER_IN_RANGE;
    }

    private boolean isAlreadyInLotto(int bonusNumber){
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void notValidBonusNumberException(){
        throw new IllegalArgumentException(BONUS_NUMBER_EXCEPTION);
    }

    private void addBonusNumber(){

    }

    public int getBonusNumber(){
        return 1;
    }
}
