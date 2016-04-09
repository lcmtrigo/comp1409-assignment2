
/**
 * Write a description of class ParkingMeter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParkingMeter
{
    // instance variables - replace the example below with your own
    private int minutesPaid;
    
    // constants
    public static final int MINIMUM_QMINUTES = 0;

   /**
    * Accessor: minutesPaid
    * 
    * @return int minutesPaid
    */
   public int getMinutesPaid() 
   {
        return minutesPaid;
   }
    
   /**
     * Adds quantityMinutes to instance variable minutesPaid
     * 
     * @param quantityMinutes   must be positive
     */
   public void addMinutesPaid(int quantityMinutes) 
   {
       if(quantityMinutes >= MINIMUM_QMINUTES) 
       {
           minutesPaid += quantityMinutes;
       } else {
           return;
       }
   }
}
