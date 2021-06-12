public class ProjectClass{
    String name="";
    String desc="";
    double initialCost =0.0;

    public ProjectClass() {}

    public ProjectClass(String name) {
        this.name=name;
    }
    
    public ProjectClass(String name, String desc) {
        this.name=name;
        this.desc=desc;
    } 
    public String elevatorPitch(){
        String n=name+" : "+desc;
        return n;
       
    }

    public String getName() {
        return name;
    }
    // setter
    public void setName(String name) {
        this.name = name;  
    }
    public String getdesc() {
        return desc;
    }
    // setter
    public void setdesc(String desc) {
        this.desc = desc;  
    }

    public double getCost() {
        return initialCost;
    }
    // setter
    public void setCost(double initialCost) {
        this.initialCost = initialCost;
    }
}