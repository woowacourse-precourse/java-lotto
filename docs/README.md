## 기능 구현 목록

### LottoManager
- run: 전체 로또 프로그램 실행
- buyLotto: 입력된 금액으로 살 수 있는 로또 개수 반환
- pickNumbers: 살 수 있는 로또 개수 만큼 로또 번호 반환
- calculateWins: 로또 당첨 판단
- calculateRatio: 수익률 반환

### InputView
- inputNumber: 1개의 숫자 입력 받기
- inputNumbers: ,(콤마)로 구분된 여러 개의 숫자 입력 받기

### OutputView
- announceInputMoney: 금액 입력 요구 메시지
- announceBuyResult: 몇개의 로또를 구매했는지 알려주는 메시지
- printBoughtLotto: 구매한 로또의 번호 출력
- announceInputBonusNumber: 보너스 번호 입력 요구 메시지
- announceResult: 당첨 통계 발표 메시지
- printDivider: 구분선 출력
- printSpacer: 공백 출력

### Validation
- validateWinNumberInput: 당첨번호 유효성 검사 
- validateNumberInput: 숫자 입력 유효성 검사
- validateBonusNumberInput: 보너스 번호 유효성 검사

### RandomUtil
- pickLottoNumbers: 로또 번호 생성 유틸 메서드