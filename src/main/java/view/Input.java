package view;

import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Input {
    private int number;

    private final List<Integer> answer;

    private int bonus;

    private final static int unitPrice = 1000;

    public Input() {
        number = 0;
        answer = new ArrayList<>();
        bonus = 0;
    }

    public int getNumber() {
        return this.number;
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }

    public int getBonus() {
        return this.bonus;
    }

    public String enterPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void validatePrice(String price) {
        if (Valid.isNotNumber(price)) {
            throw new IllegalArgumentException(ValidMessage.ValidPriceNotNumber.getPrintMessage());
        }
        if (Valid.isEnterValid(price)) {
            throw new IllegalArgumentException(ValidMessage.ValidPriceNotMultiple.getPrintMessage());
        }
    }

    public void savePrice(String price) {
        validatePrice(price);
        int priceNum = Integer.parseInt(price);
        number = priceNum / unitPrice;
    }

    public String[] enterAnswer() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().split(",");
    }

    public void validateAnswer(String[] enterAnswer) {
        if(Valid.checkValidAnswer(enterAnswer)) {
            throw new IllegalArgumentException(ValidMessage.ValidEnterAnswer.getPrintMessage());
        }
    }

    public void saveAnswer(String[] enterAnswer) {
        validateAnswer(enterAnswer);
        int[] answerNumber= Arrays.stream(enterAnswer).mapToInt(Integer::parseInt).toArray();
        for (int i : answerNumber) {
                answer.add(i);
        }
    }

    public String enterBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void validateBonus(String bonusNum, String[] answer) {
        if(Valid.checkValidBonus(bonusNum, answer)) {
            throw new IllegalArgumentException(ValidMessage.ValidBonusAnswer.getPrintMessage());
        }
    }

    public void saveBonus(String bonusNum, String[] answer) {
        validateBonus(bonusNum, answer);
        bonus = Integer.parseInt(bonusNum);
    }
}

