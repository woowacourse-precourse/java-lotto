package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static final int UNIT = 1000;
    public static final int LOTTO_LEN = 6;
    public static final int LOTTO_MAX_SIZE = 45;
    public static final int LOTTO_MIN_SIZE = 1;

    private int userMoney = 0;
    private int numOfLotto = 0;
    private List<Lotto> lottos = new ArrayList<>();

    public void setUserMoney(String money){
        checkInputMoneyIsValidate(money);
        userMoney = Integer.parseInt(money);
    }

    public void isNumericInputNumber(String s) {
        try {
            if (!(s != null && s.matches("[-+]?\\d*\\.?\\d+"))) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액 입력이 잘못되었습니다.");
        }
    }

    public void checkInputMoneyIsValidate(String s){
        isNumericInputNumber(s);
        isDivided(Integer.parseInt(s));
    }

    public void isDivided(int inputMoney) {
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

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getUserMoney() {
        return userMoney;
    }

    public int getNumOfLotto() {
        return numOfLotto;
    }
}
