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
            double convertedTemperature = 0;

            TemperatureConverter converter = new TemperatureConverter();
            if (originalUnit.equals("C")) {
                switch (finalUnit) {
                    case "F" -> convertedTemperature = converter.celsiusToFahrenheit(originalTemperature);
                    case "K" -> convertedTemperature = converter.celsiusToKelvin(originalTemperature);
                    case "C" -> convertedTemperature = originalTemperature;
                }
            } else if (originalUnit.equals("F")) {
                switch (finalUnit) {
                    case "C" -> convertedTemperature = converter.fahrenheitToCelsius(originalTemperature);
                    case "K" -> convertedTemperature = converter.fahrenheitToKelvin(originalTemperature);
                    case "F" -> convertedTemperature = originalTemperature;
                }
            } else {
                switch (finalUnit) {
                    case "C" -> convertedTemperature = converter.kelvinToCelsius(originalTemperature);
                    case "F" -> convertedTemperature = converter.kelvinToFahrenheit(originalTemperature);
                    case "K" -> convertedTemperature = originalTemperature;
                }
            }
            originalTemperatureSum += originalTemperature;
            convertedTemperatureSum += convertedTemperature;
            // A grafia correta de graus Celsius e graus Farenheit é com o símbolo °
            // Esse símbolo é incorreto com Kelvin, por isso os "if" abaixo. É uma formalidade.
            System.out.println("A temperatura passada é " + originalTemperature + " º" + originalUnit + ".");
            System.out.println("A conversão é " + convertedTemperature + " º" + finalUnit + ".");
        }
        input.close();
        System.out.println("A média das temperaturas é " + originalTemperatureSum/numberOfCycles + " º"
                           + originalUnit + " ou " + convertedTemperatureSum/numberOfCycles + " º" + finalUnit + ".");
    }
}