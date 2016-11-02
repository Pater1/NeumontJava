package patpackages.gui.base.style.textures;

import patpackages.gui.base.style.color.*;

public class PatPackTexture2D {
	public int[] pixleDimentions = new int[2];
	public colorMap textureAsColorMap;
	
	public static PatPackTexture2D BlankTextureAtSize(int[] size){
		PatPackTexture2D tmp = new PatPackTexture2D();
		tmp.textureAsColorMap = colorMap.newMap(size);
		return tmp;
	}

	public static class colorColumn{
		public Color[] pixels;

		public static colorColumn newColumn(int size) {
			colorColumn clm = new colorColumn();
			clm.pixels = new Color[size];
			for(int i = 0; i < clm.pixels.length; i++){
				clm.pixels[i] = Color._NewColor(Long.MAX_VALUE,Long.MAX_VALUE,Long.MAX_VALUE,Long.MAX_VALUE);
			}
			return clm;
		}
	}
	public static class colorMap{
		public colorColumn[] columns;
		
		public static colorMap newMap(int[] size){
			colorMap clm = new colorMap();
			clm.columns = new colorColumn[size[0]];
			for(int i = 0; i < clm.columns.length; i++){
				clm.columns[i] = colorColumn.newColumn(size[1]);
			}
			return clm;
		}
	}
}
