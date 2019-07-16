package codewars;

public class Spiralizor {

	enum Direction {RIGHT, DOWN, LEFT, UP}
	static Direction dir = Direction.RIGHT;
	
    public static int[][] spiralize(int size) {
        
    	
    	
    	
    	class Point{
            
            int x;
            int y;
            int step;
        	int smallStep;
        	int count;
            
            public Point(int[][] table){
              this.x = 0;
              this.y = 0;
              this.step = table.length;
              this.smallStep = step;
              
              dir = Direction.RIGHT;
              
              if(step==1) this.count=1;
              if(step==2) this.count=2;
              if(step>2) this.count=3;
            }
            
            void nextDirection() {
            	switch (dir) {
            	case RIGHT: dir = Direction.DOWN; break;
            	case DOWN: dir = Direction.LEFT; break;
            	case LEFT: dir = Direction.UP; break;
            	case UP: dir = Direction.RIGHT; break;
            	}
            }
            
            public boolean advance(){
                 
            	//direction control logic
            	smallStep--;
            	if(smallStep == 0 ) {
            		nextDirection();
            		smallStep = step-1;
            		count--;
            		if(count==0) {
            			count = 2;
            			step -= 2;
            			smallStep = step-1;
            			if(step<2) return false;
            		}
            	}
            	
            	switch (dir) {
            	case UP : 	y--;break;
            	case RIGHT : x++;break;
            	case DOWN : y++;break;
            	case LEFT : x--;break;
            	}
            	
            	System.out.println("Step: " + step);
            	System.out.println("SmallStep: " + smallStep);
               return true;
            }
      }
        
    	
    	int[][] spiral = new int[size][size];
        
         reset(spiral);
        
       Point point = new Point(spiral);
        do {
         spiral[point.y][point.x] = 1;
         printSpiral(spiral);
        }while (point.advance());
        
        
        
        return spiral;
    }
    
    private static void printSpiral(int[][] spiral) {
    	System.out.println();
    	System.out.println();
    	System.out.println();
    	
    	for(int i = 0; i < spiral.length; i++) {
            for (int j = 0; j< spiral[0].length;j++) {
              System.out.print(spiral[i][j]);
            }
    	System.out.println();
    	}
    System.out.println();
    	
		
	}
	private static void reset (int[][] table){
    
      for(int i = 0; i < table.length; i++)
        for (int j = 0; j< table[0].length;j++)
          table[i][j] = 0;
    }

}
