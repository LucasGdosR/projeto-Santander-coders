public class TemperatureConverter {
    private final double FATOR_MULT = 9.0/5.0;
    private final int FATOR_SOMA = 32;
    private final int FATOR_KELVIN = 273;

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * FATOR_MULT) + FATOR_SOMA;
    }

    public double celsiusToKelvin(double celsius) {
        return celsius + FATOR_KELVIN;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - FATOR_SOMA) / FATOR_MULT;
    }

    public double fahrenheitToKelvin(double fahrenheit) {
        return celsiusToKelvin(fahrenheitToCelsius(fahrenheit));
    }

    public double kelvinToCelsius(double kelvin) {
        return kelvin -FATOR_KELVIN;
    }

    public double kelvinToFahrenheit(double kelvin) {
        return celsiusToFahrenheit(kelvinToCelsius(kelvin));
    }

    public double convert(String originalUnit, String finalUnit, double originalTemperature) {
        double convertedTemperature = 0;
        if (originalUnit.equals("C")) {
            switch (finalUnit) {
                case "F" -> convertedTemperature = celsiusToFahrenheit(originalTemperature);
                case "K" -> convertedTemperature = celsiusToKelvin(originalTemperature);
                case "C" -> convertedTemperature = originalTemperature;
            }
        } else if (originalUnit.equals("F")) {
            switch (finalUnit) {
                case "C" -> convertedTemperature = fahrenheitToCelsius(originalTemperature);
                case "K" -> convertedTemperature = fahrenheitToKelvin(originalTemperature);
                case "F" -> convertedTemperature = originalTemperature;
            }
        } else {
            switch (finalUnit) {
                case "C" -> convertedTemperature = kelvinToCelsius(originalTemperature);
                case "F" -> convertedTemperature = kelvinToFahrenheit(originalTemperature);
                case "K" -> convertedTemperature = originalTemperature;
            }
        }
        return convertedTemperature;
    }
}
