package codewars;

import java.util.*;

class PokerHand {

    private int ranking;
    private int subRanking;
    private String hand;
    
    private int pair;
    private boolean three;
    private boolean quad;
    private boolean color;
    private boolean consec;
    
    private int [][] handArray = new int[14][5]
    
    public PokerHand (String hand){
        this.hand = hand;
        parseHand();
        analyzeHand();
        this.ranking = evaluateHand();
        this.subRanking = evaluateSubRanking();
    }
    
    private parseHand(){
        
        int card = -1;
        int color = -1;
        
        for(char c: this.hand){
          switch (c){
              case '2': card = 0; break;
              case '3': card = 1; break;
              case '4': card = 2; break;
              case '5': card = 3; break;
              case '6': card = 4; break;
              case '7': card = 5; break;
              case '8': card = 6; break;
              case '9': card = 7; break;
              case 'T': card = 8; break;
              case 'J': card = 9; break;
              case 'Q': card = 10; break;
              case 'K': card = 11; break;
              case 'A': card = 12; break;
              case 'S': color = 0; break;
              case 'H': color = 1; break;
              case 'D': color = 2; break;
              case 'C': color = 3; break;
              case ' ': card = -1; color = -1; break;
          }
          
            if(card != -1 && color != -1)
              handArray[card][color] = 1;
        }
        
        
        for(int j = 0; j < handArray[0].length -1; j++){
            int sum=0;
            for(int i = 0; i < handArray.length -1; i++)
              sum += handArray[i][j];
            handArray[14][j] = sum;
        }
        
        for(int i = 0; i < handArray.length -1; i++){
            int sum=0;
            for(int j = 0; j < handArray[0].length -1; j++)
              sum += handArray[i][j];
            handArray[i][5] = sum;
        }
        
        
    }
    
    public Result compareWith(PokerHand hand){
        
        Result result = Result.TIE;
        
        if(this.ranking == hand.ranking)
            if(this.subRanking == hand.subRanking && isSubRanking)
                result = Result.TIE;
            else
                result =this.subRanking > handSubranking?  Result.WIN :  Result.LOSS;
        result = this.ranking > hand.ranking? Result.WIN : Result.LOSS;
        return result;
        
    }
    
    public enum Result    {
        WIN,
        LOSS,
        TIE
    }
    
    private int evaluateHand(String hand){
        int result = detectHighest();
        int pair = detect(2);
        boolean three = detect(3);
        boolean quad = detectQuad(4);
        boolean color = detectColor();
        boolean consec = detectConsec();
        
        if(pair != 0) result = pair;
        if(three) result = 3;
        if(consec) result = 4;
        if(color) result = 5;
        if(pair==1 && three) result = 6;
        if(quad) result = 7;
        if(color && consec)
          if(!aceMarker)
            result = 8;
          else
            result = 9;
        
        
        
        return result;
    }
    
    private int detect (int target){
        int result=0;
        for(int i=0; i<12 ; i++)
            if(handArray[i][5] == target) result++;
        return result;
    }
    
    private boolean detectColor(){
    }
    
    private boolean detectConsec(){
    }
    
    