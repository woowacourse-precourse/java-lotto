package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers; // 기존 코드
    private static final int LOTTO_LENGTH = 6;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static int userInputMoney;
    private static int howManyLotto = 0;
    public static List<ArrayList> myLottoList = new ArrayList<>();
    public static List<Integer> winnerNumberList = new ArrayList<>();
    public static List<Integer> bonusNumberList = new ArrayList<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Lotto(List<Integer> numbers) throws IOException { // 생성자, 기존 코드
        validate(numbers);
        this.numbers = numbers;
    }

    // 로또 구입 금액 입력 (완성)
    public static int inputMoney() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        String nullCheck = br.readLine();
        if (nullCheck == null){
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요");
        }

        int inputMoney = Integer.parseInt(nullCheck);
        userInputMoney = inputMoney;

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


    // 로또 개수 (완성)
    public static int theNumberOfLotto() throws IOException {
        howManyLotto = userInputMoney / 1000;

        return howManyLotto;
    }

    public static int getHowManyLotto(){
        return howManyLotto;
    }

    //한 개의 로또 번호 생성 (완성)
    public static ArrayList<Integer> oneLotto(){
        ArrayList<Integer> oneLotto = new ArrayList<>();
        for (int i = 0; i < 6; i++){
            int num = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            oneLotto.add(num);
            for(int j = 0; j < i; j++){
                if(oneLotto.get(i) == oneLotto.get(j)){
                    oneLotto.remove(i);
                    i--;
                    break;
                }
            }
        }
        Collections.sort(oneLotto);
        return oneLotto;
    }




    // 내 로또 생성 (완성)
    public static List<ArrayList> myLottoNumber() throws IOException { // 랜덤 로또 생성

        List<ArrayList> lottoList = new ArrayList<>();

        for (int i = 0; i < getHowManyLotto(); i++){
            ArrayList<Integer> exampleLotto = oneLotto();
            myLottoList.add(exampleLotto);
            System.out.println(exampleLotto);
        }

        return lottoList;
    }

    public static List<ArrayList> getMyLottoList(){
        return myLottoList;
    }

    //당첨 로또 입력 (완성)
    public static List<Integer> winnerNumber() throws IOException {
        List<Integer> winnerNumber = new ArrayList<>();
        System.out.println("당첨 번호를 입력해주세요.");
        String inputNumbers = br.readLine();
        String[] numberList = inputNumbers.split(",");

        for (int i = 0; i < LOTTO_LENGTH; i++) {
            if (Integer.parseInt(numberList[i]) > 0 && Integer.parseInt(numberList[i]) < 46) {
                winnerNumber.add(Integer.parseInt(numberList[i]));
            }
            if (Integer.parseInt(numberList[i]) <= 0 && Integer.parseInt(numberList[i]) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        Collections.sort(winnerNumber);
        winnerNumberList = winnerNumber;
        if (numberList.length == 6) {
            return winnerNumber;
        }
        if (numberList.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 여섯 자리의 수 입니다. ");
        }

        return winnerNumber;
    }

    //보너스 번호 (완성)
    public static int winnerNumberBonus() throws IOException {
        System.out.println("보너스 번호를 입력해 주세요");
        int bonusNumber = Integer.parseInt(br.readLine());
        if(bonusNumber <= 0 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        bonusNumberList.add(bonusNumber);
        return bonusNumber;
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
