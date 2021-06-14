package Phone;

public class IPhone  extends Phone implements Ringable {
	 public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
	        super(versionNumber, batteryPercentage, carrier, ringTone);
	    }
	    @Override
	    public String ring() {
			return ("IPhone "+ getVersionNumber()+ " Says " +getRingTone());
	    }
	    @Override
	    public String unlock() {
			return "Unlocking via finger print";
	        // your code here
	    }
	    @Override
	    public void displayInfo() {
	    	System.out.println("IPhone "+ getVersionNumber()+ " From " +getCarrier() );         
	    }
}
