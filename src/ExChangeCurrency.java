import com.sun.org.apache.xpath.internal.objects.XObject;

import java.sql.DatabaseMetaData;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExChangeCurrency {
    public static void main(String[] args) {

        ExChangeAPI ex = new ExChangeAPI();
        //getconnection with "USD"
        if (ex.getConnection("USD"));{
            System.out.println(ex.getResult());
        }
        System.out.println(ex.getEachRate());
        System.out.println(ex.getEachRate("THB"));

        Scanner scanner = new Scanner(System.in);



        try {
            System.out.println("#### Currency EXchange System ####");
            System.out.print("Please,enter your current currency: ");
            String currentCurrency = scanner.nextLine();
            if (ex.getConnection(currentCurrency) == false)
                System.out.println("Sorry we can't find this currency rate.");
            else {
                System.out.print("Amount: ");
                double amount = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter new currency: ");
                String newCurrency = scanner.nextLine();

                double rate = ex.getEachRate(newCurrency);

                System.out.println("\nExchange"+currentCurrency+"to"+newCurrency);
                System.out.println("\t"+currentCurrency+": "+amount);
                System.out.println("\t"+newCurrency+": "+(amount*rate));
            }
        }catch (InputMismatchException e) {
            e.printStackTrace();
        }

    }
}
