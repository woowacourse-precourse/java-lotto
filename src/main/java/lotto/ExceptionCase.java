package lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExceptionCase {
    private static final int AMOUNT_UNIT = 1000;
    public int checkIfAmountInputIsInteger(String buyingAmountString){
        int buyingAmount;
        try{
            buyingAmount = Integer.parseInt(buyingAmountString);
        } catch (Exception e){
            System.out.println("[ERROR] 구입 금액은 항상 정수로만 입력해야 합니다. 다른 문자나 공백은 입력이 불가합니다.");
            throw new IllegalArgumentException();
        }
        return buyingAmount;
    }
    public int checkIf1000Unit(String buyingAmountString) {
        int buyingAmount = Integer.parseInt(buyingAmountString);
        try{
            if (buyingAmount % AMOUNT_UNIT != 0) throw new IllegalArgumentException();
        }
        catch (Exception e){
            System.out.println("[ERROR] 구입 금액은 항상 1000원 단위로 입력하셔야 합니다.");
            throw new IllegalArgumentException();
        }
        return buyingAmount;
    }
    public int checkIfNumberInRightFormat(String inputNumbers) {
        try{
            return Integer.parseInt(inputNumbers);
        }
        catch (Exception e){
            System.out.println("[ERROR] 당첨 번호는 정수만 입력이 가능하고, ',' 로 구분하셔서 입력하셔야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    public void checkNumbersSize(List<Integer> numbers) {
        final int LIMIT_OF_SIZE = 6;
        if (numbers.size() != LIMIT_OF_SIZE){
            System.out.println("[ERROR] 당첨 번호는 정확히 6개를 입력하셔야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    public void checkNumbersOverLap(List<Integer> numbers) {
        Iterator itrForNumbers = numbers.iterator();
        List<Integer> arrayForCheckOverLap = new ArrayList<>();
        while (itrForNumbers.hasNext()){
            int checkNumber = (int)itrForNumbers.next();
            if (arrayForCheckOverLap.contains(checkNumber)){
                System.out.println("[ERROR] 당첨 번호는 중복이 없어야 합니다.");
                throw new IllegalArgumentException();
            }
            arrayForCheckOverLap.add(checkNumber);
        }
    }
    public void checkNumbersRange(List<Integer> numbers) {
        Iterator itrForNumbers = numbers.iterator();
        while (itrForNumbers.hasNext()){
            int number = (int)itrForNumbers.next();
            if (number < 1 || number > 45){
                System.out.println("[ERROR] 당첨 번호의 각 숫자 범위는 1 - 45 입니다.");
                throw new IllegalArgumentException();
            }
        }
    }
    public void validationForNumber(List<Integer> numbers, Integer inputBonusNumber) {
        if (numbers.contains(inputBonusNumber)){
            System.out.println("[ERROR] 당첨 번호는 중복이 없어야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    public void validationOfInput(String inputBonusNumberString) {
        try{
            Integer.parseInt(inputBonusNumberString);
        }
        catch (Exception e){
            System.out.println("[ERROR] 보너스 번호는 숫자 하나면 입력 받을 수 있습니다. 공백이나 다른 문자는 입력이 불가합니다.");
            throw new IllegalArgumentException();
        }
    }
    public void validationForRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45){
            System.out.println("[ERROR] 당첨 번호의 각 숫자 범위는 1 - 45 입니다.");
            throw new IllegalArgumentException();
        }
    }
}
