## 기능 구현 목록

### LottoManager

- run: 전체 로또 프로그램 실행
- buyLotto: 로또 구매 로직
- getWinNumberInput: 당첨번호 입력받기
- winStatus: 당첨결과 발표
- getAffordableLottoCount: 금액을 통해 살 수 있는 로또 개수 반환
- pickNumbers: 살 수 있는 로또 개수 만큼 로또 번호 반환
- calculateWins: 로또 당첨 판단
- getGrade: 로또 번호를 당첨 번호와 대조해 결과 반환
- getWinCount: 여러개의 로또 결과를 입력받아 등수 별 카운트 반환
- gradeByHitCount: 맞춘 개수로 등수 얻기
- getPrizeMoney: 상금 계산
- calculateRatio: 수익률 반환

### InputView

- inputMoney: 금액 입력받기
- inputWinNumbers: 당첨번호 입력받기
- inputBonusNumber: 보너스 번호 입력받기

### OutputView

- announceInputMoney: 금액 입력 요구 메시지
- announceBuyResult: 몇개의 로또를 구매했는지 알려주는 메시지
- announceInputWinNumber: 당첨번호 입력 요구 메시지
- announceInputBonusNumber: 보너스번호 입력 요구 메시지
- announceResult: 당첨 통계 발표 메시지
- printBoughtLotto: 구매한 로또의 번호 출력
- printLottoNumbersInFormat: 형식에 맞게 로또번호 출력
- printWinCount: 등수별 개수 출력
- printProfitRatio: 수익률 출력
- printDivider: 구분선 출력
- printSpacer: 공백 출력

### Validation

- validationMoneyInput: 금액 입력 유효성 검사
- validateWinNumberInput: 당첨번호 유효성 검사
- validateBonusNumberInput: 보너스 번호 유효성 검사
- checkBonusNumberAlreadyPicked: 보너스 번호가 당첨번호에 포함되어 있는지 확인
- validateStringIsNumeric: 문자열이 숫자로만 이뤄져있는지 확인
- validateNumberInBound: 범위 안에 숫자가 포함되어 있는지 확인
- validateDivideThousand: 1,000으로 나뉘는 수인지 확인

### RandomUtil

- pickLottoNumbers: 로또 번호 생성 유틸 메서드