package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public static final int UNIT = 1000;
    public static final int LOTTO_LEN = 6;
    public static final int LOTTO_MAX_SIZE = 45;
    public static final int LOTTO_MIN_SIZE = 1;

    private int userMoney = 0;
    private int resultMoney = 0;
    private int numOfLotto = 0;
    private List<Lotto> lottos = new ArrayList<>();

    public void readMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = Integer.parseInt(readLine());
        validDataInputNumber(inputMoney);
        userMoney = inputMoney;
    }

    public void validDataInputNumber(int inputMoney) {
        if(inputMoney%UNIT != 0){
            System.out.println("[ERROR] 금액은 1000원 단위로 나뉘어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void addLotto(List<Integer> lottoNumber){
        Lotto lotto = new Lotto(lottoNumber);
        lottos.add(lotto);
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

    public int getNumOfLotto() {
        return numOfLotto;
    }
}
