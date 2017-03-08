package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GeneticMaskAIBreeder implements ITrainer<GeneticMaskAILayerStack>{

	private ArrayList<GeneticMaskAILayerStack> genePool = new ArrayList<GeneticMaskAILayerStack>();
	private int genePoolSize, maskWidth, maskHeight, layerDepth;
	private double mutationRate, randomReturnRate, generationCount;
	private JTextArea generations = new JTextArea("0"), maxFit = new JTextArea("0");
	
	public GeneticMaskAIBreeder(int genePoolSize, int maskWidth, int maskHeight, int depth, double mutationRate, double randomReturnRate){
		this.genePoolSize = genePoolSize;
		this.maskWidth = maskWidth;
		this.maskHeight = maskHeight;
		this.mutationRate = mutationRate;
		this.layerDepth = depth;
		this.randomReturnRate = randomReturnRate;
	}

	@Override
	public GeneticMaskAILayerStack getNextLearner() {
		GeneticMaskAILayerStack nextAI = null;
		if(genePool.size() < genePoolSize || Math.random() < randomReturnRate){
			nextAI = new GeneticMaskAILayerStack(maskWidth, maskHeight, layerDepth);
		}else{
			nextAI = breedFromPool();
		}
		return nextAI;
	}

	private GeneticMaskAILayerStack breedFromPool() {
		@SuppressWarnings("unchecked")
		ArrayList<GeneticMaskAILayerStack> localGenePool = (ArrayList<GeneticMaskAILayerStack>) genePool.clone();
		
		double fitnessPool = 0;
		for(int i = 0; i < localGenePool.size(); i++){
			fitnessPool += localGenePool.get(i).getFitness();
		}
		double selectorIndex = Math.random() * fitnessPool;
		int selected = 0;
		while(selectorIndex > 0){
			selectorIndex -= localGenePool.get(selected).getFitness();
			selected = (selected + 1) % localGenePool.size();
		}
		
		GeneticMaskAILayerStack parentA = localGenePool.get(selected);
		localGenePool.remove(parentA);
		fitnessPool -= parentA.getFitness();
		
		selectorIndex = Math.random() * fitnessPool;
		selected = 0;
		while(selectorIndex > 0){
			selectorIndex -= localGenePool.get(selected).getFitness();
			selected = (selected + 1) % localGenePool.size();
		}
		
		GeneticMaskAILayerStack parentB = localGenePool.get(selected);
		
		return parentA.breed(parentB, mutationRate);
	}

	@Override
	public void evaluateCurrentLearner(GeneticMaskAILayerStack learnerToEvaluate) {
		genePool.add(learnerToEvaluate);
		Collections.sort(genePool);
		while(genePool.size() > genePoolSize){
			genePool.remove(genePool.size() - 1);
		}

		generationCount++;
		generations.setText(""+generationCount);

		maxFit.setText("" + genePool.get(0).getFitness());
	}

	public void populateHeader(JPanel header) {
		header.add(generations);
		header.add(maxFit);
	}

}
