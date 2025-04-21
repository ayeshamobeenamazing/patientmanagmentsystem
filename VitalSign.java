
package assignment3.models;


public class VitalSign {
   private int heartRate;
    private int oxygenLevel;
    private double temperature;
    private String bloodPressure;
// constructor
    public VitalSign(int heartRate, int oxygenLevel, double temperature, String bloodPressure) {
        this.heartRate = heartRate;
        this.oxygenLevel = oxygenLevel;
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
        
    }

    public int getHeartRate() {
        return heartRate;
    }

    public int getOxygenLevel() {
        return oxygenLevel;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }
    

    public void displayVitals() {
        System.out.println("Heart Rate: " + heartRate + " BPM");
        System.out.println("Oxygen Level: " + oxygenLevel + "%");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("blood pressure: " + bloodPressure + "mmhg");
    } 
}
