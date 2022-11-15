# 로또 게임

## 로또 게임 기능 목록
1. 로또 구입
   - [x] (입력) 구입 금액을 입력 받기 _Input#inputMoney_
     - [x] (예외) 1000 단위로 나누어 떨어지지 않는 경우 오류 발생 _Input#vaildMoney_
   - [x] 1000원당 1장씩 로또 발행 한다. _Lotto#getLotto_
2. 로또 발행
   - [x] (출력) 발행한 로또 수량을 출력한다. _Message#PRINT_BUY_LOTTO_
   - [x] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다. _Random#pickUniqueNumbersInRange_
     - [x] 숫자 6개를 뽑는다. _Lotto#validate_
   - [x] (출력) 발행된 로또 숫자를 출력한다. _Message#PRINT_LOTTOS_
3. 추첨 번호/보너스 번호 입력
   - [x] (출력) 당첨 번호 입력 메시지 출력 _Message#askWinNums_
   - [x] (입력) 당첨 번호 입력 6개 숫자. _Input#inputWinNums_
     - [x] `,`로 구분한다. Input#validSplit
   - [x] (출력) 보너스 번호 입력 메시지 출력 _Message#askBonusNum_
   - [x] (입력) 보너스 번호 입력 1개 숫자 _Input#bonusNum_
   - [x] (예외) 모든 숫자는 서로 달라야 한다. _Input#isDiffrent_
   - [x] (예외) 숫자 범위는 1~45 사이 _Input#validRange_
4. 당첨 통계 출력
   - [] 당첨 여부 판별 _Compare#countWin_
   - [] (출력) 통계 출력 _Message#resultLotto_
      - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
         ```
         1등: 6개 번호 일치 / 2,000,000,000원
         2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
         3등: 5개 번호 일치 / 1,500,000원
         4등: 4개 번호 일치 / 50,000원
         5등: 3개 번호 일치 / 5,000원
         ```
5. 수익률 출력
   1. 수익률을 계산한다. _Checker#PRINT_YIELD_
   2. (출력) 출력한다 Message#resultYield
      1. 당첨금액/구입금액 소숫점 둘째자리에서 반올림한다.
6. 게임 종료

## 필요한 예외 체크 사항
   1. 돈이 1000원 단위로 나누어 떨어지는가?
   2. 입력한 로또 번호는 정수이며 1~45 이내에 있는가?
   3. 입력한 7개의 번호가 각각 다른가?
   4. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.
      ```java
         // [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
      ```
      - 예외 발생 시 로그를 남기고, 프로그램이 종료되는 상황을 생각해 보세요.

# 기능요구사항
- [링크](../README.md)