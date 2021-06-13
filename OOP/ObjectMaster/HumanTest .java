class HumanTest{
    public static void main(String[] args){
        Human h = new Human();
        Wizard w = new Wizard();
        Ninja n = new Ninja();
        Samurai s=new Samurai();
        Samurai a=new Samurai();
        h.attack(h);
        w.heal(w);
        w.fireball(w);
        n.steal(n);
        n.runAway();
        s.deathBlow(s,a);
        s.meditate();
        Samurai.howMany();

     }
}