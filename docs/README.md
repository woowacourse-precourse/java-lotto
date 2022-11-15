## 🚀 Domain Modeling
### Domain
- Calculator: 수익률 계산
- Lottery(enum): 1등 ~ 6등마다 금액, 메시지 상수 저장
- LotteryMachine: 로또 복권 결과 확인, 당첨 번호/보너스 번호 저장
- Lotto: 랜덤 6자리 오름차순 로또 번호 생성 및 저장
- Seller: 로또 복권 판매

### UI
- Reader: 콘솔 입력 담당
- Writer: 콘솔 출력 담당

### Util
- Constants: 공통 상수 저장
- ErrorMessage: 에러 메시지 저장

## 🚝 Function Specification
- 로또 구매
  - 구입 금액 입력
  - 구입 금액 유효성 검증: 숫자 여부
  - 랜덤 6자리 번호 생성
- 당첨 번호 설정
  - 당첨 번호 입력
  - 당첨 번호 유효성 검증: 숫자 여부, 중복 여부, 6자리 여부, 1 ~ 45 여부
- 보너스 번호 설정
  - 보너스 번호 입력
  - 보너스 번호 유효성 검증: 숫자 여부, 중복 여부, 1 ~ 45 여부
- 당첨 통계 생성
  - 로또 번호 일치 결과 계산
  - 수익률 계산
  - 당첨 통계 출력
