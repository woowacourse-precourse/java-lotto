# 기능 목록
1. 로또 구매
   - 로또 가격 1000원
   - 한 장당 중복 없는 랜덤 번호 6개 생성하여 리스트에 저장
   - 구매한 로또 총액 저장
   - View를 통해 한 장당 리스트 출력
2. 당첨 번호 및 보너스 번호 입력
    - 당첨번호 5개 입력
    - 보너스 번호 입력
    - 1 ~ 45 범위 벗어나면 예외처리
    - 당첨 번호와 보너스 번호 중복 시 예외처리
3. 당첨 확인 및 통계
   - 한장씩 당첨 번호 카운팅
   - 전체 수익금 계산
   - 수익률 계산
   - View를 통해 출력


# 구현 목록
1. Domain
   - Lotto
     - 당첨 번호 6개 + 보너스 번호 1개 입력 후 저장
   - User
     - 로또 구매 및 저장, 구매 금액과 총 수익금 관리
   - UserLotto
     - 유저가 구입한 로또 번호 담긴 클래스
2. Enum
   - WinningLotto
     - 로또 당첨 등수
3. Util
   - GenerateLottoNumbers
     - 유저가 로또 구매시 번호 추출 및 정렬
   - LottoUtil
     - 입력된 6개의 당첨 번호를 ',' 기준으로 split하고 List로 번호 반환
     - 보너스 번호는 int 형으로 반환
   - inputUtil
     - String 타입의 숫자를 int 타입으로 변환
4. Exception
   - UserBuyingException
     - 입력된 로또 구입 금액 1,000단위 아닐 시 예외 처리
   - LottoException
     - 6개의 번호가 중복인지
     - 1 ~ 45 사이의 숫자인지
     - 로또 번호 6개 입력했는지
     - 보너스 번호 1개인지
     - 보너스 번호가 중복인지
5. Service
   - UserInputDataService
     - View를 통해 유저의 로또 구매 진행, 정보 반환
   - LottoInputDataSevice
     - View를 통해 로또 당첨 번호와 보너스 번호 입력, 정보 반환
   - LottoCalculateService
     - 로또 당첨 확인 및 통계
     - 계산값 출력
6. Controller
   - LottoController
     - Service를 통해 로또의 구입 및 입력, 출력 명령
7. View
   - InputView
     - 유저의 구입 금액 입력
     - 로또 당첨 번호 및 보너스 번호 입력
   - OutputView
     - 로또 구매 후 장당 랜덤 생성 번호 출력
     - 당첨 통계 출력
     