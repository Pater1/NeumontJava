package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils.Vector2;

public interface IAI<OutputType, InputType> {
	public OutputType calcualateInputs(InputType input);
	public Vector2 getInputSize();
}
