package patpackages.gui.base.style.color;

public class Color {
	//red, green, blue, alpha
	private long[] color = new long[4];
	
	public void SetColor(long red, long green, long blue, long alpha){
		if(red < 0 || green < 0 || blue < 0 || alpha < 0){
			IllegalArgumentException iae = new IllegalArgumentException("Positive values only");
			throw iae;
		}
		color[0] = red;
		color[1] = green;
		color[2] = blue;
		color[3] = alpha;
	}
	public void SetColor(long red, long green, long blue){
		SetColor(red,green,blue,Long.MAX_VALUE);
	}
	public void SetColor(long intensity, long alpha){
		SetColor(intensity,intensity,intensity,alpha);
	}
	public void SetColor(long intensity){
		SetColor(intensity,intensity,intensity);
	}
	
	public void SetColor(int red, int green, int blue, int alpha){
		SetColor((long)red,(long)green,(long)blue,(long)alpha);
	}
	public void SetColor(int red, int green, int blue){
		SetColor((long)red, (long)green, (long)blue);
	}
	public void SetColor(int intensity, int alpha){
		SetColor((long)intensity, (long)alpha);
	}
	public void SetColor(int intensity){
		SetColor((long)intensity);
	}
	
	public long[] GetColor64(boolean preserveAlpha){
		long[] i = new long[4];
		i = color;
		if(preserveAlpha) i[3] = Long.MAX_VALUE;
		return color;
	}
	
	
	public static Color _NewColor(long red, long green, long blue, long alpha){
		Color clr = new Color();
		clr.SetColor(red, green, blue, alpha);
		return clr;
	}
	public static Color MixColors(Color[] colors){
		long r = colors[0].color[0], g = colors[0].color[1], b = colors[0].color[2], a = colors[0].color[3];
		for(int i = 1; i < colors.length; i++){
			r = mixChannel(r, colors[i].color[0]);
			g = mixChannel(g, colors[i].color[1]);
			b = mixChannel(b, colors[i].color[2]);
			a = mixChannel(a, colors[i].color[3]);
		}
		return Color._NewColor(r, g, b, a);
	}
	private static long mixChannel(long mix, long into){
		return (long)(Math.pow(mix*mix + into*into, 0.5)/2);
	}
	private static int mixChannel(int mix, int into){
		return (int)(Math.pow(mix*mix + into*into, 0.5)/2);
	}
}
