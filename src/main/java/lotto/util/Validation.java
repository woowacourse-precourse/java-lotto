package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import lotto.domain.Lotto;

public class Validation {
    public static int validateStringNumber(String lottoNumber) {
//        if(!isNumber(lottoNumber)){
//           // System.out.println("[ERROR] 숫자가 아닌 값은 로또번호로 입력할 수 없습니다.");
//            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값은 로또번호로 입력할 수 없습니다.");
//        }
        try {
            return Integer.parseInt(lottoNumber);
        }catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값은 로또번호로 입력할 수 없습니다.");
        }
    }

    private static boolean isNumber(String lottoNumber){
        return Pattern.compile("(^[0-9]*$)").matcher(lottoNumber).find();
    }
    public static void validateLottoNumber(int number) {
        if(!checkRange(number)) {
            System.out.println("로또 번호는 1 ~ 45 사이의 번호여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static  boolean checkRange(int number) {
        return number >= 1 && number <= 45;
    }

    public static  void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("중복없는 번호 6개와 보너스 번호 1개로 구성되어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            System.out.println( "[ERROR] 중복없는 번호 6개와 보너스 번호 1개로 구성되어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicates(Lotto lotteryNumbers, int bonusNumber) {
        if (lotteryNumbers.contains(bonusNumber)) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호와 겹치지 않는 번호여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
