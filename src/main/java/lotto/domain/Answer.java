package lotto.domain;

import java.util.ArrayList;

public class Answer {
    private ArrayList<Integer> answer;
    private int bonus;

    public boolean validate(String answerInput) {
        String[] strings = answerInput.split(",");
        ArrayList<Integer> answer;
        if (!validateLength(strings)) {
            return false;
        }
        for (String str : strings) {
            if (!validDigit(str)) {
                return false;
            }
        }
        answer = stringToList(strings);
        if (!validateInRange(answer) || !validateNonSame(answer)) {
            return false;
        }
        return true;
    }

    public void createAnswer(String answerInput) {
        String[] strings = answerInput.split(",");

        this.answer = stringToList(strings);
    }

    private boolean validateLength(String[] strings) {
        try {
            if (strings.length != 6) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 정답은 6개여야 합니다.");
            return false;
        }
        return true;
    }

    private boolean validDigit(String str) {
        char c;

        if (!validateNull(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (!validateIsDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateNull(String str) {
        try {
            if (str.equals("") || str == null) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 널이면 안됩니다.");
            return false;
        }
        return true;
    }

    private boolean validateIsDigit(char c) {
        try {
            if (!Character.isDigit(c)) {
                throw (new IllegalArgumentException());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자여야 합니다.");
            return false;
        }
        return true;
    }

    private ArrayList<Integer> stringToList(String[] strings) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (String str : strings) {
            answer.add(Integer.parseInt(str));
        }

        return answer;
    }

    private boolean validateInRange(ArrayList<Integer> answer) {
        for (int number : answer) {
            if(!validateElementInRange(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateElementInRange(int number) {
        try {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 수는 1부터 45까지 입니다.");
            return false;
        }
        return true;
    }


    public void createBonus(String bonusInput) {
        int number;

        number = Integer.parseInt(bonusInput);
        this.bonus = number;
    }

    public boolean validateBonus(String bonusInput) {
        int number;

        if (!validateNull(bonusInput)) {
            return false;
        }
        if (!validDigit(bonusInput)) {
            return false;
        }
        number = Integer.parseInt(bonusInput);
        if (!validateElementInRange(number) || !(validateNotAnswer(number))) {
            return false;
        }
        return true;
    }

    private boolean validateNotAnswer(int bonus) {
        try {
            if (answer.contains(bonus)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스는 정답에 있으면 안됩니다.");
            return false;
        }
        return true;
    }

    private boolean validateNonSame(ArrayList<Integer> answer) {
        for (int number : answer) {
            if (!validateIndexStartIsEnd(answer, number)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateIndexStartIsEnd(ArrayList<Integer> answer, int number) {
        try {
            if (answer.indexOf(number) != answer.lastIndexOf(number)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 정답에 같은 숫자가 있으면 안됩니다.");
            return false;
        }
        return true;
    }

    public ArrayList<Integer> getAnswer() {
        return answer;
    }

    public int getBonus() {
        return bonus;
    }
}
