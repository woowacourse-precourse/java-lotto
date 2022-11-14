package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validation {
   public static void numberCountValidation(List<Integer> numbers){
       if(numbers.size() != 6) throw new IllegalArgumentException("[ERROR] 로또 번호는 6개입니다.");
   }
   public static void numberRangeValidation(List<Integer> numbers){
       int numbersCount = numbers.stream()
               .filter(element->element >= 1 && element <= 45)
               .collect(Collectors.toList()).size();
   }
}