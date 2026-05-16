package task2;

interface Damageable {
    void takeDamage(int amount);
    boolean isDestroyed();
}

interface Repairable {
    void repair(int amount);
}

interface Upgradeable {
    void upgrade();
}