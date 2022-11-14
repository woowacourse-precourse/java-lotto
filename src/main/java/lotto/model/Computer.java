package lotto.model;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.exception.IllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Computer {

    private static final int MINIMUM_NUMBER_IN_RANGE = 1;
    private static final int MAXIMUM_NUMBER_IN_RANGE = 45;
    private static final String BONUS_NUMBER_EXCEPTION = "[ERROR] 보너스 넘버는 1부터 45까지 로또에 존재하지 않는 숫자여야 합니다.";

    private Lotto lotto;
    private BonusNumber bonusNumber;

    public Computer(){}

    public void saveWinningTicket(String lottoNumber){
        createTicket(splitTicket(lottoNumber));
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

    public void saveBonusNumber(String bonusNumber){
        validateBonusNumber(bonusNumber);
        addBonusNumber(Integer.parseInt(bonusNumber));
    }

    private void validateBonusNumber(String bonusNumber){
        if(isNotNumber(bonusNumber) || isOutOfBound(Integer.parseInt(bonusNumber)) || isAlreadyInLotto(Integer.parseInt(bonusNumber)))
            notValidBonusNumberException();
    }

    private boolean isNotNumber(String bonusNumber){
        return !Pattern.matches("^[0-9]*$", bonusNumber);
    }

    private boolean isOutOfBound(int bonusNumber){
        return bonusNumber < MINIMUM_NUMBER_IN_RANGE || bonusNumber > MAXIMUM_NUMBER_IN_RANGE;
    }

    private boolean isAlreadyInLotto(int bonusNumber){
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void notValidBonusNumberException(){
        System.out.println(BONUS_NUMBER_EXCEPTION);
        throw new IllegalArgumentException(BONUS_NUMBER_EXCEPTION);
    }

    private void addBonusNumber(int bonusNumber){
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public int getBonusNumber(){
        return bonusNumber.getBonusNumber();
    }
}
