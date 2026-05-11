package task2;

class GameManager {
    public void applyDamage(Damageable d, int amount) {
        d.takeDamage(amount);
    }

    public void repairObject(Repairable r, int amount) {
        r.repair(amount);
    }

    public void upgradeObject(Upgradeable u) {
        u.upgrade();
    }
}

public class GameDemo {
    public static void main(String[] args) {
        GameManager manager = new GameManager();

        Damageable hero = new GameCharacter("Arthur", 100, 1);
        Damageable sword = new Weapon("Excalibur", 50);
        Damageable wall = new Building("Stone Wall", 500, 1);

        System.out.println("--- Battle Commences ---");

        manager.applyDamage(hero, 30);
        manager.applyDamage(sword, 60); // This should destroy it
        manager.applyDamage(wall, 100);

        System.out.println("\n--- Maintenance & Leveling ---");

        manager.upgradeObject((Upgradeable) hero);
        manager.repairObject((Repairable) wall, 50);

        System.out.println("\n--- Status Check ---");

        System.out.println("Is Hero destroyed? " + hero.isDestroyed());
        System.out.println("Is Sword destroyed? " + sword.isDestroyed());
        System.out.println("Is Wall destroyed? " + wall.isDestroyed());
    }
}