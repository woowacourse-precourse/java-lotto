package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {
    private static final int CNT_NUMBER = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String REGEX = "[0-9]+";
    private static List<List> userLotto = new ArrayList<>();

    public UserLotto() {}

    public int setPurchaseAmount(){
        String input = Console.readLine();
        validateLetter(input);
        return Integer.parseInt(input);
    }

    public List<List> getUserLotto(){
        return userLotto;
    }

    public void getPurchaseLottoNumbers(){
        for(int i=0;i<userLotto.size();i++){
            List<Integer> numbers = new ArrayList<>(userLotto.get(i));
            printPurchaseLottoNumbers(numbers);
        }
    }

    public void printPurchaseLottoNumbers(List<Integer> numbers){
        System.out.print("[");
        for(int i=0;i<numbers.size();i++){
            System.out.print(numbers.get(i));
            if(i!=numbers.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void validateLetter(String input){
        if(!input.matches(REGEX)){
            System.out.println("[ERROR] 구입 금액에 숫자외 문자가 존재합니다.");
            throw new IllegalArgumentException("[ERROR]구입 금액에 숫자외 문자가 존재합니다.");
        }
    }

    public void validateUnit(int input){
        if(input % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1000원 단위가 아닙니다.");
        }
    }

    public void setRandomNumber(){
        List<Integer> lottoNumbers = new ArrayList<>();

        lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,CNT_NUMBER);
        Collections.sort(lottoNumbers);

        new Lotto(lottoNumbers);

        this.userLotto.add(lottoNumbers);
    }

}
