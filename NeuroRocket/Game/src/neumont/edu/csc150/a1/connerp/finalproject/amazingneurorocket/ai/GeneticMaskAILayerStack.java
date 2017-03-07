package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils.Vector2;

public class GeneticMaskAILayerStack  implements IAI<Double, double[][]>, IGeneticLearner<GeneticMaskAILayerStack>, Comparable<GeneticMaskAILayerStack>{

	private int maskWidth, maskHeight, layerDepth;
	private GeneticMaskAI[][][] maskLayers;
	private GeneticMaskAI finishingMask;
	private double fitness;

	public int getMaskWidth(){return maskWidth;}
	public int getMaskHeight(){return maskHeight;}
	public int getMaskLayerDepth(){return layerDepth;}
	
	public int getMaskCenter_Width(){return maskWidth/2;}
	public int getMaskCenter_Height(){return maskHeight/2;}

	public GeneticMaskAILayerStack(int x, int y, int depth){
		maskWidth = (x/2)*2+1;
		maskHeight = (y/2)*2+1;
		layerDepth = depth;
		maskLayers = new GeneticMaskAI[maskWidth][maskHeight][depth];
		
		for(int i = 0; i < maskHeight; i++){
			for(int j = 0; j < maskWidth; j++){
				for(int k = 0; k < layerDepth; k++){
					maskLayers[j][i][k] = new GeneticMaskAI(x, y);
				}
			}
		}
		finishingMask = new GeneticMaskAI(x, y);
	}

	@Override
	public Double calcualateInputs(double[][] input) {
		double[][] clone = input.clone();
		
		for(int k = 0; k < layerDepth; k++){
			double[][] workingCopy = clone.clone();
			for(int i = 0; i < maskWidth; i++){
				for(int j = 0; j < maskHeight; j++){
					workingCopy[i][j] = maskLayers[i][j][k].calcualateInputs(clone);
				}
			}
			clone = workingCopy;
		}
		
		return finishingMask.calcualateInputs(clone);
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
	public GeneticMaskAILayerStack breed(GeneticMaskAILayerStack mate, double mutationRate) {
		if(this.maskWidth != mate.maskWidth || this.maskHeight != mate.maskHeight || this.layerDepth != mate.layerDepth)
				throw new UnsupportedOperationException("mates must have identical width, heght, and depth to breed!");
		
		GeneticMaskAILayerStack child = new GeneticMaskAILayerStack(maskWidth, maskHeight, layerDepth);
		
		for(int k = 0; k < layerDepth; k++){
			for(int i = 0; i < maskWidth; i++){
				for(int j = 0; j < maskHeight; j++){
					maskLayers[i][j][k].calcFitness(fitness);
					mate.maskLayers[i][j][k].calcFitness(mate.fitness);
					child.maskLayers[i][j][k] = maskLayers[i][j][k].breed(mate.maskLayers[i][j][k], mutationRate);
				}
			}
		}
		finishingMask.calcFitness(fitness);
		mate.finishingMask.calcFitness(mate.fitness);
		child.finishingMask = finishingMask.breed(mate.finishingMask, mutationRate);
	
		return child;
	}

	@Override
	public Vector2 getInputSize() {
		return new Vector2(maskWidth, maskHeight);
	}
	
	@Override
	public int compareTo(GeneticMaskAILayerStack o) {
		return (int)Math.signum(o.getFitness() - this.getFitness());
	}

}
