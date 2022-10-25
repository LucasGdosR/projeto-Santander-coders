public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        System.out.println("Bem vindo! Vamos converter temperaturas em uma unidade para outra unidade!");
        System.out.println("Informe quantas temperaturas deseja converter: ");
        int numberOfCycles = input.getNumberOfCycles();
        if (numberOfCycles < 1) {
            System.out.println("Tudo bem, volte quando quiser converter uma quantidade positiva!");
            return;
        }
        System.out.println("Informe qual é a unidade da temperatura original (Celsius, Fahrenheit, ou Kelvin). Opções 'C', 'F', ou 'K': ");
        String originalUnit = input.getUnitOfMeasure();
        System.out.println("Informe qual é a unidade da temperatura final (Celsius, Fahrenheit, ou Kelvin). Opções 'C', 'F', ou 'K': ");
        String finalUnit = input.getUnitOfMeasure();
        double originalTemperatureSum = 0;
        double convertedTemperatureSum = 0;
        for(int i = 0; i < numberOfCycles; i++) {
            System.out.println("Informe o número da temperatura original. São permitidas casas decimais: ");
            double originalTemperature = input.getTemperature();
            TemperatureConverter converter = new TemperatureConverter();
            double convertedTemperature = converter.convert(originalUnit, finalUnit, originalTemperature);
            originalTemperatureSum += originalTemperature;
            convertedTemperatureSum += convertedTemperature;
            System.out.println("A temperatura passada é " + originalTemperature + " º" + originalUnit + ".");
            System.out.println("A conversão é " + convertedTemperature + " º" + finalUnit + ".");
        }
        input.close();
        System.out.println("A média das temperaturas é " + originalTemperatureSum/numberOfCycles + " º"
                           + originalUnit + " ou " + convertedTemperatureSum/numberOfCycles + " º" + finalUnit + ".");
    }
}