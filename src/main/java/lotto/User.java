package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    static final int UNIT = 1000;
    static final int LOTTO_LEN = 6;
    static final int LOTTO_MAX_SIZE = 45;
    static final int LOTTO_MIN_SIZE = 1;

    private int userMoney = 0;
    private int resultMoney = 0;
    private int numOfLotto = 0;
    private List<Lotto> lottos = new ArrayList<>();

    public void readMoney(){
        int inputMoney = Integer.parseInt(readLine());
        validateInputNumber(inputMoney);
        userMoney = inputMoney;
    }

    private void validateInputNumber(int inputMoney) {
        if(inputMoney%UNIT != 0){
            System.out.println("[ERROR] 금액은 1000원 단위로 나뉘어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void readLotto(){
        String inputLottoNumber = readLine();
        validateInputLottoNumber(inputLottoNumber);
        lottos.add(new Lotto(convertLottoNumber(inputLottoNumber)));
    }

    private List<Integer> convertLottoNumber(String inputLottoNumber) {
        ArrayList<String> split = new ArrayList<>(List.of(inputLottoNumber.split(", ")));
        return split.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    private void validateInputLottoNumber(String inputLottoNumber) {
        ArrayList<String> split = new ArrayList<>(List.of(inputLottoNumber.split(", ")));
        if(split.size() != LOTTO_LEN){
            System.out.println("[ERROR] 숫자 입력이 잘못 되었습니다.");
            throw new IllegalArgumentException();
        }
        List<Integer> lottoNumber = convertLottoNumber(inputLottoNumber);

        for (Integer integer : lottoNumber) {
            if(integer > LOTTO_MAX_SIZE || integer < LOTTO_MIN_SIZE){
                System.out.println("[ERROR] 숫자는 1이상 45 이하의 숫자로 구성되어야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void showLottos(){
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void setNumOfLotto(){
        if(userMoney != 0){
            numOfLotto = userMoney/UNIT;
        }
    }
}
