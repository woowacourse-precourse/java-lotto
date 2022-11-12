package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.InputLottoNumbersHandler;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class InputLottoNumber {
    InputLottoNumbersHandler inputLottoNumbersHandler = new InputLottoNumbersHandler();
    Output output = new Output();

    public List<Integer> inputSixNumbers() {
        List<Integer> resultSixLottoNumbers = new ArrayList<>();
        output.userLottoNumbersOrder();
        resultSixLottoNumbers = sixLottoNumbers(userReadLine());
        return resultSixLottoNumbers;
    }

    public List<Integer> sixLottoNumbers(String[] userLottoNumbers){
        return inputLottoNumbersHandler.checkException(sendDataToList(userLottoNumbers));
    }

    public String[] userReadLine() {
        String userLottoNumbers = Console.readLine();
        String[] userLottoNumbersArray = userLottoNumbers.split(",");

        return userLottoNumbersArray;
    }

    private List<Integer> sendDataToList(String[] userLottoNumbers) {
        List<Integer> LottoList = new ArrayList<>();
        for(int i = 0; i < userLottoNumbers.length ; i++){
            LottoList.add(Integer.valueOf(userLottoNumbers[i]));
        }
        return LottoList;
    }
}