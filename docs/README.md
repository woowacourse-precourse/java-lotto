# 흐름
|  | 구현 내용 | 예외 상황 | 비고                                        |
| --- | --- | --- |-------------------------------------------|
| 1 | 입력문 출력 |  | 구입금액을 입력해 주세요.                            |
| 2 | 로또 구매 금액 입력 받기 | 금액이 양수인지 확인, 1000원단위인지 확인 ? |                                           |
| 3 | 금액 / 1000만큼 로또 생성 | 1개의 로또에 중복없는 숫자가 6개인지 확인 | `List<Lotto>`                             |
| 4 | 구입 내역 출력 |  | 금액 / 1000개를 구매했습니다. 이후 출력                 |
| 5 | 입력문 출력 |  | 당첨 번호를 입력해 주세요.                           |
| 6 | 당첨번호 입력 받기 | 중복 없는 6개인지 확인, 1 ~ 45인지 확인 | `Set<Integer> winningNumbers`             |
| 7 | 입력문 출력 |  | 보너스 번호를 입력해 주세요.                          |
| 8 | 보너스 번호 입력 | 1 ~ 45인지 확인 | `int bonusNumber`                         |
| 9 | 당첨 계산 |  |                                           |
| 10 | 당첨내역 출력 |  | 3개 일치 ~ 6개 일치                             |
| 11 | 수익률 계산 |  |                                           |
| 12 | 수익률 출력 |  | 수익률 계산: (사용금액 / 당첨금액) * 100 소수 둘째자리에서 반올림 |

---

# 필요한 기능
`**util/Input**`
- [x]  금액을 입력받는 기능
- [x]  당첨 번호를 입력받는 기능
- [x]  보너스 번호를 입력받는 기능

`**util/Output**`
- [x]  로또 생성 내역을 출력하는 기능
- [x]  당첨 내역을 출력하는 기능
  - 3개 일치 ~ 6개 일치 순으로 출력
- [x]  수익률을 출력하는 기능
  - 이때, 3자리마다 ,도 함께 출력
- [x]  예외 처리 문구를 출력하는 기능

`**util/Validator**`
- [x]  입력받은 금액의 예외 상황을 확인하는 기능
  - 확인할 조건 : 양수 ?, 1000원 단위 ?
- [x]  보너스 번호 입력에 대한 예외 상황을 확인하는 기능
  - 확인할 조건 : 당첨번호 포함 ?, 양수 ?, 1 ~ 45 사이의 숫자 ?
- [x]  당첨 번호 입력에 대한 예외 상황을 확인하는 기능
  - 확인할 조건 : 양수 ?, 1 ~ 45 사이의 숫자 ?, 중복 ?

`**util/LottoGenerator**`
- [x]  로또를 생성하는 기능
  - 중복이 없는, 6개의 숫자를 생성
  - 각 로또 번호들은 오름차순으로 정렬되어 `List<Integer>` 로 저장

**`util/Calculator`**
- [x]  당첨 여부를 계산하는 기능
  - 로또 하나씩 확인하면서, 당첨 번호 포함 개수를 구하고, 보너스 번호 포함 여부를 계산
  - `3개 일치`, `4개 일치`, `5개 일치`, `5개 + 보너스 일치`, `6개 일치` 로 매핑
- [x]  당첨 금액을 계산하는 기능
- [x]  수익률을 계산하는 기능
  - `(당첨 금액 / 사용 금액) * 100`

**`error/ErrorMessage`**
- [x]  에러 메세지에 해당되는 문자열을 반환하는 기능

---

# 필요한 자료구조
- `util/Validator` 클래스 : 유효성 검사
  - `isNumber()`, `isPositive()`, `isHundredUnit()`, `isInRange()`, `isDuplicate()`
- `util/LottoGenerator` 클래스 : 로또 생성
  - `generate()`
- `util/Input` 클래스 : 입력 담당, 입력값에 대한 자료형 변환을 위한 유효성 검사 수행
  - `readMoney()`, `readWinningNumbers()`, `readBonusNumber()`
- `util/Output` 클래스 : 출력 담당
  - `printInputMessage()`, `printBuyMessage()`, `printLottos()`, `printInputWinnings()`, `printInputBonus()`, `printStatistics()`, `printYield()`, `printException()`
- `util/Calculator` 클래스 : 당첨 결과, 수익률 계산 수행
  - `Map<Result, Integer> resultCount`, `int earn`
  - `calculateResult()`, `calculateEarn()`, `initializeMap()`, `stringToInt()`, `calculateYield()`

- `domain/Lotto` 클래스 : 사용자의 로또 1개를 저장, 관련 로직 수행
  - `List<Integer> numbers`
  - `computeResult()`, `makeString()`
- `domain/NumberBox` 클래스 : 당첨 번호, 보너스 번호를 저장, 관련 로직 수행
  - `Set<Integer> winningNumbers`, `int bonusNumber`
  - `validate()`, `validate()`
- `domain/User` 클래스 : 구입 금액, 사용자 구매 로또 리스트 생성 및 저장
  - `int money`, `List<Lotto> lottos`
  - `validate()`, `buyLottos()`
- `domain/Result` enum : 로또 결과 관련 로직 수행
  - `THREE("3개 일치", "5,000", 30)`
  - `FOUR("4개 일치", “50,000", 40)`
  - `FIVE(”5개 일치”, “1,500,000”, 50)`
  - `FIVEWITHBONUS(”5개 일치, 보너스 볼 일치", “30,000,000”, 51)`
  - `SIX(”6개 일치”, “2,000,000,000”, 60)`
  - `computeScore()`

- `error/ErrorMessage` 클래스 : 에러 메세지를 enum으로 정의
  - `getMessage()`