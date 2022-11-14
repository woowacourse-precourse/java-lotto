package lotto.domain;

import lotto.util.Input;
import lotto.message.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CreateLottoList {
    private Lotto lotto;
    List<Integer> winningList;
    private int bonusNumber;

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

    // 보너스 문자 입력하는 기능
    public void bonusNumberInput() throws IllegalArgumentException{
        String input = Input.input();
        validEmpty(input);
        validNumber(input);
        validRange(input);
        setBonusNumber(input);
    }

    // 보너스 번호가 범위 내에 있는지 검증하는 기능
    private void validRange(String bonus) throws IllegalArgumentException{
        int number = Integer.parseInt(bonus);
        if (!(number > 0 && number < 46)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    // 보너스 숫자 중복 검증하는 기능
    private void setBonusNumber(String input) throws IllegalArgumentException{
        HashSet<Integer> hashSet = new HashSet<>(lotto.getNumbers());
        int bonus = Integer.parseInt(input);
        if(!(hashSet.add(bonus))){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OVERLAP_ERROR_MESSAGE);
        }
        this.bonusNumber = bonus;
    }

    // 당첨 번호 리스트 get
    public List<Integer> getWinningLottoList() {
        return winningList;
    }

    // 보너스 번호 get
    public int getBonusNumber() {
        bonusNumberInput();
        return bonusNumber;
    }

}
