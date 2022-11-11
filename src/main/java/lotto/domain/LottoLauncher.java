package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoLauncher {
    public void startLotto(){
        LottoDto lottoDto = inputMoney();

        System.out.println(lottoDto);

        Lotto lotto_1st = create1stLotto();
        int bonusNumbers = createBonusNumber();

        CompareLotto compareLotto = new CompareLotto(lottoDto, lotto_1st, bonusNumbers);

        System.out.println(compareLotto);
    }

    private LottoDto inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");

        int money = castInt(Console.readLine());

        return new LottoDto(money);
    }

    private Lotto create1stLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");

        String numbers = Console.readLine();

        return new Lotto(numbers);
    }

    private int createBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");

        return castInt(Console.readLine());
    }

    private int castInt(String readLine) {
        try {
            return Integer.parseInt(readLine);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
