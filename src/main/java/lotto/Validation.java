package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validation {
   public static void numberCountValidation(List<Integer> numbers){
       if(numbers.size() != 6) throw new IllegalArgumentException("[ERROR] 로또 번호는 6개입니다.");
   }
}