package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class Controller {
    static View view = new View();
    static Domain logic = new Domain();
    static Lotto lotto;
    static String input;
    static EnumMap<Money, Integer> winningMap = new EnumMap<>(Money.class);
    static Computer[] computers;

    void start() {
        long Money;
        try {
            insertMoney();
            insertMoneyException();
            Money = restoreMoney();
            initComputers(Money);
            insertWinningNumber();
            insertWinningNumberException();
            insertBonus();
            insertBonusException();
            restoreBonus();
            findWinning();
            Result(Money);
        } catch (IllegalArgumentException e) {
            if (!Objects.equals(e.getMessage(), null)) System.out.println(e.getMessage());
        }
    }

    private void Result(long inMoney) {
        long result = logic.calWinningMoney(winningMap);
        view.printBenfit(inMoney, result);
    }

    private void findWinning() {
        logic.findWinning(computers, winningMap, lotto);
        view.printResult(winningMap);
    }

    private void restoreBonus() {
        int bonus = Integer.parseInt(input);
        lotto.getNumbers().add(bonus);
    }

    private Long restoreMoney() {
        return Long.parseLong(input);
    }

    private String getInput() {
        return Console.readLine();
    }

    public void insertBonusException() throws IllegalArgumentException {
        Exception ex = new Exception();
        ex.inputWinningBonus(input);
    }

    private void insertBonus() {
        view.inputBonus();
        input = getInput();
    }

    public void insertMoneyException() throws IllegalArgumentException {
        Exception ex = new Exception();
        ex.initialInput(input);
    }

    private void insertMoney() {
        view.startMention();
        input = getInput();
    }

    private void initComputers(long inMoney) {
        computers = new Computer[(int)inMoney / 1000];
        for (int i = 0; i < inMoney / 1000; i++) computers[i] = new Computer();
        view.purchaseNumber((int)inMoney / 1000, computers);
        System.out.println();
    }


    public void insertWinningNumberException() throws IllegalArgumentException {
        List<Integer> lottoList = new ArrayList<>();
        String[] str = input.split(",");
        addWinningNum(str, lottoList);
        lotto = new Lotto(lottoList);
        System.out.println();
    }

    private void insertWinningNumber() {
        view.inputNumber();
        input = getInput();
    }

    private void addWinningNum(String[] str, List<Integer> lottoList) throws IllegalArgumentException {
        for (String s : str) {
            try {
                lottoList.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 공백없이 숫자와 ,를 입력해주세요.");
            }
        }
    }
}
