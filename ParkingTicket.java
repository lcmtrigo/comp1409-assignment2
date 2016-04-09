
/**
 * Write a description of class ParkingTicket here.
 * 
 * @author Ramon Trigo
 * @version A2
 */
public class ParkingTicket
{
   // instance variables - replace the example below with your own
   private final String referenceNumber;
   private final String carLicensePlate;
   private int carMinutesParked;
   private int meterMinutesPaid;
    
   // class variables
   public static int count = 1000;
    
   // constants
   public static final String PREFIX = "V";
   public static final double BASE_FINE = 20.0;
   public static final double PER_HOUR_OVERPARKED = 10.0;
   public static final int MINUTES_PER_HOUR = 60;
   public static final double GST_SURCHARGE = 1.05;

   /**
     * Non-default constructor
     * 
     * - Assigns (the prefix Symbolic Constant) + count to referenceNumber.
     * - increments count by 1
     * - Assigns the parameters to similarly-named instance variables.
     * 
     * @param recordedLicense the recorded driver's license
     * @param carParkedMinutes how many minutes the car was parked for
     * @param meterPaidMinutes how many minutes were paid for
     */
    private ParkingTicket(String recordedLicense, int carParkedMinutes, 
        int meterPaidMinutes)
    {
        // initialise instance variables
        this.referenceNumber = PREFIX + count;
        count++;
        carLicensePlate = recordedLicense;
        carMinutesParked = carParkedMinutes;
        meterMinutesPaid = meterPaidMinutes;
    }
    
   /**
     * Overloaded version of the previous constructor
     * 
     * @param parker the Car that is being parked
     * @param  parkee the meter at which it's being parked
     */
    private ParkingTicket(Car parker, ParkingMeter parkee) 
    {
        this(parker.getLicensePlate(),
            parker.getMinutesParked(),
            parkee.getMinutesPaid()
        );
    }
    
    /**
     * Gateway method. Checks if a car is overparked
     * 
     * @param  parker the car
     * @param parkee the meter
     * 
     * @return ticket a parking ticket if the car is overparked 
     * @return null under all other conditions.
     */
   public static ParkingTicket checkParking(Car parker, ParkingMeter parkee) 
    {
        if(parker != null && parkee != null) {
            if(parker.getMinutesParked() > parkee.getMinutesPaid()) {
                ParkingTicket ticket = new ParkingTicket(parker, parkee);
                return ticket;
            } else if (parker.getMinutesParked() <= parkee.getMinutesPaid()) {
                return null;
            }
        }
        return null;
    }
    
   /**
     * Calculates the fine for overparked cars. Returns 0 if the car is not overparked.
     * 
     * @param none
     * 
     * @return result the calculated fine for an overparked car
     */
   public double calculateFine() 
   {
       if(Math.abs(this.carMinutesParked) > Math.abs(this.meterMinutesPaid)) {
            return (BASE_FINE + 
               penalties(this.carMinutesParked, this.meterMinutesPaid) 
               ) * GST_SURCHARGE;
        } else if (Math.abs(this.carMinutesParked) <= Math.abs(this.meterMinutesPaid)) {
            return 0.0;
        } else {
            return 0.0;
        }
   }
   
   /**
     * Helper method for calculateFine. determines how much to add to the
     * base parking ticket fine.
     * 
     * @param minutesParked minutes the car has been parked for
     * @param minutesPaid minutes that were paid for
     * 
     * @return penalty added penalty for being overparked for more than an hour
     */
   public double penalties(double minutesParked, double minutesPaid) {
       double minutesOverparked = minutesParked - minutesPaid;
       double penalty = 0;
       
       if(minutesOverparked >= 0) {
           for (int i = 0; i <= minutesOverparked; i++) {
               if((i > 0) && (i % MINUTES_PER_HOUR == 0)) {
                   penalty += PER_HOUR_OVERPARKED;
                }
           }
       } else if (minutesOverparked < 0) {
           for (int i = 0; i >= minutesOverparked; i--) {
               if((i < 0) && (i % MINUTES_PER_HOUR == 0)) {
                   penalty -= PER_HOUR_OVERPARKED;
                }
           }
       }
       
       return penalty;
   }
   
   /**
     * Print method
     * 
     * @param none
     * 
     * @return none
     */
   public void printDetails()
    {
        System.out.printf("Ticket Number: %s\n", this.referenceNumber);
        System.out.printf("Vehicle ID: %s\n", this.carLicensePlate);
        System.out.printf("Parked %s minutes, paid for %s\n", this.carMinutesParked, 
            this.meterMinutesPaid);
        System.out.printf("Fine due:: $%.2f\n", calculateFine());
    }   
    
}
