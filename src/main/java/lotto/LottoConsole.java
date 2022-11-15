package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoConsole {
    static final long MAX_INT = 2147483647;
    static final int MIN_LOTTO_NUM = 1;
    static final int MAX_LOTTO_NUM = 45;
    LottoManager lottoManager = new LottoManager();
    public void inputMoney() throws IllegalArgumentException{
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = stringToInt(input);
        if (money == -1){
            throw new IllegalArgumentException("[ERROR] 구입금액 입력이 올바르지 않습니다.");
        }
        lottoManager.InputMoney(money);

        System.out.println();
    }

    public void inputNumbers() throws IllegalArgumentException{
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        List<Integer> numbers = validateNumbers(input);
        if (numbers == null){
            throw new IllegalArgumentException("[ERROR] 로또 번호 입력이 올바르지 않습니다.");
        }
        lottoManager.setWinNumbers(numbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        input = Console.readLine();
        System.out.println();
        int bonusNumber = validateNumber(input, numbers);
        if (bonusNumber == -1){
            throw new IllegalArgumentException("[ERROR] 로또 번호 입력이 올바르지 않습니다.");
        }
        lottoManager.setBonusNumber(bonusNumber);

        lottoManager.matchLottos();
    }

    public void printLottoNumbers(){
        System.out.printf("%d개를 구매했습니다.\n", lottoManager.getInputMoney() / 1000);
        List<Lotto> lottos = lottoManager.getLottos();

        for (Lotto lotto : lottos){
            printLottoNumber(lotto);
            System.out.println();
        }
        System.out.println();
    }

    public void printResult(){
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoManager.getWinCount(5));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoManager.getWinCount(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoManager.getWinCount(3));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoManager.getWinCount(2));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoManager.getWinCount(1));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", lottoManager.getEarningRate());
    }

    private void printLottoNumber(Lotto lotto){
        List<Integer> numbers = lotto.getNumbers();
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++){
            System.out.printf("%d", numbers.get(i));
            if (i != numbers.size() - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    List<Integer> validateNumbers(String input){
        List<Integer> ret = new ArrayList<>();
        String[] strings = input.split(",");

        for (String str : strings){
            int number = validateNumber(str, ret);
            if (number == -1){
                return null;
            }
            ret.add(number);
        }
        return ret;
    }

    private int validateNumber(String input, List<Integer> numbers){
        int number = stringToInt(input);

        if (isOverRange(number) || isDuplicate(numbers, number)) {
            return -1;
        }
        return number;
    }

    private boolean isOverRange(int number){
        if (number >= MIN_LOTTO_NUM && number <= MAX_LOTTO_NUM){
            return false;
        }
        return true;
    }

    private boolean isDuplicate(List<Integer> numbers, int number){
        if (numbers.contains(number)){
            return true;
        }
        return false;
    }

    private int stringToInt(String input){
        long val = 0;

        for (int i = 0; i < input.length(); i++){
            if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')){
                return -1;
            }
            val *= 10;
            val += input.charAt(i) - '0';
            if (val > MAX_INT){
                return -1;
            }
        }
        return (int)val;
    }

}