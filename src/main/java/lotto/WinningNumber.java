//package lotto;
//
//import camp.nextstep.edu.missionutils.Console;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//
//public class WinningNumber {
//
//    private final String input;
//    public static List<Integer> numbers = new ArrayList<>();
//    private static String[] inputs ;
//
//
//    public WinningNumber(String input){
//        this.input = input;
//        makeNumbers(input);
//    }
//
//
//    public void makeNumbers(String input) {
//        inputs = input.split(",");
//        checkLength();
//        for(int i=0; i<6; i++){
//            String s = inputs[i];
//            int num = Integer.parseInt(s);
//            numbers.add(num);
//        }
//        checkDuplicatedNumber(numbers);
//    }
//
//    public void checkLength() {
//        if(inputs.length!=6){
//            new Exceptions("길이가 6이어야 한다");
//        }
//
//    }
//
//    public void checkDuplicatedNumber(List<Integer> numbers) {
//        Set<Integer> numSet = new HashSet<>(numbers);
//        if(numbers.size() != numSet.size()){
//            new Exceptions("중복된 숫자가 없어야 한다");
//        }
//    }
//
//    public List<Integer> showWinningNumbers(){
//        return numbers;
//    }
//
//
//
//}
