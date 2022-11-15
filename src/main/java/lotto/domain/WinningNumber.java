package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    List<Integer> winNumber;
    int bonusNumber;
    public WinningNumber(String winInput, int bonusNumber) {
        winNumber = new ArrayList<>();
        splitInput(winInput);
        this.bonusNumber = bonusNumber;
        try {
            checkWinNumberSize(winNumber);
            checkDuplicateNumber(winNumber);
            checkNumbersRange(winNumber);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    private void splitInput(String winInput) {
        if (winInput != null) {
            String[] ArrayStr = winInput.split(",");

            for (String s : ArrayStr) {
                winNumber.add(Integer.parseInt(s));
            }
        }
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void checkDuplicateNumber(List<Integer> winNumbers) throws IllegalAccessException {
        List<Integer> tempWinNumber = new ArrayList<>(winNumbers);
        tempWinNumber.add(bonusNumber);
        Set<Integer> numSet = new HashSet<>(tempWinNumber);

        if (numSet.size() != tempWinNumber.size()) {
            System.err.println("[ERROR] 중복된 요소가 있습니다!");
            throw new IllegalArgumentException("[ERROR]: Duplicate!");
        }
    }

    private void checkWinNumberSize(List<Integer> winNumbers) throws IllegalAccessException {
        if (winNumbers.size() != 6) {
            System.err.println("[ERROR] 로또번호의 숫자는 6개입니다!");
            throw new IllegalArgumentException("[ERROR]: NOT CORRECT SIZE!");
        }
    }

    private void checkNumbersRange(List<Integer> winNumbers) throws IllegalAccessException {
        for (Integer number: winNumbers) {
            if (!checkCorrectNumber(number)){
                System.err.println("[ERROR] 당첨번호가 유효한 숫자가 아닙니다");
                throw new IllegalArgumentException("[ERROR]: NOT CORRECT WINNING NUMBER!");
            }
        }
        if (!checkCorrectNumber(bonusNumber)) {
            System.err.println("[ERROR] 보너스 번호가 유효한 숫자가 아닙니다");
            throw new IllegalArgumentException("[ERROR]: NOT CORRECT BONUS NUMBER!");
        }
    }

    private Boolean checkCorrectNumber(int number) {
        return number >= 1 && number <= 45;
    }
}