package lotto;

import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.*;

class InputOutputUI {
    private int money = 0;
    private int bonusNumber = 0;
    private final ArrayList<Integer> userInputNumber = new ArrayList<>();



    public void setMoney() {
        System.out.println(Constants.INFO_MONEY);
        int number = Integer.valueOf(Console.readLine());
        validate(number);
        money = number;
    }

    public int getMoney() {
        return money / Constants.DIV_MONEY;
    }

    public void setUserInputNumber() {
        System.out.println(Constants.INFO_INPUT_NUMBER);
        String[] tmp = Console.readLine().split(",");
        validateLength(tmp);

        for (int i = 0; i < tmp.length; i++) {
            validateRange(Integer.valueOf(tmp[i]));
            userInputNumber.add(Integer.valueOf(tmp[i]));
        }

        List<Integer> duplicateCheck = userInputNumber.stream().distinct().collect(Collectors.toList());
        try {
            if (duplicateCheck.size() != userInputNumber.size()) {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.out.println(Constants.ERROR_DUPLICATE);
        }
    }

    public ArrayList<Integer> getUserInputNumber() {
        return userInputNumber;
    }

    public void setBonusNumber(){
        System.out.println(Constants.INFO_BONUS);
        int number = Integer.valueOf(Console.readLine());
        validateRange(number);
        bonusNumber = number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    void validate(int number) {
        try {
            if (number % Constants.DIV_MONEY != 0)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ERROR_DIV);
        }
    }

    void validateLength(String[] array) {
        try {
            if (array.length != 6)
                throw new IllegalArgumentException();
            } catch(IllegalArgumentException e){
                System.out.println(Constants.ERROR_LENGTH);
            }
        }


    void validateRange(int number){
        try{
            if(0 > number || 46 < number)
                throw new IllegalArgumentException();
        }catch(IllegalArgumentException e){
            System.out.println(Constants.ERROR_RANGE);
        }
    }

}
