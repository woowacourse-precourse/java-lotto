package lotto;

import java.util.ArrayList;
import java.util.List;

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
        if(splits.length!=6){
            throw new IllegalArgumentException("[ERROR]");
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            arrayList.add(Integer.parseInt(splits[i]));
        }
        for (int i = 0; i < 6; i++) {
            if(arrayList.get(i)<1||arrayList.get(i)>45){
                throw new IllegalArgumentException("[ERROR]");
            }
        }
    }

}
