package lotto.service;

public class Logic {

    //단일 로또에 대해 당첨 넘버와 비교
    public int countSameNumber(int[] lottoNumbers, int[] winningNumbers) {
        int count = 0;
        for (int lottoNumber : lottoNumbers) {
            count = increaseCount(winningNumbers, count, lottoNumber);
        }
        return count;
    }

    private int increaseCount(int[] winningNumbers, int count, int lottoNumber) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber == lottoNumber) {
                count++;
            }
        }
        return count;
    }

}
