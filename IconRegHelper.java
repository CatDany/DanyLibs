package danylibs.libs;

import oceany.Refs;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class IconRegHelper
{
	public static IIcon regItem(Item item, IIconRegister reg)
	{
		return regItem(item, reg, "");
	}
	
	public static IIcon regBlock(Block block, IIconRegister reg)
	{
		return regBlock(block, reg, "");
	}
	
	public static IIcon regItem(Item item, IIconRegister reg, String suffix)
	{
		return reg.registerIcon(Refs.RESOURCE_LOCATION + ":" + item.getUnlocalizedName().substring(5) + suffix);
	}
	
	public static IIcon regBlock(Block block, IIconRegister reg, String suffix)
	{
		return reg.registerIcon(Refs.RESOURCE_LOCATION + ":" + block.getUnlocalizedName().substring(5) + suffix);
	}
}