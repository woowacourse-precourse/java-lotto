package lotto;

import java.util.List;

public class Statistics {
    private final User user;
    private final WinningLotto winningLotto;
    public Statistics(User user , WinningLotto winningLotto){
        this.user = user;
        this.winningLotto = winningLotto;
    }

    public void match(){
        compare(user,winningLotto);
    }

    private void compare(User user, WinningLotto winningLotto) {
        List<Lotto> userLotto = user.userLottoes.getUserLottoes();
        Integer correct3Number = 0;
        Integer correct4Number = 0;
        Integer correct5Number = 0;
        Integer correct6NumberContainBonusNumber =0;
        Integer correct6Number = 0;

        for (Lotto l : userLotto){
            List<Integer> userLottoOne = l.getNumbers();
            List<Integer> winningLottoNumber = winningLotto.getWinningLotto();
            Integer bonusNumber = winningLotto.getBonusNumber();

            correct3Number += compareCorrect3Number(userLottoOne,winningLottoNumber);
            correct4Number += compareCorrect4Number(userLottoOne,winningLottoNumber);
            correct5Number += compareCorrect5Number(userLottoOne,winningLottoNumber);
            correct6NumberContainBonusNumber +=
                    compareCorrect6NumberContainBonusNumber(userLottoOne,winningLottoNumber,bonusNumber);
            correct6Number += compareCorrect6Number(userLottoOne,winningLottoNumber);
        }

        System.out.println("correct3Number = " + correct3Number);
        System.out.println("correct4Number = " + correct4Number);
        System.out.println("correct5Number = " + correct5Number);
        System.out.println("correct6NumberC = " + correct6NumberContainBonusNumber);
        System.out.println("correct6Number = " + correct6Number);
    }

    private Integer compareCorrect3Number(List<Integer> userLottoOne, List<Integer> winningLottoNumber) {
        Integer correctNumbers = 0;
        for (Integer number: userLottoOne){
            if (winningLottoNumber.contains(number)) correctNumbers++;
        }

        if (correctNumbers == 3) return 1;

        return 0;
    }

    private Integer compareCorrect4Number(List<Integer> userLottoOne, List<Integer> winningLottoNumber) {
        Integer correctNumbers = 0;
        for (Integer number: userLottoOne){
            if (winningLottoNumber.contains(number)) correctNumbers++;
        }

        if (correctNumbers == 4) return 1;

        return 0;
    }

    private Integer compareCorrect5Number(List<Integer> userLottoOne, List<Integer> winningLottoNumber) {
        Integer correctNumbers = 0;
        for (Integer number: userLottoOne){
            if (winningLottoNumber.contains(number)) correctNumbers++;
        }

        if (correctNumbers == 5) return 1;

        return 0;
    }

    private Integer compareCorrect6NumberContainBonusNumber(List<Integer> userLottoOne, List<Integer> winningLottoNumber,
                                          Integer bonusNumber) {
        Integer correctNumbers = 0;
        Integer correctBonusNumbers = 0;

        for (Integer number: userLottoOne){
            if (winningLottoNumber.contains(number)) correctNumbers++;
        }
        if (winningLottoNumber.contains(bonusNumber)) correctBonusNumbers++;

        if (correctNumbers == 5 && correctBonusNumbers == 1) return 1;

        return 0;

    }

    private Integer compareCorrect6Number(List<Integer> userLottoOne, List<Integer> winningLottoNumber) {
        Integer correctNumbers = 0;
        for (Integer number: userLottoOne){
            if (winningLottoNumber.contains(number)) correctNumbers++;
        }

        if (correctNumbers == 6) return 1;

        return 0;
    }

}
