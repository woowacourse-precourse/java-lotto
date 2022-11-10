package lotto;

import java.util.ArrayList;
import java.util.List;

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
}
