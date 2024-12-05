package application;

import entities.Contract;
import services.ContractService;
import services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {

        public static void main(String[] args) {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter contract data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.println("Date (dd/MM/yyyy): ");
            LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println("Contract value: ");
            double totalValue = sc.nextDouble();

            Contract contract = new Contract(number, date, totalValue);

            System.out.println("Enter number of installments: ");
            int n = sc.nextInt();

            ContractService contractservice = new ContractService(new PaypalService());

            ContractService.processContract(contract, n);

            System.out.println("Installments: ");
            for (int i = 0; i < contract.getInstalments().size(); i++) {
                System.out.println(contract.getInstalments().get(i));
            }


            sc.close();



        }
}
