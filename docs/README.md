## 로또 - 체크 리스트

### 상수
- [x] 로또 번호 범위: **Integer**
  - [x] 최소값: 1
  - [x] 최대값: 45
- [x] 등수별로 일치해야하는 번호의 개수: **Integer**
  - [x] 1등: 6
  - [x] 2,3등: 5
    - 특이 사항: 2등은 5개 + 보너스 번호가 일치해야함
  - [x] 4등: 4
  - [x] 5등: 3
- [x] 등수별 상금 금액 문자 조각: **Integer**
  - [x] 1등: 2000000000
  - [x] 2등: 30000000
  - [x] 3등: 1500000
  - [x] 4등: 50000
  - [x] 5등: 5000
- [x] 로또 개당 금액: **Integer**
  - [x] 금액: 1000
- [x] 출력용 문구: **String**
  - [x] 시작: "구입금액을 입력해 주세요."
  - [x] 구매 개수: "개를 구매했습니다."
  - [x] 당첨 번호: "당첨 번호를 입력해 주세요."
  - [x] 보너스 번호: "보너스 번호를 입력해 주세요."
  - [x] 결과: "당첨 통계%n---"
  - 당첨 내역: **String**
    - [x] 1등: "개 일치 (2,000,000,000원) - %f개"
    - [x] 2등: "개 일치 (30,000,000원) - %f개"
    - [x] 3등: "개 일치 (1,500,000원) - %f개"
    - [x] 4등: "개 일치 (50,000원) - %f개"
    - [x] 5등: "개 일치 (5,000원) - %f개"
  - [x] 수익률: "총 수익률은 %.1f%입니다."
  - 예외 문구: **String**
    - [x] 에러 서두: "[ERROR] "
    - [x] 예외 사항 1: "로또 번호는 1부터 45사이의 숫자여야 합니다."
    - [x] 예외 사항 2: "구입금액은 1000으로 나누어 떨어지는 숫자여야 합니다."
    - [x] 예외 사항 3: "당첨 번호는 쉼표로 구분된 6개의 숫자들이여야 합니다."
    - [x] 예외 사항 4: "보너스 번호는 당첨 번호에 없는 숫자여야 합니다."

### 기능
- [ ] 기능 1: 로또 구입 금액을 입력한다.
  - [ ] 구입 금액(int budget) / 1000의 몫을 로또 개수로 선언(int lotteryNum)
  - [ ] 입력된 구입 금액이 1000으로 나누어 떨어지지 않는다면 ***예외 사항 3***에 해당한다.
- [ ] 기능 2: 로또 번호를 발행한다.
  - [ ] 1 이상, 45 이하인 6개의 숫자들을 한 리스트/배열에 담는다. (List<Integer> lottery)
  - [ ] lotteryNum 만큼 반복해서 리스트/배열에 담는다. (List<List<Integer>> lotteries)
- [ ] 기능 3: 당첨 번호를 입력한다.
  - [ ] 1 이상, 45 이하인 6개의 숫자들을 한 리스트/배열에 담는다.(List<Integer> jackpot)
  - [ ] 입력된 숫자 중 1 이상, 45 이하가 아닌 수가 있다면 ***예외 사항 1***에 해당한다.
  - [ ] 당첨 번호가 쉼표로 구분되어 있지 않거나, 6개가 아닐 경우 ***예외 사항 2***에 해당한다.
- [ ] 기능 4: 보너스 번호를 입력한다.
  - [ ] 1 이상, 45 이하인 1개의 숫자를 보너스 번호로 선언(int bonus) 및 당첨 번호에 추가
  - [ ] 입력된 숫자가 1 이상, 45 이하가 아닌 수라면 ***예외 사항 1***에 해당한다.
  - [ ] 입력된 보너스 번호가 당첨 번호 중에 중첩되는 번호가 있다면 ***예외 사항4***에 해당한다.
- [ ] 기능 5: 당첨 통계를 도출한다.
  - [ ] 각 lottery와 jackpot의 숫자들 중 몇 개가 동일한지 카운트해서 리스트/배열에 추가한다. (List<Integer> matches)
  - [ ] 총 당첨 금액을 변수로 선언한다. (int prize)
  - [ ] prize / budget * 100 을 계산하여 수익률로 선언한다. (float earningRate)
  - [ ] earningRate는 소수점 둘째 자리에서 반올림하여 반환한다.

- 예외 사항:
  - [ ] 예외 사항 1: 입력된 당첨 번호가 로또 번호 범위 바깥의 값이거나 숫자(int)가 아닐 경우
  - [ ] 예외 사항 2: 입력된 구입 금액이 **개당 금액**으로 나누어 떨어지지 않을 경우
  - [ ] 예외 사항 3: 입력된 당첨 번호들이 쉼표로 구분되어 있지 않거나, 숫자가 아니거나, 숫자가 6개가 아닐 경우

### 요구 사항
- [ ] unit test must be driven(also TDD)
- [ ] indent depth must be less than 3
- [ ] 1 method/function, 1 task
  - methods have to be less than 15 lines
- [ ] do not use ELSE
- [ ] apply **Java Enum**
- [ ] UI and business logics have to be separately written.
  - Application has UI logics only
  - Lotto has Business logics only
- [ ] do not use ternary operators
- [ ] cannot add field(Instance variable) to Lotto class - use static always: 
  - Instance variable is non-static variables, which is defined in a class outside any method