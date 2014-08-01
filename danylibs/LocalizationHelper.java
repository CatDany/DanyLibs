package danylibs;

import luckycoins.Refs;
import net.minecraft.util.StatCollector;

public class LocalizationHelper
{
	public static String get(String string)
	{
		return StatCollector.translateToLocal(Refs.MOD_ID + "." + string);
	}
	
	public static String get(String string, Object... format)
	{
		return StatCollector.translateToLocalFormatted(Refs.MOD_ID + "." + string, format);
	}
}