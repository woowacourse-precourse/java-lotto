package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers; // 기존 코드

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Lotto(List<Integer> numbers) throws IOException { // 생성자, 기존 코드
        validate(numbers);
        this.numbers = numbers;
    }

    // 로또 구입 금액
    public static int inputMoney() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = Integer.parseInt(br.readLine());
        if(inputMoney % 1000 != 0){
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위입니다.");
        }
        return inputMoney;
    }

    // 로또 개수
    public static int theNumberOfLotto() throws IOException {
        int inputMoney = inputMoney() / 1000;
        return inputMoney;
    }

    public static ArrayList<Integer> myLottoNumber(int num) throws IOException {
        num = theNumberOfLotto();

        Collections.sort(myLottoNumber(num)); // 로또 번호 정렬
        return null;
    }

    // 예외사항
    private void validate(List<Integer> numbers) throws IOException { // 예외사항 기존 코드
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 여섯자리여야 합니다.");
        }

        if (inputMoney() % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위입니다."); // 추후에 삭제 예정
        }

//        if(Lotto 중복) {
//            throw new IllegalArgumentException("로또는 서로 다른 여섯자리 숫자로 구입해야 합니다.");
//        }
    }

}
