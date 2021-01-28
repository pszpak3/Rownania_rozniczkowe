import Algorithm.DifferentialEquation;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        int a;
        int b;
        double y0;


        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Podaj wartość N: ");
        N = scanner.nextInt();

        while(N<1)
        {
            System.out.println("Podaj prawidłowe dane: ");
            N = scanner.nextInt();
        }

        System.out.println("Określ podział odcinka (a): ");
        a = scanner.nextInt();

        System.out.println("Określ podział odcinka (b): ");
        b = scanner.nextInt();

        System.out.println("Podaj wartość y0: ");
        y0 = scanner.nextDouble();



        DifferentialEquation differentialEquation = new DifferentialEquation(N, a, b, y0);

        double[] eulerMethodArray = differentialEquation.eulerMethod();
        double[] modifiedEulerMethodArray = differentialEquation.modifiedEulerMethod();
        double[] heunMethodArray = differentialEquation.heunMethod();


        System.out.println("//METODA EULERA//");
        differentialEquation.solutionPrecision(eulerMethodArray);
        System.out.println();

        System.out.println("//ZMODYFIKOWANA METODA EULERA//");
        differentialEquation.solutionPrecision(modifiedEulerMethodArray);
        System.out.println();

        System.out.println("//METODA HEUNA//");
        differentialEquation.solutionPrecision(heunMethodArray);

    }
}