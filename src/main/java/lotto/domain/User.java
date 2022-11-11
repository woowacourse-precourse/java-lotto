package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public User(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<String> numbers = List.of(input.split(","));
        //validateLottoPlusBonusNum(numbers);
        for(String num: numbers){
            winningNumber.add(Integer.parseInt(num));
        }
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();

    }

    private void validateLottoNum(List<String> numbers){
        if(numbers.size()!=6){
            throw  new IllegalArgumentException("[ERROR] 로또의 번호가 6개여야 합니다");
        }

        if(Set.copyOf(numbers).size() != 6 ){
            throw  new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 중복이 없어야 합니다");
        }
        for(int i=0; i<numbers.size(); i++){
            String num = numbers.get(i);
            if(num.charAt(i) <1 || num.charAt(i)>45){
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 숫자만 입력 가능합니다");
            }
        }

    }
    private void validateBonusNum(String num){
        if(num.length() != 1){
            throw  new IllegalArgumentException("[ERROR] 보너스 번호는 한 개입니다");
        }

        if(winningNumber.contains(bonusNumber)){
            throw  new IllegalArgumentException("[ERROR] 로또 번호와 보너스 번호는 중복이 없어야 합니다");
        }
        if( num.charAt(0)<1 || num.charAt(0)>45){
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 숫자만 입력 가능합니다");
        }

    }

}
