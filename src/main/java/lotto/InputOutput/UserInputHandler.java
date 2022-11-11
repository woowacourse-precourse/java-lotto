package lotto.InputOutput;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserInputHandler {

    static final int moneyOfOneTicket = 1000;

    public int getHowMuchTickets(){

        try{
            int money = Integer.parseInt(Console.readLine());
            validateMoney(money);
            return money / moneyOfOneTicket;
        }catch(NumberFormatException ex){
            System.out.println("[ERROR] 구입 금액에는 정수만 입력할 수 있습니다.");
            throw new NoSuchElementException();
        }
    }

    public Lotto getWinningNumbers(){
        String usersInput = Console.readLine();
        List<Integer> processedInput = convertToLottoNumbers(usersInput);
        return new Lotto(processedInput);
    }

    public int getBonusNumbers(Lotto winningNumbers){
        String userInput = Console.readLine();
        return validateBonusNumbers(winningNumbers,userInput);
    }

    private List<Integer> convertToLottoNumbers(String input){
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] lottoNumbersBeforeValidate = input.split(",");

        for (String beforeValidateInput : lottoNumbersBeforeValidate) {
            lottoNumbers.add(validateLottoNumbers(beforeValidateInput));
        }
        return lottoNumbers;
    }

    private void validateMoney(int money){
        if(money <= 0){
            System.out.println("[ERROR] 지불하는 돈은 양수여야 합니다.");
            throw new IllegalArgumentException();
        }
        if(money % moneyOfOneTicket != 0){
            System.out.println("[ERROR] 로또는 1,000원 단위로 구입할 수 있습니다.\n");
            throw new IllegalArgumentException();
        }
    }

    private int validateLottoNumbers(String lottoNumberInput){
        try{
            return Integer.parseInt(lottoNumberInput);
        }catch(NumberFormatException ex){
            System.out.println("[ERROR] 콤마(,) 와 정수 이외의 다른 값을 당첨 값 입력할 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }
    private int validateBonusNumbers(Lotto winningLotto, String bonusNumberInput){
        int bonusNumber = validateLottoNumbers(bonusNumberInput);
        boolean isBonusNumberDuplicate = winningLotto.getNumbers().contains(bonusNumber);
        if(isBonusNumberDuplicate){
            System.out.println("[ERROR] 보너스 숫자는, 당첨 번호와 중복된 숫자일 수 없습니다.");
            throw new IllegalArgumentException();
        }

        return bonusNumber;
    }
}
