import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        Account account = new Account();
        Bank bank = new Bank();
        Customer customer=null;

        //메인화면(메뉴) - 필요한 기능 호출
        while(true) {
            System.out.println("  === 라이온 은행 시스템 ===");
            System.out.println("1. 회원등록\n2. 계좌생성\n3. 보유계좌\n4. 입금\n5. 출금\n6. 잔액조회\n7. 종료");
            System.out.println("  ```");
            int menu=scanner.nextInt();

            String accountNum="";

            switch(menu){
                case 1:
                    try{
                        customer = bank.saveCustomer();
                        System.out.println("회원등록이 완료되었습니다. : "+customer.getId());
                    } catch(Exception.BankOperationException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        accountNum=bank.makeAccount(customer.getId());
                        System.out.println("계좌번호가 생성되었습니다 : "+accountNum);
                    } catch(Exception.BankOperationException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        System.out.println("  보유계좌\n   =============");
                        System.out.println(Arrays.toString(customer.getAccountNum()));
                        System.out.println("   =============");
                    } catch(Exception.BankOperationException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        account.deposit(accountNum);
                    } catch(Exception.InvalidTransactionException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        account.withdraw(accountNum);
                    }catch(Exception.InvalidTransactionException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        bank.checkBalance(accountNum);
                        System.out.println("잔액 : " + bank.checkBalance(accountNum));
                    } catch(Exception.AccountNotFoundException e){
                        System.err.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.err.println("잘못된 메뉴 선택입니다. 1~7 사이의 메뉴를 선택해주세요.");
                    break;
            }
        }
    }
}

