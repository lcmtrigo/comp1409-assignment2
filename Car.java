
/**
 * Tested with Assignment1Tester to earn bonus marks
 * 
 * @author Ramon Trigo
 * @version 1.0
 */
public class Car
{
    // instance variables - replace the example below with your own
    private String licensePlate;
    private char transmissionType;
    private double odometerInKm;
    private int minutesParked;
    
    // symbolic constants
    private static final int MINIMUM_PLATE_LENGTH = 2;
    private static final int MAXIMUM_PLATE_LENGTH = 7;
    public static final char MANUAL_TRANSMISSION = 'm';
    public static final char AUTOMATIC_TRANSMISSION = 'a';
    public static final double DEFAULT_ODOMETER_KM = 50000.5;
    public static final int DEFAULT_MINUTES_PARKED = 0;
    

    /**
     * Non-default constructor
     * 
     * Set transmission type to 'a', odometer instance variable to 50000.5, and minutesParked to 0.
     * 
     * @param proposedLicense String validated for assignment to licensePlate.
     */
    public Car(String proposedLicense)
    {
        setLicensePlate(proposedLicense);
        setTransmissionType(AUTOMATIC_TRANSMISSION);
        odometerInKm = DEFAULT_ODOMETER_KM;
        minutesParked = DEFAULT_MINUTES_PARKED;
    }
    
    
    
    /**
     * Accessor: licencePlate
     * 
     * @return licensePlate String
     */
    public String getLicensePlate() 
    {
        return licensePlate;
    }
    
    /**
     * Accessor: transmissionType
     * 
     * @return transmissionType char
     */
    public char getTransmissionType() 
    {
        return transmissionType;
    }
    
    
    /**
     * Accessor: minutesParked
     * 
     * @return minutesParked int
     */
    public int getMinutesParked() 
    {
        return minutesParked;
    }
    
    /**
      * Mutator: licensePlate
      * 
      * @param proposedLicense String conforming to ICBC length guidelines: 
      * http://www.icbc.com/vehicle-registration/licence-plates/pages/personalized-licence-plates.aspx
      * 
      * May also be null. The null value represents a car without a plate. 
      * If validation fails, null will be set.
      */
    public void setLicensePlate(String proposedLicense)
    {
        if((proposedLicense != null) && (proposedLicense.length() >= MINIMUM_PLATE_LENGTH && 
            proposedLicense.length() <= MAXIMUM_PLATE_LENGTH)) {
            licensePlate = proposedLicense;
        } else {
            licensePlate = null;
        }
    }
    
  
    /**
      * Mutator: transmissionType
      * 
      * Must be either 'm' or 'a'. If validation fails, an error message will be printed 
      * to the console.
      * 
      * @param mOrA char denotes either manual or automatic transmissions
      */
    public void setTransmissionType(char mOrA)
    {
        if(mOrA == 'm' || mOrA == 'a')
        {
            transmissionType = mOrA;
        } else {
            System.out.printf("Installation failure: '%s' is not a valid transmission type.\n", mOrA);
        }
    }
    
    /**
     * Accessor: odometerInKm
     * 
     * @return odometerInKm + " kilometers" as String
     */
    public String readOdometer()
    {
        return odometerInKm + " kilometers";
    }
    
    /**
     * Interpreter for minutesParked
     * 
     * @return true when minutesParked == 0. false under all other conditions.
     */
    public boolean isParked()
    {
        if(minutesParked == 0) 
        {
            return false;
        } else {
            return true;
        }
    }
    
    /**
     * Mutator: minutesParked
     * 
     * @param duration - the amount of time (minutes) the car was parked.
     */
    public void park(int duration)
    {
        if(duration > DEFAULT_MINUTES_PARKED) {
            minutesParked = duration;
        } else if (duration == DEFAULT_MINUTES_PARKED) {
            minutesParked = DEFAULT_MINUTES_PARKED;
        } else {
            return;
        }
    }
}
