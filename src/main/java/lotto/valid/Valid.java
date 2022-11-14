package lotto.valid;

import lotto.input_output.ChangeType;
import lotto.playlotto.PlayLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.input_output.ChangeType.*;

/*
1. [ERROR] `,`로 나눴을 때 6자리가 아닐 때
2. [ERROR] 중복된 값이 들어올 수 없다.
3. [ERROR] 숫자가 아닌 값 들어올 수 없다.
4. [ERROR] 1 ~ 45까지의 정수만 들어올 수 있다.
5. [ERROR] 1000원 미만 단위 입력 받을 수 없다.
6. [ERROR] 공백 문자열이 존재하면 오류 발생
-[x] Lotto 당첨번호 입력(6,1,3,4,2) 순서 작성
-[x] Lotto 보너스번호 입력(6,3,4)
-[x] User 구매금액 입력 (6, 3, 5);



 */
public class Valid {
    private static String size_Message = "[ERROR] 입력된 값이 6자리가 아닙니다. Size: ";
    private static String number_Message = "[ERROR] 입력된 값이 숫자가 아닙니다. number : ";
    private static String overlap_Message = "[ERROR] 입력된 값이 중복됩니다. number :";
    private static String range_Message = "[ERROR] 입력된 값의 범위가 벗어났습니다. : ";
    private static String under_thousand_Message = "[ERROR] 입력된 값이 1000원 미만의 단위가 포함되어 있습니다 : ";
    private static String empty_Message = "[ERROR] 값이 비어있습니다.";
    public static void check_size(String str){
        int size = string_to_stringarray(str).length;  //TODO: ChageType을 이용한 리펙토링
        if(size != 6){
            throw new IllegalArgumentException(size_Message + size);
        }
    }

    public static void check_size(List<Integer> numbers){
        if(numbers.size() != 6){
            throw new IllegalArgumentException(size_Message + numbers.size());
        }
    }

    public static void check_number(String str){
        str = str.replace(",", "");
        for(int i= 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                throw new IllegalArgumentException(number_Message +str.charAt(i));
            }
        }
    }

    public static void check_Overlap(String str){
        String[] input = string_to_stringarray(str);
        List<Integer> container = new ArrayList<>();

        for(int i = 0; i < input.length; i++){
            Integer num = string_to_int(input[i]);
            if(container.contains(num)){
                throw new IllegalArgumentException(overlap_Message + input[i]);
            }
            container.add(num);
        }
    }

    public static void check_Overlap(List<Integer> numbers){
        List<Integer> lottery = new ArrayList<>(numbers);
        for(int i = 0; i < lottery.size(); i++){
            Integer number = lottery.remove(i);
            if(lottery.contains(number)){
                throw new IllegalArgumentException(overlap_Message + number);
            }
        }
    }
    public static void check_Overlap(List<Integer> numbers, String str){
        List<Integer> lottery = new ArrayList<>(numbers);
        lottery.add(Integer.valueOf(str));
        for(int i = 0; i < lottery.size(); i++){
            Integer number = lottery.remove(i);
            if(lottery.contains(number)){
                throw new IllegalArgumentException(overlap_Message + number);
            }
        }
    }

    public static void check_Range(String str) {
        String[] input = string_to_stringarray(str);
        for(int i = 0; i < input.length; i++){
            Integer num = Integer.valueOf(input[i]);
            if(num > 45 || num < 1){
                throw new IllegalArgumentException(range_Message + num);
            }
        }
    }

    public static void check_Range(List<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++){
            int num = numbers.get(i);
            if(num > 45 || num < 1){
                throw new IllegalArgumentException(range_Message + num);
            }
        }
    }

    public static void check_under_thousand(String str) {
        Integer num = string_to_int(str);
        if(num % 1000 != 0){
            throw new IllegalArgumentException(under_thousand_Message + num);
        }
    }

    public static void check_empty(String str) {
        String [] input = string_to_stringarray(str);
        for(int i = 0; i < input.length; i++){
            if(input[i].isEmpty()){
                throw new IllegalArgumentException(empty_Message);
            }
        }
    }



}
