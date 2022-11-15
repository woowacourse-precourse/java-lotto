## 기능 목록

- [x] 로또 구입
  - [x] 구입 금액 입력 받기 - `getPurchaseMoney`
  - [x] 1장: 1000원으로 계산, 구입개수 구하기 - `purchaseLotto`
- [x] 로또 발행
  - [x] 중복되지 않는 숫자 6개 뽑기 - `generateLottoNumbers`
  - [x] 구입 개수만큼 반복
    - 발행 - `publishLottos`
- [x] 당첨 번호 추첨
  - [x] 중복되지 않는 숫자 6개 입력 받기 - `getWinningNumbers`
    - [x] 쉼표를 기준으로 입력 - `convertToList`
  - [x] 보너스 번호 숫자 1개 뽑기 - `convertToBonus`
- [ ] 당첨 통계
  - [ ] 로또 숫자와 당첨 번호를 비교, 일치하는 개수 구하기
  - [ ] 3개 ~ 6개 일치 개수 각각 출력
- [ ] 수익률 계산
  - [ ] 구입 금액과 수익 금액 비교



### 예외 처리

- [x] 로또 번호

  - [x] 로또 번호는 1부터 45 사이여야 한다.
    - "[ERROR] 로또 번호는 1부터 45 사이의 자연수여야 합니다."
  - [x] 로또 번호는 6개여야 한다.
    - "[ERROR] 로또 번호는 6개여야 합니다."

  - [x] 로또 번호에 중복이 없어야 한다.

    - "[ERROR] 로또 번호는 중복이 없어야 합니다."

- [x] 당첨 번호

  - [x] 당첨 번호는 로또 번호를 상속받는다.
    - 앞 6개 번호는 로또 번호와 동일하게 예외 처리
  
  - [x] 보너스 번호는 로또 번호와 중복될 수 없다. - `validateBonus`
    - "[ERROR] 보너스 번호는 로또 번호와 중복이 없어야 합니다."
  - [x] 보너스 번호는 1부터 45 사이여야 한다. - `validateBonus`
    - "[ERROR] 보너스 번호는 1부터 45 사이의 자연수여야 합니다."
  
- [x] 구입 금액

  - [x] 구입 금액은 자연수여야 한다. - `validatePurchaseMoney`
    - "[ERROR] 금액은 자연수여야 합니다"

  - [x] 구입금액은 1000원으로 나누어 떨어져야 한다. - `validatePurchaseMoney`
    - "[ERROR] 구입 금액은 1000의 배수여야 합니다."



### 테스트

- [ ] 단위 테스트

  - [x] 각 기능별로 테스트할 수 있어야 한다. - `runTest`
  - [x] 예외 발생 시, "[ERROR]" 문구를 포함해야 한다.

  

  - [x] UserInput

    - [x] 구입 금액 입력

      - [x] 구입 금액이 1000의 배수면 성공한다. - `purchaseMoney`
      - [x] 구입 금액이 자연수가 아니라면 예외가 발생한다. - `purchaseMoneyWithNotNaturalNumber`
      - [x] 구입 금액이 100의 배수가 아니라면 예외가 발생한다. - `purchaseMoneyWithNotDividableBy1000`

    - [x] 당첨 번호 입력

      - [x] 당첨 번호가 유효하다면 성공한다. -  `getValidWinningNumbers`

      - [x] 당첨 번호가 숫자가 아니라면 예외가 발생한다. - `getInvalidWinningNumbers`
      - [x] 보너스 번호가 숫자가 아니라면 예외가 발생한다 - `getInvalidWinningNumbersBonus`

  - [x] Lotto
    - [x] 로또 번호가 6개보다 적다면 예외가 발생한다. - `createLottoByUnderSize`
    - [x] 로또 번호가 6개가 넘어가면 예외가 발생한다. -  `createLottoByOverSize`
    - [x] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다. -  `createLottoByDuplicateNumber`
    - [x] 로또 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다. -  `createLottoByOutOfRangeNumber`
  - [x] WinningNumbers
    - [x] 로또 번호의 예외를 모두 포함한다.
    - [x] 보너스 번호에 중복된 숫자가 있으면 예외가 발생한다. - `createWinningNumbersByDuplicateNumber`
    - [x] 보너스 번호에 범위를 벗어나는 숫자가 있으면 예외가 발생한다. - `createWinningNumbersByOutOfRangeNumber`

- [ ] 통합 테스트
  - [ ] TBD



