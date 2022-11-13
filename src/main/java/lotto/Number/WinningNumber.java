package lotto.Number;

import lotto.Machine.PrintMachine;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class WinningNumber {

    private final List<Integer> winningNumberList;

    public WinningNumber(){
        this.winningNumberList = inputNumber();
    }
    public List<Integer> getWinningNumberList() {
        return winningNumberList;
    }

    private List<Integer> inputNumber() {
        PrintMachine.winningNumber();
        String[] inputString = Console.readLine().split(",");

        validateInteger(inputString);
        validateOverlaped(inputString);

        return stringArrayToIntegerList(inputString);
    }

    private void validateInteger(String[] stringArray) {
        for (String string : stringArray) {
            NumValidate.validateInteger(string);
            NumValidate.validateRange(string);
        }
    }

    private void validateOverlaped(String[] stringArray) {
        List<Integer> List = stringArrayToIntegerList(stringArray);
        Set<Integer> numSet = new HashSet<>(List);

        if (numSet.size() != List.size()) {
            PrintMachine.errorMessage("중복되는 값이 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> stringArrayToIntegerList(String[] inputString) {
        List<Integer> inputList = new ArrayList<Integer>();

        for (String s : inputString) {
            inputList.add(Integer.parseInt(s));
        }
        return inputList;
    }
}
