### 📌 기능 리스트업
💡 구현 기능

🚫 예외 사항
- ```IllegalArgumentException``` 발생 후, 
- [ERROR]로 시작하는 에러 메시지 출력 후 종료
- ex. ```[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.```

#### 로또 게임 규칙
- 로또 번호의 숫자 범위 1~45
- 1개의 로또를 발행할 때 ```중복되지 않는``` 6개의 숫자
- 당첨 번호 추첨 시 ```중복되지 않는``` 6개의 숫자 + 보너스 번호 1개
- 1등 : 6개 번호 일치
- 2등 : 5개 번호 + 보너스 번호
- 3등 : 5개 번호
- 4등 : 4개 번호
- 5등 : 3개 번호

### 📌 메인 기능
1. 구입 금액 입력 시 구입 금액만큼 로또 개수 발행(로또 1장당 1,000원)
- 💡 구입 금액을 입력 받는 기능 ```Money class```
  - 🚫 숫자가 아닌 값인 경우 : IS_NOT_NUMERIC

  - 🚫 1,000원 단위로 나누어지지 않는 경우 : INVALID_BUY_MONEY
    - 작거나 나누어지지 않을 때


- 💡 입력한 금액만큼 로또 번호를 출력해주는 기능 ```LottoService```
  - LottoService.addLotteries(int buyNumber)
  - LottoService.printLotteries()
  
  
  - 💡 랜덤 로또 번호를 오름차순으로 반환 ```Lotto class```
    - Lotto.createRandomNumbers()
    - 🚫 6개의 숫자가 입력되지 않을 경우 : INVALID_LOTTO_SIZE
    - 🚫 중복 값이 입력될 경우 : INCLUDE_DUPLICATE_VALUE

2. 로또 당첨 번호를 입력 ```Winning class```
- 💡 문자열 번호를 정수형 리스트로 분리하기 
  - splitNumbers()


- 6개의 당첨 숫자 입력(, 쉼표를 기준으로 구분)
  - 🚫 6개의 숫자가 입력되지 않을 경우 : INVALID_LOTTO_SIZE
    - 적거나, 많거나
  - 🚫 중복 값이 입력될 경우 : INCLUDE_DUPLICATE_VALUE
  - 🚫 로또 번호의 숫자 범위(1~45)를 벗어났을 경우 : INVALID_LOTTO_RANGE
  - 🚫 숫자가 아닌 값인 경우 : IS_NOT_NUMERIC


- 1개의 보너스 번호를 입력
  - 🚫 1개의 숫자가 입력되지 않을 경우 : INVALID_BONUS_SIZE
  - 🚫 6개의 당첨 숫자와 중복되는 숫자인 경우 : ALREADY_EXIST_WIN_NUMBER
  - 🚫 로또 번호의 숫자 범위(1~45)를 벗어났을 경우 : INVALID_LOTTO_RANGE
  - 🚫 숫자가 아닌 값인 경우 : IS_NOT_NUMERIC
  
3. 당첨 통계 ```LottoService```
- 💡 6개의 숫자 중에 몇개 일치하는지 확인
  - checkWinningNumber()


- 💡 5개의 숫자를 맞추면 보너스 번호 일치하는지 확인
  - checkBonusNumber()
  - 6개 일치는 보너스 번호 확인 X


- 💡 총 수익 금액 계산
  - addProfit()
  - 2등 당첨 시, 3등은 계산하지 않는다.


- 💡 수익률 출력
  - getLottoRate()
  - 조건1 : 소수점 둘째 자리에서 반올림 ```(ex. 100.0%, 51.5%, 1,000,000.0%)```
  - 조건2 : 세자리씩 콤마 찍기 ```DecimalFormat``` 사용 <br>
  ```DecimalFormat RateFormat = new DecimalFormat("###,##0.0");```


- 당첨 번호를 몇 개씩 맞췄는지 Map에서 관리
  - 💡 당첨 개수 별 Map 생성
    - createMatches()

  - 💡 보너스 번호 일치할 때, 일치하지 않을 때 Map 값 갱신
    - checkBonusMatch()
-------------------
### 📌 기타 기능
1. 당첨 등수별 금액 관리 ```Rank enum```
```java
    FIRST_RANK(1, 6, 2000000000),
    SECOND_RANK(2, 7, 30000000),
    THIRD_RANK(3, 5, 1500000),
    FOURTH_RANK(4, 4, 50000),
    FIFTH_RANK(5, 3, 5000),
    NOTHING(6,0,0);
```
- 💡 당첨 번호 일치 개수로 Rank 찾기
  - findRankByMatch()
- 💡 당첨 번호에 맞는 일치 개수와 금액을 출력
  - override : toString()
  
2. 에러 메시지 관리 ```Error enum```
```java
    INVALID_LOTTO_SIZE("로또 번호의 개수가 6개가 아닙니다."),
    INCLUDE_DUPLICATE_VALUE("로또 번호에 중복 번호가 있습니다."),
    IS_NOT_NUMERIC("입력 값에 숫자가 아닌 값이 있습니다"),
    INVALID_BUY_MONEY("구입 금액이 1000보다 작거나 1000으로 나뉘지 않습니다."),
    INVALID_LOTTO_RANGE("로또 번호가 1보다 작거나 45보다 큽니다."),
    INVALID_BONUS_SIZE("보너스 번호의 개수가 1개가 아닙니다."),
    ALREADY_EXIST_WIN_NUMBER("당첨 번호에 이미 중복 값이 존재합니다.");
```
- 💡 [ERROR]로 시작하는 에러 메시지 출력
  - override : toString()