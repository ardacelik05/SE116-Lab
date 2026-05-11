package task2;

class GameCharacter implements Damageable, Upgradeable {
    private String name;
    private int health;
    private int level;

    public GameCharacter(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
    }

    @Override
    public void takeDamage(int amount) {
        health -= amount;
        System.out.println("Character " + name + " took " + amount + " damage. Remaining health: " + health);
    }

    @Override
    public boolean isDestroyed() {
        return health <= 0;
    }

    @Override
    public void upgrade() {
        level++;
        health += 20;
        System.out.println("Character " + name + " leveled up to " + level + ". Health: " + health);
    }
}

class Weapon implements Damageable, Repairable {
    private String name;
    private int durability;

    public Weapon(String name, int durability) {
        this.name = name;
        this.durability = durability;
    }

    @Override
    public void takeDamage(int amount) {
        durability -= amount;
        System.out.println("task2.Weapon " + name + " durability reduced to " + durability);
    }

    @Override
    public boolean isDestroyed() {
        return durability <= 0;
    }

    @Override
    public void repair(int amount) {
        durability += amount;
        System.out.println("task2.Weapon " + name + " repaired. Durability: " + durability);
    }
}

class Building implements Damageable, Repairable, Upgradeable {
    private String type;
    private int health;
    private int level;

    public Building(String type, int health, int level) {
        this.type = type;
        this.health = health;
        this.level = level;
    }

    @Override
    public void takeDamage(int amount) {
        health -= amount;
        System.out.println(type + " building took " + amount + " damage. Remaining health: " + health);
    }

    @Override
    public boolean isDestroyed() {
        return health <= 0;
    }

    @Override
    public void repair(int amount) {
        health += amount;
        System.out.println(type + " building repaired. Health: " + health);
    }

    @Override
    public void upgrade() {
        level++;
        System.out.println(type + " building upgraded to level " + level);
    }
}