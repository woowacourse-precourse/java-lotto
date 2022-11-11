package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    View view = new View();
    Domain domain = new Domain();
    Lotto lotto;
    Exception ex = new Exception();
    int inMoney;
    int bonus;
    int[] list = new int[8];
    long result;
    String input;
    String[] str;
    List<Integer> lottoList = new ArrayList<>();

    void start() {
        try {
            inputStart();
            inputStartException();
            inMoney();
            Computer[] computers = getComputers();
            inputWinningNumber();
            inputWinningNumberException();
            inputBonus();
            inputBonusException();
            inBonus();
            checkWinning(computers);
            calculateResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void calculateResult() {
        result = domain.checkWinningMoney(list);
        view.printBenfit(inMoney, result);
    }

    private void checkWinning(Computer[] computers) {
        domain.checkWinning(computers, list, lotto);
        view.printResult(list);
    }

    private void inBonus() {
        bonus = Integer.parseInt(input);
        lotto.getNumbers().add(bonus);
    }

    private void inMoney() {
        inMoney = Integer.parseInt(input);
    }

    private void getInput() {
        input = Console.readLine();
    }

    public void inputBonusException() throws IllegalArgumentException {
        ex.inputWinningBonus(input);
    }

    private void inputBonus() {
        view.inputBonus();
        getInput();
    }

    public void inputStartException() throws IllegalArgumentException {
        ex.initialInput(input);
    }

    private void inputStart() {
        view.startMention();
        getInput();
    }

    private Computer[] getComputers() {
        Computer[] computers = new Computer[inMoney / 1000];
        for (int i = 0; i < inMoney / 1000; i++) computers[i] = new Computer();
        view.purchaseNumber(inMoney / 1000, computers);
        System.out.println();
        return computers;
    }


    public void inputWinningNumberException() throws IllegalArgumentException {
        str = input.split(",");
        addWinningNum();
        lotto = new Lotto(lottoList);
        System.out.println();
    }

    private void inputWinningNumber() {
        view.inputNumber();
        getInput();
    }

    private void addWinningNum() throws IllegalArgumentException {
        for (String s : str) {
            try {
                lottoList.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 공백없이 숫자와 ,를 입력해주세요.");
            }
        }
    }
}
