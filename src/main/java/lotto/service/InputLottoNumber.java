package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.InputLottoNumbersHandler;

import java.util.ArrayList;
import java.util.List;

public class InputLottoNumber {

    InputLottoNumbersHandler inputLottoNumbersHandler = new InputLottoNumbersHandler();
    //Todo : 리스트에 문자열 배열에 있는거 담고, 예외처리 확인해주고, 보너스 포인트 추가할 때 또 예외처리 확인
    public void inputSixNumbers() {
        sixLottoNumbers(userReadLine());
    }
    public String[] userReadLine() {
        String userLottoNumbers = Console.readLine();
        String[] userLottoNumbersArray = userLottoNumbers.split(",");

        return userLottoNumbersArray;
    }
    public List<Integer> sixLottoNumbers(String[] userLottoNumbers){
        return inputLottoNumbersHandler.checkException(sendDataToList(userLottoNumbers));
    }

    private List<Integer> sendDataToList(String[] userLottoNumbers) {
        List<Integer> LottoList = new ArrayList<>();
        for(int i = 0; i < userLottoNumbers.length ; i++){
            LottoList.add(Integer.valueOf(userLottoNumbers[i]));
        }
        return LottoList;
    }
    public void inputBonusNumber() {
    }
}