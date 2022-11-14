package lotto.domain;

import lotto.util.Input;
import lotto.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class CreateLottoList {
    private Lotto lotto;
    List<Integer> winningList;

    public CreateLottoList() throws IllegalArgumentException{
        this.winningList = inputLotto(Input.input());
        this.lotto = new Lotto(winningList);
    }

    // 입력받은 당첨 번호 리스트 요소들을 int로 형변환하는 기능
    private List<Integer> inputLotto(String input) throws IllegalArgumentException{
        validQuote(input);
        String[] splitInput = input.split(",");
        List<Integer> tempList = new ArrayList<>();
        for (String s : splitInput) {
            validNumber(s);
            validEmpty(s);
            tempList.add(Integer.parseInt(s));
        }
        return tempList;
    }

    // 따옴표가 하나 더 붙었을 때 예외를 검증하는 기능
    private void validQuote(String input) throws IllegalArgumentException{
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_QUOTE_ERROR_MESSAGE);
        };
    }

    // 배열 내부에 값이 없는지 검증하는 기능
    private void validEmpty(String elementWord) throws IllegalArgumentException{
        if (elementWord.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_EMPTY_ERROR_MESSAGE);
        }
    }

    // 숫자 이외 문자가 포함되어 있는지 검증하는 기능
    private void validNumber(String elementWord) throws IllegalArgumentException{
        char[] charList = elementWord.toCharArray();
        for (char c : charList) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_ERROR_MESSAGE);
            }
        }
    }


    // 당첨 번호 리스트 get
    public List<Integer> getWinningLottoList() {
        return winningList;
    }


}
