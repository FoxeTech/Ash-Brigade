package temp;
public class BasicLineOfSightDetection {
	// TODO: Remove ArrayList usage if performance is affected
	// TODO: Actually include the dependencies for importing

	/*
	 * Constants constants; FieldController fieldController;
	 * 
	 * //dimensions of playing field int width; int length; int height;
	 * 
	 * public BasicLineOfSightDetection(int width, int length, int height) {
	 * 
	 * constants = new Constants(); fieldController = new FieldController();
	 * 
	 * this.width = width; this.length = length; this.height = height;
	 * 
	 * }
	 * 
	 * public ArrayList<ArrayList<Integer>> getLOS(int x, int y, int z, int
	 * distance){ ArrayList<ArrayList<Integer>> losList = new ArrayList<>();
	 * 
	 * for(int i = 0; i < constants.NUM_DIMENSIONS; i++){//one list for each
	 * dimension losList.add(new ArrayList<Integer>()); }
	 * 
	 * return calculateLOS(x, y, z, 0, distance, losList);
	 * 
	 * }
	 * 
	 * private ArrayList<ArrayList<Integer>> calculateLOS(int x, int y, int z,
	 * int step, int distance, ArrayList<ArrayList<Integer>> losList){ if(step
	 * == distance || fieldController.isObstacle(x, y, z)) return losList; else{
	 * 
	 * if(!isDuplicate(losList, x, y, z)){ losList.get(0).add(x);
	 * losList.get(1).add(y); losList.get(2).add(z); }
	 * 
	 * if(x < width) calculateLOS(x+1, y, z, step+1, distance, losList); if(x >=
	 * 0) calculateLOS(x-1, y, z, step+1, distance, losList); if(y < length)
	 * calculateLOS(x, y+1, z, step+1, distance, losList); if(y >= 0)
	 * calculateLOS(x, y-1, z, step+1, distance, losList); if(z < height)
	 * calculateLOS(x, y, z+1, step+1, distance, losList); if(z >= 0)
	 * calculateLOS(x, y, z-1, step+1, distance, losList);
	 * 
	 * } return losList; }
	 * 
	 * private boolean isDuplicate(ArrayList<ArrayList<Integer>> losList, int x,
	 * int y, int z){ for(int i = 0; i < losList.size(); i++){
	 * if(losList.get(0).get(i) == x && losList.get(1).get(i) == y &&
	 * losList.get(2).get(i) == z) return true; } return false; }
	 */
}
