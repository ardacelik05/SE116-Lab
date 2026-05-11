package task1;

import java.util.ArrayList;
public class ContentDemo {
    public static void main(String[] args) {
        ArrayList<Content> contentList = new ArrayList<>();

        contentList.add(new Movie(1,"Film 1",75,true));
        contentList.add(new Movie(2,"Film 2", 89,false));

                contentList.add(new Series(3,"Series 1", 45,2));
                contentList.add(new Series(4,"Series 2", 33,2));

                contentList.add(new Documentary(5,"Documentary 1",55,3,3));
                contentList.add(new Documentary(6,"Documentary 2",67,4,1));

                for(Content c : contentList ){

                    c.displayInfo();

                    System.out.println("Total Duration: " + c.calculateTotalDuration());
                    System.out.println("Category: " + c.getRecommendationCategory());
                    System.out.println("-----------");
                }
    }
}
