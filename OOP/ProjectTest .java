class ProjectTest {
    public static void main (String [] args){
        ProjectClass p1=new ProjectClass();
        ProjectClass p2=new ProjectClass("reem");
        ProjectClass p3=new ProjectClass("malak","cooooooool");
        p2.setName("ali");
        System .out.println(p3.elevatorPitch());
        System .out.println(p2.getName());
        System .out.println(p3.getdesc());
    }
}