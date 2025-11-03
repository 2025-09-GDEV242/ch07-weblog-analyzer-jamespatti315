/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 * 
 * @Authoer worked on by James Patti
 * due 11/3/25
 * HAPPY HALLOWEEN!
 */
 
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader("demo.log");
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /**
     * let make a method so it can take a string which is the name of the log file
     * this a constructor, assume @param needed of log file?
     */
    
    public LogAnalyzer(String logEntry){
        
       hourCounts = new int[24];
       reader = new LogfileReader(logEntry);
        
        
    }
    
    /**
     * here we will make a  method which gives us the number of accesses for a file
     * we test it by opening a logfile with notepad++ and see number of lines in a file.
     */
    
    public int numberofAccesses(){
        int total = 0; //set it to 0 if no files/
        //add amount in each element of hours  hoursCount to total
        for(int i = 0; i < hourCounts.length; i++){
            total += hourCounts[i];
            
        }
        
    
        
        return total;
    
    }
    
    /**
     * now the busiesthour method, this take a for loop and finds which hour count is highest...and guess if zero or matching then 
     * default to  a tie?
     */
    
    public int busiestHour(){
        
        //reuse this code, now where iterating to find the largest hour
        
        int busiestHour = 0;   //so if first busiest then we good~
        
            
            for (int x = 1; x < hourCounts.length; x++){
                //now change variable to total
                if(hourCounts[x]> hourCounts[busiestHour])
                busiestHour = x;
                
                
                }
            //here if need can work on tiebreaker need new index to store multiple largest in hourCounts
              //ehh it returns busiest hour, know issue if tie but tired, tired tired tired.
        
        
        return busiestHour;
    }
    
    
    /**
     * now same as first..but  quiest hour, literally just reuse the frick on this.
     */
    
    public int quiestestHour(){
        
        //reuse this code, now where iterating to find the largest hour
        
        int  quiestestHour = 0;   //so if first busiest then we good~
        
            
            for (int x = 1; x < hourCounts.length; x++){
                //now change variable to total
                if(hourCounts[x]< hourCounts[quiestestHour])
                quiestestHour = x;
                
                
                }
            //here if need can work on tiebreaker need new index to store multiple largest in hourCounts
              //ehh it returns busiest hour, know issue if tie but tired, tired tired tired.
        
        
        return quiestestHour;
    }
    
    /**
     * the busiest two hour method nowm similer to above with now a wider ranger of up to two hours, such as 2-4 am, 8=10 pm etc.
     */
    
    public int busiestTwoHours(){
        int busyTwoHours =  hourCounts[0] + hourCounts[1];
        int busiestStartHour = 0;
        for(int i = 1; i < hourCounts.length-1; i++){
            int twoHoursCount = hourCounts[i] + hourCounts[i+1];
            if(twoHoursCount > busyTwoHours){
                busyTwoHours = twoHoursCount;
                busiestStartHour = i;
                
            }
        }
        
        
        return busyTwoHours-1;
    }
}
