class Dog extends Animal{
    public String type="mameml";
    public Dog(){
        super("Animal");//constractor for animal
        System.out.println("I am a dog");
    }
    @Override
    public void display(){
         System.out.println("here is dog class");
    }
    public void printMessage(){
        super.display();
        this.display();
    }
    public void printType(){
        System.out.println(this.type);
        System.out.println(super.type);

    }
}