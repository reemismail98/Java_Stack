class Samurai extends Human{
    static  int numSamurai = 0;
    public Samurai() {
        this.health  = 200;
        Samurai.numSamurai ++ ;
    }
    public void deathBlow(Human h,Human aya) {
        h.health = 0;
        aya.health -= (aya.health/2);
        System.out.println(health);
    }
    public void meditate() {
        this.health = health;
        System.out.println(health);
    }
    public static  int howMany() {
        return Samurai.numSamurai;
    }
}
