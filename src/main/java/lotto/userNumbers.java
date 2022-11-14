package lotto;

import java.util.ArrayList;
import java.util.List;

/*
설명 -  사용자가 입력한 번호 객체
getNumbers() - 사용자 번호 return
addBonusNumber() -  보너스 번호 추가
 */
public class userNumbers {
    ArrayList<Integer> numbers;

    public userNumbers(String userInput) {
        errorCheck(userInput);
        this.numbers = stringToNumbers(userInput);
    }

    private ArrayList<Integer> stringToNumbers(String userInput) {
        String[] splits = userInput.split(",");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            arrayList.add(Integer.parseInt(splits[i]));
        }
        return arrayList;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    private void errorCheck(String userInput) {
        String[] splits = userInput.split(",");
        if (splits.length != 6) {
            throw new IllegalArgumentException("[ERROR]");
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            arrayList.add(Integer.parseInt(splits[i]));
        }
        for (int i = 0; i < 6; i++) {
            if (arrayList.get(i) < 1 || arrayList.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }

    public void addBonusNumber(int bonusNumber) {
        errorCheckBonusNumber(bonusNumber);
        this.numbers.add(bonusNumber);
    }

    private void errorCheckBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
