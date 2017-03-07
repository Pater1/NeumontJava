package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils.Vector2;

public class GeneticMaskAI implements IAI<Double, double[][]>, IGeneticLearner<GeneticMaskAI>, Comparable<GeneticMaskAI>{
	private int maskWidth, maskHeight;
	private double[][] mask;
	private double fitness;

	public int getMaskWidth(){return maskWidth;}
	public int getMaskHeight(){return maskHeight;}
	public int getMaskCenter_Width(){return maskWidth/2;}
	public int getMaskCenter_Height(){return maskHeight/2;}
	
	public GeneticMaskAI(int x, int y){
		maskWidth = (x/2)*2+1;
		maskHeight = (y/2)*2+1;
		mask = new double[maskWidth][maskHeight];
		for(int i = 0; i < maskHeight; i++){
			for(int j = 0; j < maskWidth; j++){
				mask[j][i] = Math.random() *2 -1;
			}
		}
	}
	
	@Override
	public Double calcualateInputs(double[][] input) {
		if(input.length != mask.length){
			throw new IllegalArgumentException("input length must match length of mask (" + maskWidth + ", " + maskHeight + ")");
		}
		
		Double ret = 0.0;
		double[][] inputCopy = input.clone();
		for(int x = 0; x < maskWidth; x++){
			if(inputCopy[x].length != mask[x].length){
				throw new IllegalArgumentException("input length must match length of mask (" + maskWidth + ", " + maskHeight + ")");
			}
			
			for(int y = 0; y < maskHeight; y++){
				inputCopy[x][y] *= mask[x][y]; 
				ret += inputCopy[x][y];
			}
		}
		
		return sigmoid(ret);
	}

	@Override
	public double getFitness() {
		return fitness;
	}
	@Override
	public void calcFitness(double fitness) {
		this.fitness = fitness;
	}
	@Override
	public GeneticMaskAI breed(GeneticMaskAI mate, double mutationRate) {
		if(mate == null){
			throw new IllegalArgumentException("mate cannot be null!");
		}
		if(this.getMaskHeight() != mate.getMaskHeight() || this.getMaskWidth() != mate.getMaskWidth()){
			throw new IllegalArgumentException("input length must match length of mask (" + maskWidth + ", " + maskHeight + ")");
		}
		
		GeneticMaskAI child = new GeneticMaskAI(this.getMaskWidth(), this.getMaskHeight());
		for(int i = 0; i < maskHeight; i++){
			for(int j = 0; j < maskWidth; j++){
				if(Math.random() <= mutationRate){
					child.mask[j][i] = Math.random() *2 -1;
				}else{
					double genomeSelectorRange = this.getFitness() + mate.getFitness();
					if((Math.random() * genomeSelectorRange) <= this.getFitness()){
						child.mask[j][i] = this.mask[j][i];
					}else{
						child.mask[j][i] = mate.mask[j][i];
					}
				}
			}
		}
		
		return child;
	}
	
	@Override
	public int compareTo(GeneticMaskAI o) {
		return (int)Math.signum(o.getFitness() - this.getFitness());
	}
	
	private double sigmoid(double in){
		return (in/(1+Math.abs(in)));
	}
	@Override
	public Vector2 getInputSize() {
		return new Vector2(maskWidth, maskHeight);
	}

	
	@Override 
	public String toString(){
		String ret = "";
		for(int i = 0; i < mask.length; i++){
			ret += "[";
			for(int j = 0; j < mask[i].length; j++){
				if(j != 0) ret += ", ";
				ret += mask[i][j];
			}
			ret +="]\n";
		}
		return ret;
	}
}
