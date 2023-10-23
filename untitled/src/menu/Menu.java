package menu;

import entities.Account;
import services.LoginService;
import services.RegisterSevice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Menu {
    int select;

    public void menuDisplay(Scanner scanner, ArrayList<Account> accounts, LoginService login, RegisterSevice register, Account account) {
        while (true) {
            System.out.println("===== MENU =====");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký");
            System.out.println("0. Exit");
            System.out.print("Chọn: ");
            select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("Kết thúc chương trình");
                break;
            }
            menu(scanner, accounts, login, register,account);
        }
    }

    public void menu(Scanner scanner, ArrayList<Account> accounts, LoginService login, RegisterSevice register, Account account) {
        switch (select) {
            case 1:
                login.login(scanner, accounts, login, register, account);
                break;
            case 2:
                register.register(scanner, accounts,account);
        }
    }

    public void menuLoginDisplay(Scanner scanner, ArrayList<Account> accounts, LoginService loginService, RegisterSevice register,  Account account) {

        while (true) {
            System.out.println("===== MENU ĐÃ ĐĂNG NHẬP =====");
            System.out.println("1. Thay đổi username");
            System.out.println("2. Thay đổi email");
            System.out.println("3. Thay đổi password");
            System.out.println("4. Đăng xuất");
            System.out.println("0. Exit");
            System.out.print("Chọn: ");
            select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("kết thúc chương trình");
                break;

            }
            menuLogin(scanner,accounts,loginService,register, account);
        }
    }

    public void menuLogin(Scanner scanner, ArrayList<Account> accounts, LoginService loginService, RegisterSevice register,  Account account) {
        {
            switch (select) {
                case 1:
                    loginService.changeUsername(scanner, accounts);
                    break;
                case 2:
                    loginService.changeEmail(scanner, accounts);
                    break;
                case 3:
                    loginService.resetPassword(scanner, accounts, loginService, register);
                    break;
                case 4:
                    System.out.println("Đăng xuất thành công");
                    menuDisplay(scanner, accounts, loginService, register, account);

            }
            while (select == 0) ;


        }


    }
}

