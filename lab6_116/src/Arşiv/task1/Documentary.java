package task1;

public class Documentary extends Content{
    private int researchDepthLevel;
    private int numberOfScientistInterviews;
    public Documentary(int id,String title, int baseDuration, int researchDepthLevel,int numberOfScientistInterviews){
        super(id,title,baseDuration);
        this.researchDepthLevel=researchDepthLevel;
        this.numberOfScientistInterviews=numberOfScientistInterviews;
    }

    @Override
    public int calculateTotalDuration() {
        return getBaseDuration() + (numberOfScientistInterviews * 10);
    }

    @Override
    public String getRecommendationCategory(){
        if(researchDepthLevel>=4){
          return "In-Depth";
        }else{
            return "Light Informative";
        }
    }
}