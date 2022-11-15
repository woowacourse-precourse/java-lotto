package lotto.function;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class SetWinnerNumber {

    public List<Integer> winnerNumber = new ArrayList<>();
    public int bonusNumber;
    public void setWinnerNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNumber = Console.readLine();
        try{
            String[] inputList = inputNumber.split(",");
            for (String str : inputList){
                numberCheck(str);
                rangeCheck(str);
                winnerNumber.add(Integer.parseInt(str));
            }
            totalNumberCheck(winnerNumber);
            validateSameNumber(winnerNumber);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    public void setBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputNumber = Console.readLine();
        try{
            numberCheck(inputNumber);
            rangeCheck(inputNumber);
            bonusNumberCheck(inputNumber);
            bonusNumber = Integer.parseInt(inputNumber);


        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean numberCheck(String str){
        for (int i=0;i< str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 숫자만 입력이 가능합니다.");
            }
        }
        return true;
    }

    private void validateSameNumber(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호 중에서 중복된 번호가 존재합니다.");
        }
    }

    private void totalNumberCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아닙니다.");
        }
    }

    private boolean rangeCheck(String str){
        int num = Integer.parseInt(str);
        if(!(1 <= num && num <=45)){
            throw new IllegalArgumentException("[ERROR] 입력된 당첨 번호에 중복된 값이 존재합니다.");
        }
        return true;
    }

    private boolean bonusNumberCheck(String str){
        int num = Integer.parseInt(str);
        if(winnerNumber.contains(num)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호 중 하나가 중복됩니다..");
        }
        return true;
    }

    public List<Integer> getWinnerNumber(){
        return winnerNumber;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

}
