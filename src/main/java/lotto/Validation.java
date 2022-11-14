package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validation {
    public static final int LOTTO_COUNT = 6;

    public static final String LOTTO_NUMBER_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String NUMBER_COUNT_MESSAGE = "[ERROR] 로또 번호는 6개입니다.";
    public static final String NUMBER_DUPLICATE_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
   public static void numberCountValidation(List<Integer> numbers){
       if(numbers.size() != LOTTO_COUNT) throw new IllegalArgumentException(NUMBER_COUNT_MESSAGE);
   }
   public static void numberRangeValidation(List<Integer> numbers){
       int numbersCount = numbers.stream()
               .filter(number->number >= 1 && number <= 45)
               .collect(Collectors.toList()).size();

       if(numbersCount != LOTTO_COUNT) throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_MESSAGE);
   }

   public static void numberDuplicateValidation(List<Integer> numbers){
       int numbersCount = numbers.stream()
               .filter(number->number >= 1 && number <= 45)
               .collect(Collectors.toSet()).size();
       if(numbersCount != LOTTO_COUNT) throw new IllegalArgumentException(NUMBER_DUPLICATE_MESSAGE);
   }
}