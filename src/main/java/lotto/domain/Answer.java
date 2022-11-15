package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private ArrayList<Integer> answer;
    private int bonus;

    public Answer(String answerInput) {
        this.answer = createAnswer(answerInput);
    }

    private ArrayList<Integer> createAnswer(String answerInput) {
        String[] strings = answerInput.split(",");
        ArrayList<Integer> answer;

        validateLength(strings);
        for (String str : strings) {
            validDigit(str);
        }
        answer = stringToList(strings);
        validateInRange(answer);
        validateNonSame(answer);

        return answer;
    }

    private void validateLength(String[] strings) {
        if (strings.length != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validDigit(String str) {
        char c;

        if (str == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (!Character.isDigit(c)) {
                throw (new IllegalArgumentException("[ERROR]오류"));
            }
        }
    }

    private ArrayList<Integer> stringToList(String[] strings) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (String str : strings) {
            answer.add(Integer.parseInt(str));
        }

        return answer;
    }

    private void validateInRange(ArrayList<Integer> answer) {
        for (int number : answer) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }


    public void createBonus(String bonusInput) {
        int number;

        validDigit(bonusInput);
        number = Integer.parseInt(bonusInput);
        validateInRange(number);
        validateNotAnswer(number);
        this.bonus = number;
    }


    private void validateInRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotAnswer(int bonus) {
        if (answer.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNonSame(ArrayList<Integer> answer) {
        for (int number : answer) {
            if (answer.indexOf(number) != answer.lastIndexOf(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public ArrayList<Integer> getAnswer() {
        return answer;
    }

    public int getBonus() {
        return bonus;
    }
}
