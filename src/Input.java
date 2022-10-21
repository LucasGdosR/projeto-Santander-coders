import java.util.Scanner;

public class Input {
    private final Scanner sc;
    public Input() {
        this.sc = new Scanner(System.in);
    }

    public String getUnitOfMeasure() {
        while (true) {
            String unitOfMeasure = this.sc.nextLine();
            if (unitOfMeasure.equals("C") || unitOfMeasure.equals("F") || unitOfMeasure.equals("K")) {
                return unitOfMeasure;
            }
        }
    }

    public double getTemperature() {
        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida. Exemplo válido: 38");
            sc.next();
        }
        return sc.nextDouble();
    }

    public int getNumberOfCycles(){
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Exemplo válido: 2");
            sc.next();
        }
        return sc.nextInt();
    }
    public void close() {
        sc.close();
    }

}
