package vibrantjourneys.util;

import net.minecraft.world.biome.Biome;

public enum EnumLeafType
{
    WILLOW(0, "willow", EnumWoodType.WILLOW, PVJConfig.worldgen.fallenLeavesWillowDensity, PVJConfig.worldgen.willowTwigsDensity),
    MANGROVE(1, "mangrove", EnumWoodType.MANGROVE, PVJConfig.worldgen.fallenLeavesMangroveDensity, PVJConfig.worldgen.mangroveTwigsDensity),
    PALM(2, "palm", EnumWoodType.PALM, PVJConfig.worldgen.fallenLeavesPalmDensity, PVJConfig.worldgen.palmTwigsDensity),
    REDWOOD(3, "redwood", EnumWoodType.REDWOOD, PVJConfig.worldgen.fallenLeavesRedwoodDensity, PVJConfig.worldgen.redwoodTwigsDensity),
    FIR(4, "fir", EnumWoodType.FIR, PVJConfig.worldgen.fallenLeavesFirDensity, PVJConfig.worldgen.firTwigsDensity),
    PINE(5, "pine", EnumWoodType.PINE, PVJConfig.worldgen.fallenLeavesPineDensity, PVJConfig.worldgen.pineTwigsDensity),
    ASPEN(6, "aspen", EnumWoodType.ASPEN, PVJConfig.worldgen.fallenLeavesAspenDensity, PVJConfig.worldgen.aspenTwigsDensity),
    RED_MAPLE(7, "red_maple", EnumWoodType.MAPLE, PVJConfig.worldgen.fallenLeavesRedMapleDensity, PVJConfig.worldgen.redMapleTwigsDensity),
    ORANGE_MAPLE(8, "orange_maple", EnumWoodType.MAPLE, PVJConfig.worldgen.fallenLeavesOrangeMapleDensity, PVJConfig.worldgen.orangeMapleTwigsDensity),
    BAOBAB(9, "baobab", EnumWoodType.BAOBAB, PVJConfig.worldgen.fallenLeavesBaobabDensity, PVJConfig.worldgen.baobabTwigsDensity),
    COTTONWOOD(10, "cottonwood", EnumWoodType.COTTONWOOD, PVJConfig.worldgen.fallenLeavesCottonwoodDensity, PVJConfig.worldgen.cottonwoodTwigsDensity),
    CRYSTALBARK(11, "crystalbark", EnumWoodType.CRYSTALBARK, PVJConfig.worldgen.fallenLeavesCrystalbarkDensity, PVJConfig.worldgen.crystalbarkTwigsDensity),
    BLUE_ARCWOOD(12, "blue_arcwood", EnumWoodType.ARCWOOD, PVJConfig.worldgen.fallenLeavesBlueArcwoodDensity, PVJConfig.worldgen.blueArcwoodTwigsDensity),
    PURPLE_ARCWOOD(13, "purple_arcwood", EnumWoodType.ARCWOOD, PVJConfig.worldgen.fallenLeavesPurpleArcwoodDensity, PVJConfig.worldgen.purpleArcwoodTwigsDensity),
    JUNIPER(14, "juniper", EnumWoodType.JUNIPER, PVJConfig.worldgen.fallenLeavesJuniperDensity, PVJConfig.worldgen.juniperTwigsDensity),
    JUNIPER_BERRIED(15, "juniper_berried", EnumWoodType.JUNIPER, -1, -1);
    
    private String name;
    private int id;
    private EnumWoodType woodType;
    private int fallenLeavesDensity;
    private int twigsDensity;
    
    private EnumLeafType(int id, String name, EnumWoodType woodType, int fallenLeavesDensity, int twigsDensity)
    {
    	this.name = name;
    	this.id = id;
    	this.woodType = woodType;
    	this.fallenLeavesDensity = fallenLeavesDensity;
    	this.twigsDensity = twigsDensity;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public int getID()
    {
    	return id;
    }
    
    public EnumWoodType getWoodType()
    {
    	return woodType;
    }
    
    /**
     * Returns -1 for trees that have no associated fallen leaves
     */
    public int getFallenLeavesDensity()
    {
    	return fallenLeavesDensity;
    }
    
    /**
     * Returns -1 for trees that have no associated twigs
     */
    public int getTwigsDensity()
    {
    	return twigsDensity;
    }
    
    public Biome[] getTreeBiomes()
    {
    	return woodType.getTreeBiomes();
    }
}
