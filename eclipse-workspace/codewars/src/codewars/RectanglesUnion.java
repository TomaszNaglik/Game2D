package codewars;

public class RectanglesUnion {
    public static int calculateSpace(int[][] rectangles) {
        
        int maxX = findMax(2, rectangles);
        int maxY = findMax(3, rectangles);
        
        //System.out.println("MaxX: " + maxX + "   maxY: " +maxY);
        
        int space[][] = new int[maxX][maxY];
        
        //printTable(space);
        for(int i=0; i<rectangles.length;i++)
        	fillSpace(space, rectangles[i]);
        printTable(space);
        
        int sum = calcSum(space);
        System.out.println("Sum is: "+ sum);
        return sum;
    }
    
    private static int calcSum(int[][] space) {
		int sum = 0;
		for(int x=0; x<space.length; x++)
    		for(int y=0; y<space[0].length;y++)
    			if(space[x][y] == 1)
    				sum++;
		
		return sum;
	}

	private static void fillSpace(int space[][], int rec[]) {
    	for(int x=rec[0]; x<rec[2]; x++)
    		for(int y=rec[1]; y<rec[3];y++)
    			space[x][y] = 1;
    }
    
    private static int findMax(int i, int[][] rectangles){
    
        int max = 0;
        for(int j=0; j<rectangles.length; j++){
          if (rectangles[j][i] > max)
            max = rectangles[j][i];
        }
        
        return max;
        
    }
    
    private static void printTable(int[][] tbl) {
    	if(tbl.length>0) {
    	
	    	for(int i=0;i<tbl[0].length;i++) {
	    		for(int j=0;j<tbl.length;j++)
	    			System.out.print(tbl[j][i]+" ");
	    		System.out.println("");
	    	}
	    	
	    	System.out.println("");
    	}
    }
    public static void main (String... args) {
    	int[][] recs = {};
    	//int[][] recs = {{2, 2, 4, 3},{10,10,10,10}};
    	
    	calculateSpace(recs);
    	
    }
}
