package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    List<Integer> winNumber;
    int bonusNumber;
    public WinningNumber(String winInput, int bonusNumber) {
        splitInput(winInput);
        this.bonusNumber = bonusNumber;
    }

    private void splitInput(String winInput) {
        String[] ArrayStr = winInput.split(",");

        for (String s : ArrayStr) {
            winNumber.add(Integer.valueOf(s));
        }
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private Boolean checkDuplicateNumber(List<Integer> winNumbers) throws IllegalAccessException {
        List<Integer> tempWinNumber = new ArrayList<>(winNumbers);
        tempWinNumber.add(bonusNumber);
        Set<Integer> numSet = new HashSet<>(tempWinNumber);

        if (numSet.size() != tempWinNumber.size()) {
            System.out.println("중복된 요소가 있습니다!");
            throw new IllegalAccessException("[ERROR]: Duplicate!");
        }
        return true;
    }

    private Boolean checkWinNumberSize(List<Integer> winNumber) throws IllegalAccessException {
        if (winNumber.size() != 6) {
            System.out.println("당첨번호 숫자는 6개입니다!");
            throw new IllegalAccessException("[ERROR]: NOT CORRECT SIZE!");
        }
        return true;
    }

    private Boolean checkNumbersRange(List<Integer> winNumbers) throws IllegalAccessException {
        for (Integer winNumber: winNumbers) {
            if (!checkCorrectNumber(winNumber)){
                throw new IllegalAccessException("[ERROR]: NOT CORRECT WINNING NUMBER!");
            }
        }
        if (!checkCorrectNumber(bonusNumber)) {
            throw new IllegalAccessException("[ERROR]: NOT CORRECT BONUS NUMBER!");
        }
        return true;
    }

    private Boolean checkCorrectNumber(int number) {
        return number >= 1 && number <= 45;
    }
}
