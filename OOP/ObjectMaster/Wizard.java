class Wizard extends Human{ 
    public Wizard() {
        this.health = 50;
        this.intelligence = 8;
    }
    public void heal(Human h) {
        h.health += this.intelligence;
        System.out.println(health);
    }

    public void fireball(Human h) {
        h.health -= (this.intelligence * 3);
        System.out.println(health);
    }

    
}
