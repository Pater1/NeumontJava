package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai;

public interface IGeneticLearner<T> {
	public double getFitness();
	public void calcFitness(double fitness);
	public T breed(T mate, double mutationRate);
}
