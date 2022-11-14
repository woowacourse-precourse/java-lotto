package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private int lottoAmount;
    private List<Lotto> lottoNumber = new ArrayList<>();

    public void LottoBuyPriceInput(){
        System.out.println("구입금액을 입력해 주세요.");
        int buyPrice = Integer.parseInt(Console.readLine());
        System.out.println();
        if(buyPrice % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
        int lottoNum = buyPrice / 1000;
        lottoAmount = lottoNum;
        System.out.println(lottoNum + "개를 구매했습니다.");
    }

    public void inputLottoNumber(){
        for(int i = 0; i < lottoAmount; i++){
            lottoNumber.add(autoGenerate());
        }
        for(Lotto lotto : lottoNumber){
            System.out.println(lotto.getNumbers());
        }
    }

    private Lotto autoGenerate(){
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
        return new Lotto(numbers);
    }

    public List<Integer> inputWinningNumber(){
        System.out.println("\n당첨 번호를 입력해 주세요.\n");
        List<Integer> winningNumber;
        winningNumber = Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return winningNumber;
    }

    public int inputBonus(){
        System.out.println("\n보너스 번호를 입력해주세요.");
        int bonusNumber;
        bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }

    public void bonusValidate(List<Integer> lottoNumber, int bonusNumber){
        if (lottoNumber.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 6개의 로또 번호와 중복이 불가합니다.");
        }
        if (bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }
}
