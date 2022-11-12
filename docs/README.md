# ⚾︎ 미션 - 로또


## 👀 문제 확인하기
- 우아한테크코스 3주차 과제 중 '**로또**'의 구현 기능과 구현 로직을 담은 문서입니다.
- 문제는 [여기](https://github.com/woowacourse-precourse/java-lotto)에서 확인해 주세요.

---

## 🌟 구현 기능 목록

### ☑️ 사용자 입력 기능
- 사용자로부터 값을 입력받는다.
  - *InputUtil#getUserInput()*

### ☑️ 제한사항 검증 기능
- 사용자의 입력값에 대한 검증 기능을 제공한다. 다음과 같은 경우 예외 사항으로 판단한다.
  - [예외] 입력받은 구입 금액이 1,000으로 나누어 떨어지지 않는 경우 
    - *ValidationUtil#validatePurchase()*
  - [예외] 입력받은 당첨 번호의 개수가 6개가 아닌 경우  
    - *ValidationUtil#validatedWinningCount()*
  - [예외] 입력받은 당첨 번호에 공백값이 들어있는 경우 
    - *ValidationUtil#validateBlank()*
  - [예외] 입력받은 당첨 번호에 중복된 값이 있는 경우 
    - *ValidationUtil#validateDuplicate()*
  - [예외] 입력받은 당첨 번호가 1~45 사이의 값이 아닌 경우 
    - *ValidationUtil#validateWinningRange()*
  - [예외] 입력받은 보너스 번호가 1~45 사이의 값이 아닌 경우 
    - *ValidationUtil#validateBonusRange()*
- 예외 사항에 대해서는 예외 메시지 출력 및 `IllegalArgumentException`를 발생시킨다.

### ☑️ 로또 번호 발행 기능
- 1~45 사이의 값을 가지는 로또 번호 6개를 랜덤하게 생성하여 형식에 맞게 리턴한다.
- *NumberGenerator#getLottoNumbers()*

### ☑️ 로또 번호 비교 기능
- 발행한 로또 번호와 당첨 번호가 일치하는 개수를 계산한다.
- *LottoPrize#getMatchCount*

### ☑️ 수익률 계산 기능
- 사용자의 구입 금액과 당첨된 경우 받을 수 있는 금액에 대하여 수익률을 계산하여 리턴한다.
- *LottoPrize#computeEarningRate*

### ☑️ 메시지 출력 기능 
- 프로그램을 진행하며 출력되는 메시지를 관리한다.
  - 가장 먼저 `구입금액을 입력해 주세요.`를 출력한다.
    - *MessageUtil#printPurchaseInput()*
  - 구입한 개수에 따라 `x개를 구매했습니다.`와 발행한 로또 번호를 `[1, 2, 3, 4, 5, 6, 7, 8]`와 같은 형식으로 출력한다.
    - *MessageUtil#printPurchaseCount()*
  - 당첨 번호 입력 시 `당첨 번호를 입력해 주세요.`를 출력한다.
    - *MessageUtil#printWinningInput()*
  - 보너스 번호 입력 시 `보너스 번호를 입력해 주세요.`를 출력한다.
    - *MessageUtil#printBonusInput()*
  - 당첨 통계 안내 시 `당첨 통계`, `---`를 출력하고 일치하는 개수에 따라 값을 출력한다.
    - *MessageUtil#printWinningStats()*
    - `x개 일치 (y원) - z개` 형식으로 출력한다.
      - *MessageUtil#printWinningStatsResult()*
    - 수익률 안내 시 `총 수익률은 x%입니다.`를 출력한다.
      - *MessageUtil#printEarningRate()*
---

## 💡 구현 로직
~~~

~~~

---

## 🔍 소감
