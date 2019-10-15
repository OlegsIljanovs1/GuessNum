package Oleg;

import java.util.ArrayList;

public class LeaderBoard {
   private ArrayList<GameResult> LeaderBoard = new ArrayList<>();

   public void addResult(
           String name,
           int tries,
           long time
   ){
       GameResult r = new GameResult();
       r.setName(name);
       r.setTriesCount(tries);
       r.setTime(time);
       results.add(r);
   }
}
