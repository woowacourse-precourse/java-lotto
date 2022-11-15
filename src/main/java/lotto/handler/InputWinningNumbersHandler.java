package lotto.handler;

import lotto.service.PickRandomLottoLists;
import lotto.view.Output;

import java.util.List;

public class InputWinningNumbersHandler {
    PickRandomLottoLists pickRandomLottoLists = new PickRandomLottoLists();
    Output output = new Output();

    public List<Integer> checkException(List<Integer> winningNumbers) {
        checkSize(winningNumbers);
        checkSameNumbers(winningNumbers);
        checkInRange(winningNumbers);
        output.lineSpace();

        return winningNumbers;
    }

    public void checkExist(String inputWinningNumbers) {
        if(inputWinningNumbers.length() == 0){
            throw new IllegalArgumentException((output.ERROR_ORDER+" 아무것도 입력되지 않았습니다."));
        }
    }

    private void checkSize(List<Integer> winningNumbers) {
        if(winningNumbers.size() != pickRandomLottoLists.LIMIT_LOTTO) {
            throw new IllegalArgumentException(output.ERROR_ORDER+" 로또 번호의 개수는 6개여야 합니다.");
        }
    }

    private void checkSameNumbers(List<Integer> winningNumbers) {
        if(winningNumbers.stream().distinct().count() != pickRandomLottoLists.LIMIT_LOTTO) {
            throw new IllegalArgumentException(output.ERROR_ORDER+" 로또 번호는 같은 숫자가 중복되지 않아야 합니다.");
        }
    }

    public void checkIsNumber(String[] winningNumbers) {
        for(int index = 0; index < winningNumbers.length; index++) {
            calculateIsNumber(index, winningNumbers);
        }
    }

    private void calculateIsNumber(int index, String[] winningNumbers) {
        boolean checkNumeric = winningNumbers[index].matches("[+-]?\\d*(\\.\\d+)?");

        if(!checkNumeric){
            throw new IllegalArgumentException(output.ERROR_ORDER+" 로또 번호는 숫자로 입력되어야 합니다.");
        }
    }

    private void checkInRange(List<Integer> winningNumbers){
        for(int index = 0; index < winningNumbers.size(); index++){
            checkInRangeNumber(index, winningNumbers);
        }
    }

    private void checkInRangeNumber(int index, List<Integer> winningNumbers) {
        if(winningNumbers.get(index) < output.UNDER_LIMIT || winningNumbers.get(index) > output.UPPER_LIMIT)    {
            throw new IllegalArgumentException(output.ERROR_ORDER+" 로또 번호는 1부터 45 사이의 숫자여야 합니다.");}
    }
}