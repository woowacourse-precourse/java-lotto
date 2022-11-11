package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Input {
    private int number;

    private List<Integer> answer;

    private int bonus;
    private Valid valid;

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

    public int enterPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        return Integer.parseInt(price);
    }

    public void returnNumber(int price) {
        if (!valid.isNotMultiple(price)) {
            number = price / unitPrice;
        }
        if (valid.isNotMultiple(price)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액을 1000으로 나누어 떨어져야 합니다.");
        }
    }

    public String[] enterAnswer() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().split(",");
    }

    public void checkValidAnswer(String[] enterAnswer) {
        if (valid.hasRepeatNumber(enterAnswer) || valid.enterNumberOverLength(enterAnswer)
            || valid.isOverRange(enterAnswer)) {
            throw new IllegalArgumentException("1-45까지의 수 중 6개의 수를 골라 입력하세요.");
        }
    }

    public void returnAnswer(String[] enterAnswer) {
        if (!valid.hasRepeatNumber(enterAnswer) && !valid.enterNumberOverLength(enterAnswer)
                && !valid.isOverRange(enterAnswer)) {
            int[] answerNumber= Arrays.stream(enterAnswer).mapToInt(Integer::parseInt).toArray();
            for (int i : answerNumber) {
                answer.add(i);
            }
        }
    }

    public String enterBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void checkValidBonus(String bonus, String[] answer) {
        if (valid.numberOverLength(bonus) || valid.isRepeatWithAnswer(bonus, answer)
        || valid.isOverRangeValue(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 정답 수 제외 1~45 수 중 하나의 숫자를 입력해 주세요.");
        }
    }
    
    public void returnBonus(String bonusNum, String[] answer) {
        if (!valid.numberOverLength(bonusNum) && !valid.isRepeatWithAnswer(bonusNum, answer)
                && !valid.isOverRangeValue(bonusNum)) {
            bonus = Integer.parseInt(bonusNum);
        }
    }
}

