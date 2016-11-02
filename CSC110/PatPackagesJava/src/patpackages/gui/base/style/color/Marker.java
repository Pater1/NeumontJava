package patpackages.gui.base.style.color;

import patpackages.gui.base.style.color.*;
import patpackages.gui.base.style.textures.*;
public class Marker {
	public Color color;
	public PatPackTexture2D mask;
	
	public PatPackTexture2D AplhaMaskedTexture(){
		PatPackTexture2D tmp = PatPackTexture2D.BlankTextureAtSize(mask.pixleDimentions);
		for(int i = 0; i < mask.textureAsColorMap.columns.length; i++){
			for(int j = 0; j < mask.textureAsColorMap.columns[i].pixels.length; j++){
				tmp.textureAsColorMap.columns[i].pixels[j] = Color.MixColors(new Color[]{
																			color,
																			mask.textureAsColorMap.columns[i].pixels[j]
																		});
			}
		}
		return tmp;
	}
}
