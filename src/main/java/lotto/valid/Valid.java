package lotto.valid;

/*
1. [ERROR] `,`와 숫자가 아닌 값
2. [ERROR] `,`로 나눴을 때 6자리가 아닐 때
3. [ERROR] 중복된 값이 들어올 수 없다.
4. [ERROR] 숫자가 아닌 값 들어올 수 없다.
5. [ERROR] 1 ~ 45까지의 정수만 들어올 수 있다.
6. [ERROR] 1000원 미만 단위 입력 받을 수 없다.
-[ ] Lotto 당첨번호 입력(1,2,3,4,5)
-[ ] Lotto 보너스번호 입력(3,4,5)
 */
public class Valid {

    public static void check_number(String str){
        str = str.replace(",", "");
        for(int i= 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                throw new IllegalArgumentException(number_Message +str.charAt(i));
            }
        }
    }

    public static void check_Overlap(String str){
        String[] input = str.split(",");
        List<Integer> container = new ArrayList<>();

        for(int i = 0; i < input.length; i++){
            Integer num = Integer.valueOf(input[i]);
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
        String[] input = str.split(",");
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
        Integer num = Integer.valueOf(str);
        if(num % 1000 != 0){
            throw new IllegalArgumentException(under_thousand_Message + num);
        }
    }

    public static void check_empty(String str) {
        String [] input = str.split(",");
        for(int i = 0; i < input.length; i++){
            if(input[i].isEmpty()){
                throw new IllegalArgumentException(empty_Message);
            }
        }
    }



}
