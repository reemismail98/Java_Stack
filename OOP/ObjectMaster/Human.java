class Human{
    int strength = 3;
    int stealth = 3;
    int intelligence = 3;
    int health = 100;
    public Human(){
        this.strength = 3;
        this.stealth = 3;
        this.intelligence = 3;
        this.health = 100;
    } 
    public void attack(Human x){
        x.health -= this.strength;
        System.out.println(health);
    }
}