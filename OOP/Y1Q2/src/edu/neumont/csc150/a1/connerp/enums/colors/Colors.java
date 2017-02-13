package edu.neumont.csc150.a1.connerp.enums.colors;

import java.awt.Color;

public class Colors extends java.awt.Color{
	public final static Colors[] Presets = new Colors[]{
		new Colors("aliceblue","F0F8FF"),
		new Colors("antiquewhite","FAEBD7"),
		new Colors("aqua","00FFFF"),
		new Colors("aquamarine","7FFFD4"),
		new Colors("azure","F0FFFF"),
		new Colors("beige","F5F5DC"),
		new Colors("bisque","FFE4C4"),
		new Colors("black","000000"),
		new Colors("blanchedalmond","FFEBCD"),
		new Colors("blue","0000FF"),
		new Colors("blueviolet","8A2BE2"),
		new Colors("brown","A52A2A"),
		new Colors("burlywood","DEB887"),
		new Colors("cadetblue","5F9EA0"),
		new Colors("chartreuse","7FFF00"),
		new Colors("chocolate","D2691E"),
		new Colors("coral","FF7F50"),
		new Colors("cornflowerblue","6495ED"),
		new Colors("cornsilk","FFF8DC"),
		new Colors("crimson","DC143C"),
		new Colors("cyan","00FFFF"),
		new Colors("darkblue","00008B"),
		new Colors("darkcyan","008B8B"),
		new Colors("darkgoldenrod","B8860B"),
		new Colors("darkgray","A9A9A9"),
		new Colors("darkgreen","006400"),
		new Colors("darkgrey","A9A9A9"),
		new Colors("darkkhaki","BDB76B"),
		new Colors("darkmagenta","8B008B"),
		new Colors("darkolivegreen","556B2F"),
		new Colors("darkorange","FF8C00"),
		new Colors("darkorchid","9932CC"),
		new Colors("darkred","8B0000"),
		new Colors("darksalmon","E9967A"),
		new Colors("darkseagreen","8FBC8F"),
		new Colors("darkslateblue","483D8B"),
		new Colors("darkslategray","2F4F4F"),
		new Colors("darkslategrey","2F4F4F"),
		new Colors("darkturquoise","00CED1"),
		new Colors("darkviolet","9400D3"),
		new Colors("deeppink","FF1493"),
		new Colors("deepskyblue","00BFFF"),
		new Colors("dimgray","696969"),
		new Colors("dimgrey","696969"),
		new Colors("dodgerblue","1E90FF"),
		new Colors("firebrick","B22222"),
		new Colors("floralwhite","FFFAF0"),
		new Colors("forestgreen","228B22"),
		new Colors("fuchsia","FF00FF"),
		new Colors("gainsboro","DCDCDC"),
		new Colors("ghostwhite","F8F8FF"),
		new Colors("gold","FFD700"),
		new Colors("goldenrod","DAA520"),
		new Colors("gray","808080"),
		new Colors("grey","808080"),
		new Colors("green","008000"),
		new Colors("greenyellow","ADFF2F"),
		new Colors("honeydew","F0FFF0"),
		new Colors("hotpink","FF69B4"),
		new Colors("indianred","CD5C5C"),
		new Colors("indigo","4B0082"),
		new Colors("ivory","FFFFF0"),
		new Colors("khaki","F0E68C"),
		new Colors("lavender","E6E6FA"),
		new Colors("lavenderblush","FFF0F5"),
		new Colors("lawngreen","7CFC00"),
		new Colors("lemonchiffon","FFFACD"),
		new Colors("lightblue","ADD8E6"),
		new Colors("lightcoral","F08080"),
		new Colors("lightcyan","E0FFFF"),
		new Colors("lightgoldenrodyellow","FAFAD2"),
		new Colors("lightgray","D3D3D3"),
		new Colors("lightgreen","90EE90"),
		new Colors("lightgrey","D3D3D3"),
		new Colors("lightpink","FFB6C1"),
		new Colors("lightsalmon","FFA07A"),
		new Colors("lightseagreen","20B2AA"),
		new Colors("lightskyblue","87CEFA"),
		new Colors("lightslategray","778899"),
		new Colors("lightslategrey","778899"),
		new Colors("lightsteelblue","B0C4DE"),
		new Colors("lightyellow","FFFFE0"),
		new Colors("lime","00FF00"),
		new Colors("limegreen","32CD32"),
		new Colors("linen","FAF0E6"),
		new Colors("magenta","FF00FF"),
		new Colors("maroon","800000"),
		new Colors("mediumaquamarine","66CDAA"),
		new Colors("mediumblue","0000CD"),
		new Colors("mediumorchid","BA55D3"),
		new Colors("mediumpurple","9370DB"),
		new Colors("mediumseagreen","3CB371"),
		new Colors("mediumslateblue","7B68EE"),
		new Colors("mediumspringgreen","00FA9A"),
		new Colors("mediumturquoise","48D1CC"),
		new Colors("mediumvioletred","C71585"),
		new Colors("midnightblue","191970"),
		new Colors("mintcream","F5FFFA"),
		new Colors("mistyrose","FFE4E1"),
		new Colors("moccasin","FFE4B5"),
		new Colors("navajowhite","FFDEAD"),
		new Colors("navy","000080"),
		new Colors("oldlace","FDF5E6"),
		new Colors("olive","808000"),
		new Colors("olivedrab","6B8E23"),
		new Colors("orange","FFA500"),
		new Colors("orangered","FF4500"),
		new Colors("orchid","DA70D6"),
		new Colors("palegoldenrod","EEE8AA"),
		new Colors("palegreen","98FB98"),
		new Colors("paleturquoise","AFEEEE"),
		new Colors("palevioletred","DB7093"),
		new Colors("papayawhip","FFEFD5"),
		new Colors("peachpuff","FFDAB9"),
		new Colors("peru","CD853F"),
		new Colors("pink","FFC0CB"),
		new Colors("plum","DDA0DD"),
		new Colors("powderblue","B0E0E6"),
		new Colors("purple","800080"),
		new Colors("red","FF0000"),
		new Colors("rosybrown","BC8F8F"),
		new Colors("royalblue","4169E1"),
		new Colors("saddlebrown","8B4513"),
		new Colors("salmon","FA8072"),
		new Colors("sandybrown","F4A460"),
		new Colors("seagreen","2E8B57"),
		new Colors("seashell","2E8B57")
	};

	public final String name;
	
	@Override
	public String toString(){
		return name;
	}
	
    private Colors(String name, String code){
    	super(Integer.parseInt("" + code.charAt(0) + code.charAt(1), 16), 
    			Integer.parseInt("" + code.charAt(2) + code.charAt(3), 16),
    			Integer.parseInt("" + code.charAt(4) + code.charAt(5), 16));
    	
    	this.name = name;
    }
    
    public Color MixWith(Color other){
    	return Colors.Mix((Color)this, other);
    }

	public static Color Mix(Color color1, Color color2) {
		int r, g, b;
		r = (color1.getRed() + color2.getRed())/2;
		g = (color1.getGreen() + color2.getGreen())/2;
		b = (color1.getBlue() + color2.getBlue())/2;
		
		return new Color(r,g,b);
	}
}
