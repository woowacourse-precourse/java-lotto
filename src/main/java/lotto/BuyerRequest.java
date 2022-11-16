package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BuyerRequest {

    public int amountOfLotto(String money) {

        //숫자만 입력
        try{
            Integer.parseInt(money);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }

        //1000원 단위만 입력
        if(Integer.parseInt(money)%1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
        }

        return Integer.parseInt(money)/1000 ;

    }

    public List<List<Integer>> lottos(int amount) {
        List<List<Integer>> lottos = new ArrayList<List<Integer>>(amount);

        for(int i = 0; i < amount; i++) {
            ArrayList<Integer> lotto = new ArrayList<>();

            while(lotto.size() < 6) {
                lotto.add(Randoms.pickNumberInRange(1,45));
                lotto = (ArrayList<Integer>) lotto.stream().distinct().sorted().collect(Collectors.toList());
            }
            lottos.add(lotto);
        }

        return lottos;
    }

    public void printBuyerLotto(List<List<Integer>> lottos) {
        for(int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i));
        }
    }

    public static void main(String[] args) {
        BuyerRequest br = new BuyerRequest();
    }
}
