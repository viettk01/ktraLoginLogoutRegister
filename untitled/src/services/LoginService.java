package services;

import entities.Account;
import menu.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginService {
    int select;
    Menu menuReturn = new Menu();

    public void login(Scanner scanner, ArrayList<Account> accounts, LoginService loginService, RegisterSevice registerSevice, Account account) {
        RegisterSevice registerSevice1 = new RegisterSevice();
        System.out.println("Đăng Nhập");
        System.out.print("Nhập username: ");
        String username = scanner.nextLine();
        System.out.print("Nhập password: ");
        String password = scanner.nextLine();

        boolean found = false;
        for (Account login : accounts) {
            if (login.getUsername().equals(username)) {
                found = true;
                if (login.getPassword().equals(password)) {
                    System.out.println("Chào mừng " + username + " mời bạn thực hiện các công việc sau:");
                    menuReturn.menuLoginDisplay(scanner, accounts, loginService, registerSevice, account);
                } else {
                    System.out.println("Mật khẩu không chính xác vui lòng lựa chọn");
                    fogetPassword(scanner, accounts, loginService, registerSevice, account);
                }
                break;
            }
        }
        if(!found){
            System.out.println("Tài khoản không tồn tại mời bạn đăng kí");
            registerSevice1.register(scanner,accounts,account);
        }
    }


    public void fogetPassword(Scanner scanner, ArrayList<Account> accounts, LoginService loginService, RegisterSevice registerSevice, Account account) {
        System.out.println("1. Đăng nhập lại");
        System.out.println("2. Quên mật khẩu");
        select = Integer.parseInt(scanner.nextLine());
        switch (select) {
            case 1:
                login(scanner, accounts, loginService, registerSevice, account);
                break;
            case 2:
                resetPassword(scanner, accounts, loginService, registerSevice);
        }
    }

    public void resetPassword(Scanner scanner, ArrayList<Account> accounts, LoginService loginService, RegisterSevice registerSevice){
        System.out.println("Nhập email để thực hiện thay đổi mật khẩu");
        String email = scanner.nextLine();
        Menu menuReturn = new Menu();
        for (Account account : accounts){
            if (account.getEmail().equals(email)){
                System.out.println("Nhập mật khẩu mới (theo dạng có in hoa, chữ thường, số, kí tự đặc biệt (từ 7-15 kí tự))");
                String newPassword = scanner.nextLine();
                if(!Account.validatePassword(newPassword)){
                    System.out.println("Mật khẩu không hợp lệ mời bạn nhập lại đúng định dạng yêu cầu");
                    newPassword = scanner.nextLine();

                }

                account.setPassword(newPassword);
                accounts.add(account);
                System.out.println("Mật khẩu đã được thay đổi");
                System.out.println("Chào mừng " + account.getUsername() + " mời bạn thực hiện các công việc sau");
                menuReturn.menuLoginDisplay(scanner,accounts,loginService,registerSevice, account);
                break;
            } else {
                System.out.println("Email sai vui lòng kiểm tra lại");
                break;
            }
        }
    }


    public void changeUsername(Scanner scanner, ArrayList<Account> accounts) {
        System.out.println("Mời bạn nhập username mới");
        String usernameChange = scanner.nextLine();
        for (Account account : accounts) {
            if (account.getUsername().equals(usernameChange)){
                System.out.println("Username đã tồn tại");
                System.out.println("mời bạn nhập lại username mới");
                usernameChange = scanner.nextLine();
                if (account.getUsername().equals(usernameChange)){
                    return;
                }
            }
                account.setUsername(usernameChange);
                System.out.println("Username đã được thay đổi");
                break;
        }
    }

    public void changeEmail(Scanner scanner, ArrayList<Account> accounts) {
        System.out.println("Mời bạn nhập email mới");
        String emailChange = scanner.nextLine();
        if(!Account.validateEmail(emailChange)){
            System.out.println("Email không hợp lệ");
            return;
        }
        for (Account account : accounts) {
            if (account.getEmail().equals(emailChange)){
                System.out.println("Email đã tồn tại");
                return;
            } else {
                account.setEmail(emailChange);
                System.out.println("Email đã được thay đổi");
                break;
            }

        }
    }


}