package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class View {

    public int enterMoneyFromCustomer() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());
        if(money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 잘못된 금액을 입력하였습니다.");

        System.out.println();
        return money;
    }

    public void printPurchasedLottos(Customer customer) {
        List<Lotto> lottos = customer.getLottos();
        System.out.printf("%d개를 구매했습니다.", lottos.size());
        System.out.println();

        for(Lotto lotto : lottos){
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }

        System.out.println();
    }

    public List<Integer> enterWinNumbersFromAdmin() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        List<Integer> winNumbers = new ArrayList<>();
        for(String s : input){
            Integer number = Integer.valueOf(s);
            validateLottoNumber(number);
            winNumbers.add(number);
        }
        System.out.println();

        return winNumbers;
    }

    private void validateLottoNumber(Integer number) {
        if( !(1 <= number && number <= 45)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int enterBonusNumberFromAdmin(List<Integer> winNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.valueOf(Console.readLine());

        validateLottoNumber(bonusNumber);
        validateDuplicateLottoNumber(winNumbers, bonusNumber);

        System.out.println();
        return bonusNumber;
    }

    private void validateDuplicateLottoNumber(List<Integer> winNumbers, Integer bonusNumber) {
        if(winNumbers.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 당첨 번호에 포함된 번호입니다.");
    }

    public void printStat() {
        System.out.println("당첨 통계");
        System.out.println("---");

    }
}
