package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    private int userMoney;
    private int resultMoney;
    private int numOfLotto;
    private List<Lotto> lottos = new ArrayList<>();

    public void readMoney(){
        int inputMoney = Integer.parseInt(readLine());
        validateInputNumber(inputMoney);
        userMoney = inputMoney;
    }

    private void validateInputNumber(int inputMoney) {
        if(inputMoney%1000 != 0){
            System.out.println("[ERROR] 금액은 1000원 단위로 나뉘어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void readLotto(){
        String inputLottoNumber = readLine();
        validateInputLottoNumber(inputLottoNumber);
        lottos.add(new Lotto(convertLottoNumber(inputLottoNumber)));
    }

    private void validateInputLottoNumber(String inputLottoNumber) {
        ArrayList<String> split = new ArrayList<>(List.of(inputLottoNumber.split(", ")));
        if(split.size() != 6){
            System.out.println("[ERROR] 숫자 입력이 잘못 되었습니다.");
            throw new IllegalArgumentException();
        }
        List<Integer> lottoNumber = split.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        for (Integer integer : lottoNumber) {
            if(integer > 45 || integer < 1){
                System.out.println("[ERROR] 숫자는 1이상 45 이하의 숫자로 구성되어야 합니다.");
                throw new IllegalArgumentException();
            }
        }

    }
}
