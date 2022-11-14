package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    Output output = new Output();

    public int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchasedValueReader = Console.readLine();

        for (int i = 0; i < purchasedValueReader.length(); i++){
            if (purchasedValueReader.charAt(i) < '0' || purchasedValueReader.charAt(i) > '9'){
                output.wrongNumberException();
            }
        }

        return Integer.parseInt(purchasedValueReader);
    }


    public int checkHowManyLotto(int purchasedValue){
        if (purchasedValue % 1000 != 0) {
            output.wrongNumberException();
        }

        int lottoCount = purchasedValue / 1000;
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");

        return lottoCount;
    }

    public static void userInputLottoNumber(int[] userInputLottoNumber, int userInputBonusNumber){
        String userInputLotto;
        String[] userInputLottoTmp;
        System.out.println("\n당첨 번호를 입력해 주세요.");
        userInputLotto = Console.readLine();
        userInputLottoTmp = userInputLotto.split(",");
        for (int i = 0; i < userInputLottoTmp.length; i++) {
            userInputLottoNumber[i] = Integer.parseInt(userInputLottoTmp[i]);
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        userInputBonusNumber = Integer.parseInt(Console.readLine());
    }

}
