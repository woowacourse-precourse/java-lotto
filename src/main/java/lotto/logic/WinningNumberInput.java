package lotto.logic;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumberInput {
    private List<Integer> WinningNum;
    private int BonusNum;

    private String inputWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningnum = Console.readLine();
        return winningnum;
    }

    private List<String> dividecomma() {
        String input = inputWinningNum();
        String[] result = input.split(",");
        List<String> winnninginput = new ArrayList<>(Arrays.asList(result));
        return winnninginput;
    }

    private List<Integer> convertoInt() {
        WinningNum = new ArrayList<>();
        List<String> Stringinput = dividecomma();
        for (int i = 0; i < Stringinput.size(); i++) {
            int s = Integer.parseInt(Stringinput.get(i));
            WinningNum.add(s);
        }
        return WinningNum;
    }

    public List<Integer> getWinningNum() {
        List<Integer> winningnum = convertoInt();
        ExceptionValidation.inputException(winningnum);
        return WinningNum;
    }

    private int inputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        BonusNum = Integer.parseInt(input);
        return BonusNum;
    }

    public int getBonusNum(List<Integer> WinningNum) {
        int BonusNum = inputBonusNum();
        ExceptionValidation.bonusException(BonusNum, WinningNum);
        return BonusNum;
    }
}
