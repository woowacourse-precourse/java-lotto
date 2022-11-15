package utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ConsoleUserInput {
    // 입력부 제외 유효성 체크 완전히 빼서 lotto 내 메서드로 구현

    public String inputMoneyForLottos(){
        String moneyForLottos = Console.readLine();
        return moneyForLottos;
    }

    public String inputWinningNumbers(){
        String userInput = Console.readLine();
        return userInput;
    }

    public String inputBonusNumber(){
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }







}
