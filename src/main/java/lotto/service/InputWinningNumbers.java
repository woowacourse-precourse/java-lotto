package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.InputWinningNumbersHandler;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class InputWinningNumbers {
    InputWinningNumbersHandler inputWinningNumbersHandler = new InputWinningNumbersHandler();
    Output output = new Output();

    public List<Integer> inputWinningNumber() {
        List<Integer> sixWinningNumbers;
        output.winningLottoNumbersOrder();
        sixWinningNumbers = sixLottoNumbers(userReadLine());

        return sixWinningNumbers;
    }

    public List<Integer> sixLottoNumbers(String[] userLottoNumbers){
        return inputWinningNumbersHandler.checkException(sendDataToList(userLottoNumbers));
    }

    public String[] userReadLine() {
        String userLottoNumbers = Console.readLine();
        String[] userLottoNumbersArray = userLottoNumbers.split(",");

        return userLottoNumbersArray;
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