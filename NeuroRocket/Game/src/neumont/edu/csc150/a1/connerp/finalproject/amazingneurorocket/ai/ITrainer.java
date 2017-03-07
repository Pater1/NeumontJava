package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai;

public interface ITrainer<T> {
	public T getNextLearner();
	public void evaluateCurrentLearner(T learnerToEvaluate);
}
