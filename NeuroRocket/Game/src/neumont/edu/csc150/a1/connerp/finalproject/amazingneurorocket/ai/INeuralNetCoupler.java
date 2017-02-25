package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai;

public interface INeuralNetCoupler<R, I, T> {
	public R quearyNeualNet(I input);
	public void trainNeuralNet(R expectedReturn, I input, T trainingMethod);
}