package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.InputWinningNumbersHandler;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class InputWinningNumbers {
    InputWinningNumbersHandler inputWinningNumbersHandler = new InputWinningNumbersHandler();

    public List<Integer> inputWinningNumber() {
        Output output = new Output();

        List<Integer> sixWinningNumbers;
        output.winningLottoNumbersOrder();
        sixWinningNumbers = sixLottoNumbers(userReadLine());

        return sixWinningNumbers;
    }

    private List<Integer> sixLottoNumbers(String[] userLottoNumbers){
        return inputWinningNumbersHandler.checkException(sendDataToList(userLottoNumbers));
    }

    private String[] userReadLine() {
        String userLottoNumbers = Console.readLine();
        inputWinningNumbersHandler.checkExist(userLottoNumbers);
        return userLottoNumbers.split(",");
    }

    private List<Integer> sendDataToList(String[] userLottoNumbers) {
        List<Integer> LottoList = new ArrayList<>();
        inputWinningNumbersHandler.checkIsNumber(userLottoNumbers);
        for(int i = 0; i < userLottoNumbers.length ; i++){
            LottoList.add(Integer.valueOf(userLottoNumbers[i]));
        }

        return LottoList;
    }
}