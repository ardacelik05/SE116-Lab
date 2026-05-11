package task1;

public class Movie extends Content {
    private boolean hasPostCreditsScene;
    public Movie(int id,String title, int baseDuration, boolean hasPostCreditsScene){
        super(id,title,baseDuration);
        this.hasPostCreditsScene=hasPostCreditsScene;
    }

    @Override
    public int calculateTotalDuration(){
if(hasPostCreditsScene){
    return getBaseDuration() + 5;
}else{
return getBaseDuration();
}
    }

    @Override
    public String getRecommendationCategory(){
        if(getBaseDuration()<90){
            return"Short Watch";
        }else{
           return"Feature Length";
        }
}
}
