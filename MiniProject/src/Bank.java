import java.util.Random;
import java.util.Scanner;

class Bank {
    //회원등록, 계좌번호로 잔액조회, 계좌번호 유무 검사 클래스
    Customer[] customers = new Customer[100];
    //계좌번호, 잔액, ID
    private int count = 0; // 현재 등록된 고객 수

    public Customer saveCustomer() { // 고객 등록 메소드
        // 아이디 입력받아 고객 배열에저장 후 계좌번호 생성, 배열에 저장
        Scanner scanner=new Scanner(System.in);
        System.out.print("아이디를 입력해주세요. : ");
        String id=scanner.nextLine();

        //아이디 입력받고 배열에 저장하는 작업
        for(int i=0;i<count;i++){ //중복검사
            if(customers[i].getId().equals(id)){
                throw new Exception.BankOperationException(id+"는 이미 존재하는 아이디입니다: ");
            }
        }

        Customer newCustomer=new Customer(id);
        customers[count] = newCustomer; //초기생성 : 계좌 아직 개설x, 잔액 0원
        count++;
        
        if(count>=100){ //100명 제한
            throw new Exception.BankOperationException("등록가능한 고객 수를 초과했습니다.");
        }
        return newCustomer;
    }

    public String makeAccount(String id){ //계좌생성
        Random random = new Random();
        StringBuilder accountNum = new StringBuilder();
        Customer customer = findCustomerById(id); //아이디로 고객찾기

        if(customer.getAccountCount()>=5){
            throw new Exception.BankOperationException("계좌는 최대 5개까지 추가 가능합니다.");
        }
        //13자리 랜덤계좌 생성
        for(int i=0;i<13;i++){
            accountNum.append(random.nextInt(10));
        }
        customer.addAccountNum(accountNum.toString());
        return accountNum.toString();
    }

    public double checkBalance(String accountNum) { //계좌번호로 잔액조회
        for (int i = 0; i < count; i++) {
            String[] accounts = customers[i].getAccountNum();
            for (int j = 0; j < customers[i].getAccountCount(); j++) {
                if (accounts[j].equals(accountNum)) {
                    return customers[i].getBalance();
                }
            }
        }
        throw new Exception.AccountNotFoundException("존재하지 않는 계좌입니다. : " + accountNum);
    }
    
    public Customer findCustomer(String accountNum){ //계좌번호로 고객 객체 찾기
        for(int i=0;i<count;i++){
            String[] accounts = customers[i].getAccountNum(); // 고객이 가진 계좌 배열 가져오기
            for (int j = 0; j < customers[i].getAccountCount(); j++) {
                if (accounts[j].equals(accountNum)) { // 계좌번호가 일치하면 해당 고객 반환
                    return customers[i];
                }
            }
        }
        throw new Exception.AccountNotFoundException("존재하지 않는 계좌입니다. : " + accountNum);
    }
    public Customer findCustomerById(String id) { //아이디로 고객 객체 찾기
        for (int i = 0; i < count; i++) {
            if (customers[i].getId().equals(id)) {
                return customers[i];
            }
        }
        throw new Exception.BankOperationException("아이디를 `찾을 수 없습니다 : " + id);
    }
}

