package lotto.validator;

import lotto.Lotto;
import lotto.repository.LottoRepository;
import lotto.status.BoundaryStatus;
import lotto.status.ExceptionStatus;
import lotto.status.NumberStatus;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public static void checkUserInputMoney(String userInputMoney) {
        if(checkZeroInHead(userInputMoney)){
            System.out.println(ExceptionStatus.ZERO_IN_HEAD.getText());
            throw new IllegalArgumentException(ExceptionStatus.ZERO_IN_HEAD.getText());
        }
        if (checkOnlyNumber(userInputMoney)) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException(ExceptionStatus.ZERO_IN_HEAD.getText());
        }
        if (checkDivide(userInputMoney)) {
            System.out.println(ExceptionStatus.NOT_DIVIDE_BASE_PRICE.getText());
            throw new IllegalArgumentException(ExceptionStatus.NOT_DIVIDE_BASE_PRICE.getText());
        }
    }

    private static boolean checkZeroInHead(String userInputMoney) {
        if (userInputMoney.charAt(BoundaryStatus.ZERO.getNumber()) =='0'){
            return true;
        }
        return false;
    }

    private static boolean checkOnlyNumber(String userInputMoney) {
        char[] inputMoneyPiece = userInputMoney.toCharArray();
        for (int i = 0; i < userInputMoney.length(); i++) {
            if (inputMoneyPiece[i] < BoundaryStatus.ZERO_ASCII.getNumber() ||
                    inputMoneyPiece[i] > BoundaryStatus.NINE_ASCII.getNumber()) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDivide(String userInputMoney) {
        if(Integer.parseInt(userInputMoney)% NumberStatus.BASE_PRICE_OF_LOTTO.getNumber() != BoundaryStatus.ZERO.getNumber()){
            return true;
        }
        return false;
    }

    public static void checkWinningNumber(String winningNumber) {
        List<String> checkNumber = Arrays.asList(winningNumber.split(","));
        if(checkLength(checkNumber)){
            System.out.println(ExceptionStatus.NOT_CORRECT_SHAPE.getText());
            throw new IllegalArgumentException(ExceptionStatus.NOT_CORRECT_SHAPE.getText());
        }
        if(checkOnlyNumber(checkNumber)){
            System.out.println(ExceptionStatus.CONTAIN_ONLY_NUMBER.getText());
            throw new IllegalArgumentException(ExceptionStatus.CONTAIN_ONLY_NUMBER.getText());
        }
        if(checkNumberBoundary(checkNumber)){
            System.out.println(ExceptionStatus.NOT_BOUNDARY_NUMBER.getText());
            throw new IllegalArgumentException(ExceptionStatus.NOT_BOUNDARY_NUMBER.getText());
        }
    }

    private static boolean checkNumberBoundary(List<String> checkNumber) {
        for(String checkNumberPiece : checkNumber){
            if(Integer.parseInt(checkNumberPiece) > NumberStatus.MAX_LOTTO_NUMBER.getNumber() ||
                    Integer.parseInt(checkNumberPiece) < NumberStatus.MIN_LOTTO_NUMBER.getNumber()){
                return true;
            }
        }
        return false;
    }

    private static boolean checkOnlyNumber(List<String> checkNumber) {
        try{
            for(String checkNumberPiece : checkNumber){
                Integer.parseInt(checkNumberPiece);
            }
        }catch (NumberFormatException exception){
            return true;
        }
        return false;
    }

    private static boolean checkLength(List<String> checkNumber) {
        if(checkNumber.size() != NumberStatus.TOTAL_NUMBER_OF_LOTTO.getNumber()){
            return true;
        }
        return false;
    }

    public static void checkBonusNumber(String bonusNumber) {
        if(checkIsNumber(bonusNumber)){
            System.out.println(ExceptionStatus.NOT_NUMBER.getText());
            throw new IllegalArgumentException(ExceptionStatus.NOT_NUMBER.getText());
        }
        if(checkNumberBoundary(bonusNumber)){
            System.out.println(ExceptionStatus.NOT_BOUNDARY_NUMBER.getText());
            throw new IllegalArgumentException(ExceptionStatus.NOT_BOUNDARY_NUMBER.getText());
        }
        if(checkNumberInWinningNumber(bonusNumber)){
            System.out.println(ExceptionStatus.IS_DUPLICATED.getText());
            throw new IllegalArgumentException(ExceptionStatus.IS_DUPLICATED.getText());
        }

    }

    private static boolean checkNumberInWinningNumber(String bonusNumber) {
        Lotto winningLotto = LottoRepository.getLastWinningLotto();
        if(winningLotto.getNumbers().contains(Integer.parseInt(bonusNumber))){
            return true;
        }
        return false;
    }

    private static boolean checkNumberBoundary(String bonusNumber) {
        Integer checkNumber = Integer.parseInt(bonusNumber);
        if(checkNumber < NumberStatus.MIN_LOTTO_NUMBER.getNumber() ||
                checkNumber > NumberStatus.MAX_LOTTO_NUMBER.getNumber()){
            return true;
        }
        return false;
    }

    private static boolean checkIsNumber(String bonusNumber) {
        try{
            Integer.parseInt(bonusNumber);
        }catch (NumberFormatException exception){
            return true;
        }
        return false;
    }
}
