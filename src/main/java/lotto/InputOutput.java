package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.*;

class InputOutput {
    private int money = 0;
    private int bonusNumber = 0;
    private final ArrayList<Integer> userInputNumber = new ArrayList<>();



    public void setMoney() {
        System.out.println(Constants.INFO_MONEY);
        try {
            int number = Integer.valueOf(Console.readLine());
            validate(number);
            money = number;
        }catch (IllegalArgumentException e){
            System.out.println(Constants.ERROR_CHAR);
        }

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
            if (array.length != Constants.TIMES)
                throw new IllegalArgumentException();
            } catch(IllegalArgumentException e){
                System.out.println(Constants.ERROR_LENGTH);
            }
        }


    void validateRange(int number){
        try{
            if(Constants.START_NUMBER > number || Constants.END_NUMBER < number)
                throw new IllegalArgumentException();
        }catch(IllegalArgumentException e){
            System.out.println(Constants.ERROR_RANGE);
        }
    }

    int printResult(int [] matchTable){
        System.out.println(Constants.INFO_STATICS_TITLE);
        System.out.println(Constants.INFO_LINE);
        int totalPrice=0;
        for(int i=1;i< matchTable.length;i++){
            totalPrice = checkMatchCount(matchTable,i,totalPrice);

        }
        return totalPrice;
    }

    int checkMatchCount(int [] matchTable,int index,int totalPrice){
        if(index == 3) {
            System.out.printf(Constants.INFO_MATCH_THREE + matchTable[index] + "개\n");
            totalPrice+=Constants.REWORD_THREE*matchTable[index];
        }
        if(index == 4) {
            System.out.printf(Constants.INFO_MATCH_FOUR+matchTable[index]+"개\n");
            totalPrice+=Constants.REWORD_FOUR*matchTable[index];

        }
        if(index == 5) {
            System.out.printf(Constants.INFO_MATCH_FIVE+matchTable[index]+"개\n");
            totalPrice+=Constants.REWORD_FIVE*matchTable[index];

        }
        if(index == 6) {
            System.out.printf(Constants.INFO_MATCH_SIX+matchTable[index]+"개\n");
            totalPrice+=Constants.REWORD_SIX*matchTable[index];

        }
        if(index == 7) {
            System.out.printf(Constants.INFO_MATCH_BONUS+matchTable[index]+"개\n");
            totalPrice+=Constants.REWORD_BONUS*matchTable[index];
        }
        return totalPrice;
    }
}
