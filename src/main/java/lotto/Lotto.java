package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers; // 기존 코드

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Lotto(List<Integer> numbers) { // 생성자, 기존 코드
        validate(numbers);
        this.numbers = numbers;
    }

    public int inputMoney() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = Integer.parseInt(br.readLine());
        return inputMoney;
    }

    private void validate(List<Integer> numbers) throws IOException { // 예외사항 기존 코드
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 숫자는 여섯자리여야 합니다.");
        }

        if (inputMoney() % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위입니다.");
        }

//        if(Lotto 중복) {
//            throw new IllegalArgumentException("로또는 서로 다른 여섯자리 숫자로 구입해야 합니다.");
//        }
    }

    // TODO: 추가 기능 구현
}
