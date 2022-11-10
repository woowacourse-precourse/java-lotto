package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers; // 기존 코드
    private static final int LOTTO_LENGTH = 6;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Lotto(List<Integer> numbers) throws IOException { // 생성자, 기존 코드
        validate(numbers);
        this.numbers = numbers;
    }

    // 로또 구입 금액
    public static int inputMoney() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        String nullCheck = br.readLine();
        if (nullCheck == null){
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요");
        }
        int inputMoney = Integer.parseInt(nullCheck);
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
        }
        if (inputMoney == 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력하십시오 .");
        }
        if (inputMoney > 100000) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 한도는 1000000(10만원) 입니다. .");
        }

        return inputMoney;
    }


    // 로또 개수
    public static int theNumberOfLotto() throws IOException {
        int inputMoney = inputMoney() / 1000;
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
        }
        return inputMoney;
    }

    public static ArrayList<Integer> myLottoNumber(int num) throws IOException { // 랜덤 로또 생성
        num = theNumberOfLotto();

        Collections.sort(myLottoNumber(num)); // 로또 번호 정렬
        return null;
    }

    public static List<Integer> winnerNumber() throws IOException {
        List<Integer> winnerNumber = new ArrayList<>();
        String a = br.readLine();

        String[] numberList = a.split(",");
        for (int i = 0; i < numberList.length; i = i + 2) {
            winnerNumber.add(i);
        }
        Collections.sort(winnerNumber);

        if (a.length() == 11) {
            return winnerNumber;
        }
        if (a.length() != 11) {
            throw new IllegalArgumentException("[ERROR] 로또는 여섯 자리의 수 입니다. ");
        }

        return winnerNumber;
    }


    // 예외사항
    private void validate(List<Integer> numbers) throws IOException { // 예외사항 기존 코드
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 여섯자리여야 합니다.");
        }

        if (inputMoney() % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위입니다."); // 추후에 삭제 예정
        }

//        if(Lotto 중복) {
//            throw new IllegalArgumentException("로또는 서로 다른 여섯자리 숫자로 구입해야 합니다.");
//        }
    }

}
