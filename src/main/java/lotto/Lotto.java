package lotto;



import java.util.List;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;


public class Lotto {
    private final List<Integer> numbers;
    
    public static int input()
    {   
        Scanner sc = new Scanner(System.in);
        System.out.println("로또 구입금액을 입력하시오.");
        int money=sc.nextInt();
        return money;
    }
    
    // public Lotto(List<Integer> numbers) {
    //     validate(numbers);
    //     this.numbers = numbers;
    // }

    // private void validate(List<Integer> numbers) {
    //     if (numbers.size() != 6) {
    //         throw new IllegalArgumentException();
    //     }
    // }

    // TODO: 추가 기능 구현
}
