package Algorithm;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class DifferentialEquation {
    private int N;
    private int a;
    private int b;
    private double y0;
    private double h;
    private double[] exactSolutionArray;

    public DifferentialEquation(int n, int a, int b, double y0) {
        this.N = n;
        this.a = a;
        this.b = b;
        this.y0 = y0;
        this.h = ((double)b - a) / n;

        exactSolutionArray = new double[N];


        //Exact equation solution
        for (int i = 0; i < N; i++) {
            //exactSolutionArray[i] = a + (i+1) * h;
            //exactSolutionArray[i] = pow(exactSolutionArray[i],2) + exactSolutionArray[i] + 1;
            exactSolutionArray[i] = pow(exactSolutionArray[i],2) + exactSolutionArray[i] - 1;
            exactSolutionArray[i] = pow(exactSolutionArray[i],6) + 4 * pow(exactSolutionArray[i],4) - pow(exactSolutionArray[i],2) + 2;
        }
    }

    public void solutionPrecision (double[] y){
        for (int i=0; i < N; i++)
        {
            System.out.println(abs(y[i] - exactSolutionArray[i]));
        }
    }

    public double solveFunction(double x, double y) {
        //double sqrtx = y - x - 1;
        //return 1 + 2 * pow(sqrtx,0.5);
        double sqrtx = pow(x,6) + 4 * pow(x,4) + 2 - y;
        return 6 * pow(x,5) + 16 * pow(x,3) - 2 * pow(sqrtx,0.5);
    }

    public double[] eulerMethod() {
        double x = this.a;
        double[] y = new double[this.N];

        y[0] = y0 + h * solveFunction(x,y0);
        x += h;

        for(int i=1; i < N; i++){
            y[i] = y[i-1] + h * solveFunction(x,y[i-1]);
            x += h;
        }
        return y;
    }

    public double[] modifiedEulerMethod() {
        double x = this.a;
        double[] y = new double[this.N];
        y[0] = y0 + h * solveFunction(x + h/2,y0 + h/2 * solveFunction(x,y0));
        x += h;
        for (int i = 1; i < N; i++) {
            y[i] = y[i-1] + h * solveFunction(x + h/2,y[i-1] + h/2 * solveFunction(x,y[i-1]));
            x += h;
        }
        return y;
    }

    public double[] heunMethod() {
        double x = this.a;
        double[] y = new double[this.N];
        y[0] = y0 + h/2 * (solveFunction(x,y0) + solveFunction(x + h, y0 + h * solveFunction(x,y0)));
        x += h;
        for (int i = 1; i < N; i++) {
            y[i] = y[i-1] + h/2 * (solveFunction(x,y[i-1]) + solveFunction(x + h, y[i-1] + h * solveFunction(x,y[i-1])));
            x += h;
        }
        return y;
    }
}
