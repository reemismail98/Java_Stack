package Phone;

public class Galaxy  extends Phone implements Ringable {
	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {       
		return ("Galaxy "+ getVersionNumber()+ " Says " +getRingTone());
        // your code here
    }
    @Override
    public String unlock() {
		return "Unlocking via facial recognition";
        // your code here
    }
    @Override
    public void displayInfo() {
    	System.out.println("Galaxy "+ getVersionNumber()+ " From " +getCarrier() );         
    }
}
