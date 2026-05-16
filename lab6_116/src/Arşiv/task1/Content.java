package task1;

public abstract class Content {
    private int id;
    private String title;
    private int baseDuration;

    public Content(int id,String title, int baseDuration){
        this.id=id;
        this.title=title;
        this.baseDuration=baseDuration;
    }
    public int getId() {
        return id;
    }
    public int getBaseDuration() {
        return baseDuration;
    }
    public String getTitle() {
        return title;
    }

    public void displayInfo(){
        System.out.println("Id: " + id);
        System.out.println("Title: " + title);
        System.out.println("Base Duration: " + baseDuration);
    }

    public abstract int calculateTotalDuration();

    public abstract String getRecommendationCategory();
}
