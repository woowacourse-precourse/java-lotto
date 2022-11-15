package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class User {
    public static final int LOTTO_LENGTH = 6;

    private int publicans;
    private List<Integer> userNumbers=new ArrayList<>();
    private int bonusNumber;

    public void getBudget() {
        try{
            System.out.println("구입금액을 입력해 주세요.");
            int budget = Integer.parseInt(Console.readLine());
            if (budget % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위입니다!");
            }
            this.publicans = budget / 1000;
        }catch (Exception e){
            System.out.println("[ERROR] 구입금액은 1000원 단위입니다!");
            throw new NoSuchElementException("[ERROR] 구입금액은 1000원 단위입니다!");
        }


    }

    public void getNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        String[] num = numbers.split(",");
        validate(num);

        for(int i= 0;i<num.length;i++){
            userNumbers.add(Integer.parseInt(num[i]));
        }

    }

    public void getBonusNumber(){
        System.out.println("\n보너스 번호를 입력해 주세요");
        String number = Console.readLine();
        isDigitValidate(number);
        rangeValidate(Integer.parseInt(number));

        this.bonusNumber=Integer.parseInt(number);

    }

    public void validate(String[] num) {
        lengthValidate(num);
        for (int i = 0; i < num.length; i++) {
            isDigitValidate(num[i]);
        }
        for (int i = 0; i < num.length; i++) {
            rangeValidate(Integer.parseInt(num[i]));
            isDuplicated(num, Integer.parseInt(num[i]),i);
        }
    }

    public void lengthValidate(String[] num) {
        if (num.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요!");
        }
    }

    public void isDuplicated(String[] num, int number,int index) {
        for (int i = 0; i < num.length; i++) {
            if(i==index){
                continue;
            }
            if (Integer.parseInt(num[i]) == number) {
                throw new IllegalArgumentException("[ERROR] 서로 다른 숫자를 입력해주세요!");
            }
        }
    }

    public void isDigitValidate(String num) {
        if (!num.matches("[-+]?\\d*\\.?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요!");
        }
    }

    public void rangeValidate(int num) {
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자를 입력해주세요!");
        }
    }

    public int getPublicans() {
        return publicans;
    }
    public int getBonus() {
        return bonusNumber;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

}
