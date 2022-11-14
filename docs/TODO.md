# ✔ TODO
- ~~상수 Texts 정의~~
    - ~~금액/번호 입력 메시지~~
    - ~~로또 구매 결과 메시지~~
    - ~~당첨 결과 메시지 - 개수별~~
    - ~~총 수익률 메시지~~
    - ~~에러 메시지~~
- ~~상수 Values 정의~~
    - ~~번호 자리수~~
    - ~~최소 일치수~~
    - ~~최대 일치수~~
    - ~~담첨 금액~~
    - ~~당첨 금액 Format~~
- ~~Game 클래스 정의~~
  - ~~public void run~~
  - ~~private void play~~
- ~~User 클래스 정의~~
    - ~~List<Lotto> lotteries~~
    - ~~List<List<Result>> results~~
    - ~~Integer lotteryCount~~
    - ~~Integer winnings~~
- ~~Checker 클래스 정의~~
    - ~~public void checkAmountInput~~
        - ~~public int checkNumeric~~
        - ~~public void checkNegative~~
        - ~~public void checkAmount~~
        - ~~public void checkRemain~~
    - ~~public boolean checkIllegalArgument~~
    - ~~public int checkCoincide~~
    - ~~public float checkLotteryReturn~~
- ~~Result 클래스 정의~~
    - ~~Lotto lottery~~
    - ~~Integer coincideCount~~
- ~~WinningLotto 클래스 정의~~
    - ~~extends Lotto~~
- ~~Application 클래스~~
    - ~~Create Game > run Game~~
* * *
## TEST 구현
#### 단위 테스트 -
- ##### Lotto
  - 생성자 | 예외
- ##### Result
  - 생성자 | 예외
- ##### User
  - 생성자 | 예외
- ##### WinningLotto
  - 생성자 | 예외
#### 통합 테스트 -