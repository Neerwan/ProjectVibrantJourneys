package vibrantjourneys.init;

import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vibrantjourneys.integration.biomesoplenty.PVJWorldGenerationBOP;
import vibrantjourneys.util.BiomeReference;
import vibrantjourneys.util.EnumLeafType;
import vibrantjourneys.util.EnumStoneType;
import vibrantjourneys.util.EnumWoodType;
import vibrantjourneys.util.PVJConfig;
import vibrantjourneys.util.Reference;
import vibrantjourneys.worldgen.WorldGenBracketFungus;
import vibrantjourneys.worldgen.WorldGenCattail;
import vibrantjourneys.worldgen.WorldGenCobweb;
import vibrantjourneys.worldgen.WorldGenCrackedSand;
import vibrantjourneys.worldgen.WorldGenDesertCaves;
import vibrantjourneys.worldgen.WorldGenFallenLeaves;
import vibrantjourneys.worldgen.WorldGenFallenTree;
import vibrantjourneys.worldgen.WorldGenFloaters;
import vibrantjourneys.worldgen.WorldGenFrozenCaves;
import vibrantjourneys.worldgen.WorldGenGroundCover;
import vibrantjourneys.worldgen.WorldGenMangroveRoot;
import vibrantjourneys.worldgen.WorldGenMangroveTreeSwamp;
import vibrantjourneys.worldgen.WorldGenOvergrownCaves;
import vibrantjourneys.worldgen.WorldGenPVJPlant;
import vibrantjourneys.worldgen.WorldGenPalmTreeBeach;
import vibrantjourneys.worldgen.WorldGenPillowBasalt;
import vibrantjourneys.worldgen.WorldGenRiverGrass;
import vibrantjourneys.worldgen.WorldGenRocks;
import vibrantjourneys.worldgen.WorldGenShortGrass;
import vibrantjourneys.worldgen.WorldGenSmallBush;
import vibrantjourneys.worldgen.WorldGenStalactite;
import vibrantjourneys.worldgen.WorldGenStalagmite;

public class PVJWorldGen
{
	public static void initWorldGen()
	{	
		registerWorldGen(new WorldGenCobweb(PVJConfig.worldgen.cobwebDensity));
		
		registerWorldGen(new WorldGenPalmTreeBeach(PVJConfig.worldgen.palmDensity));
		registerWorldGen(new WorldGenMangroveTreeSwamp(PVJConfig.worldgen.mangroveDensity));
		
		if(PVJConfig.master.enableCaves)
		{
			registerWorldGen(new WorldGenStalagmite(PVJBlocks.rock_formation, 0, 70, PVJConfig.worldgen.stalagmiteDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
			registerWorldGen(new WorldGenStalactite(PVJBlocks.rock_formation, 0, 70, PVJConfig.worldgen.stalactiteDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
			registerWorldGen(new WorldGenStalagmite(PVJBlocks.ice_formation, 0, 70, PVJConfig.worldgen.icicleDensity, BiomeReference.getValidBiomes(BiomeReference.SNOWY_BIOMES)));
			registerWorldGen(new WorldGenStalactite(PVJBlocks.ice_formation, 0, 70, PVJConfig.worldgen.icicleDensity, BiomeReference.getValidBiomes(BiomeReference.SNOWY_BIOMES)));
			
			
			if(PVJConfig.worldgen.enableOvergrownCaves)
				registerWorldGen(new WorldGenOvergrownCaves(BiomeReference.getValidBiomes(BiomeReference.MANGROVE_TREES)));
			
			if(PVJConfig.worldgen.enableFrozenCaves)
				registerWorldGen(new WorldGenFrozenCaves(BiomeReference.getValidBiomes(BiomeReference.SNOWY_BIOMES)));
			
			if(PVJConfig.worldgen.enableSandstoneCaves)
				registerWorldGen(new WorldGenDesertCaves(BiomeReference.getValidBiomes(BiomeReference.DESERT_BIOMES)));
		}
		
		if(PVJConfig.master.enableStoneTypeBlocks)
		{
			registerWorldGen(new WorldGenPillowBasalt(PVJConfig.worldgen.pillowBasaltDensity));
			registerWorldGen(new WorldGenRocks(PVJBlocks.STONES.get(EnumStoneType.BASALT.getID()), 25, 65, PVJConfig.worldgen.basaltDensity, BiomeDictionary.getBiomes(Type.OCEAN).toArray(new Biome[0])));
			registerWorldGen(new WorldGenRocks(PVJBlocks.STONES.get(EnumStoneType.LIMESTONE.getID()), 20, 65, PVJConfig.worldgen.limestoneDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
			registerWorldGen(new WorldGenRocks(PVJBlocks.STONES.get(EnumStoneType.MARBLE.getID()), 18, 65, PVJConfig.worldgen.marbleDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
			registerWorldGen(new WorldGenRocks(PVJBlocks.STONES.get(EnumStoneType.SILTSTONE.getID()), 20, 65, PVJConfig.worldgen.siltstoneDensity, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES)));
		}
		
		if(PVJConfig.master.enableFallenTrees)
		{
			registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, PVJConfig.worldgen.fallenTreeOakDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.OAK_LOG, PVJConfig.worldgen.fallenTreeOakSparseDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES_SPARSE)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.BIRCH_LOG, PVJConfig.worldgen.fallenTreeBirchDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.BIRCH_LOG, PVJConfig.worldgen.fallenTreeBirchSparseDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES_SPARSE)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, PVJConfig.worldgen.fallenTreeSpruceDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.SPRUCE_LOG, PVJConfig.worldgen.fallenTreeSpruceSparseDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES_SPARSE)));
			registerWorldGen(new WorldGenFallenTree(BiomeReference.ACACIA_LOG, PVJConfig.worldgen.fallenTreeAcaciaDensity, BiomeReference.getValidBiomes(BiomeReference.ACACIA_TREES)));
			
			for(EnumWoodType woodType : EnumWoodType.values())
			{
				if(woodType.getFallenTreeDensity() != -1)
				{
					registerWorldGen(new WorldGenFallenTree(PVJBlocks.LOGS.get(woodType.getID()), woodType.getFallenTreeDensity(), woodType.getTreeBiomes()));
				}
			}
		}
		
		registerWorldGen(new WorldGenMangroveRoot(PVJConfig.worldgen.mangroveRootDensity, BiomeReference.getValidBiomes(BiomeReference.MANGROVE_TREES)));
		
		registerWorldGen(new WorldGenSmallBush(PVJConfig.worldgen.bushDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES_SPARSE)));
		
		if(PVJConfig.master.enableGroundcover)
		{
			if(PVJConfig.master.enableFallenLeaves)
			{
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, PVJConfig.worldgen.fallenLeavesOakDensity, BiomeReference.OAK_TREES.toArray(new Biome[0])));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_oak, PVJConfig.worldgen.fallenLeavesOakSparseDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_birch, PVJConfig.worldgen.fallenLeavesBirchDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_birch, PVJConfig.worldgen.fallenLeavesBirchSparseDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_spruce, PVJConfig.worldgen.fallenLeavesSpruceDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_spruce, PVJConfig.worldgen.fallenLeavesSpruceSparseDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_jungle, PVJConfig.worldgen.fallenLeavesJungleDensity, BiomeReference.getValidBiomes(BiomeReference.JUNGLE_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_jungle, PVJConfig.worldgen.fallenLeavesJungleSparseDensity, BiomeReference.getValidBiomes(BiomeReference.JUNGLE_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_darkoak, PVJConfig.worldgen.fallenLeavesDarkOakDensity, BiomeReference.getValidBiomes(BiomeReference.DARKOAK_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_darkoak, PVJConfig.worldgen.fallenLeavesDarkOakSparseDensity, BiomeReference.getValidBiomes(BiomeReference.DARKOAK_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_acacia, PVJConfig.worldgen.fallenLeavesAcaciaDensity, BiomeReference.getValidBiomes(BiomeReference.ACACIA_TREES)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_acacia, PVJConfig.worldgen.fallenLeavesAcaciaDensity, BiomeReference.getValidBiomes(BiomeReference.ACACIA_TREES_SPARSE)));
				registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.fallenleaves_dead, PVJConfig.worldgen.fallenLeavesDeadDensity, BiomeReference.getValidBiomes(BiomeReference.MESA_BIOMES)));
				
				for(EnumLeafType leafType : EnumLeafType.values())
				{
					registerWorldGen(new WorldGenFallenLeaves(PVJBlocks.FALLEN_LEAVES.get(leafType.getID()), leafType.getFallenLeavesDensity(), leafType.getTreeBiomes()));
				}
			}
			if(PVJConfig.master.enableRocks)
			{
				//surface
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.stone_rocks, 60, 200, PVJConfig.worldgen.stoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.cobblestone_rocks, 60, 200, PVJConfig.worldgen.cobblestoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.mossy_cobblestone_rocks, 40, 200, PVJConfig.worldgen.mossyCobblestoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.MOSSY_COBBLESTONE_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.andesite_rocks, 60, 200, PVJConfig.worldgen.andesiteRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.granite_rocks, 60, 200, PVJConfig.worldgen.graniteRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.diorite_rocks, 60, 200, PVJConfig.worldgen.dioriteRocksDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.sandstone_rocks, 50, 100, PVJConfig.worldgen.sandstoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.SANDSTONE_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.red_sandstone_rocks, 55, 75, PVJConfig.worldgen.redSandstoneRocksDensity, BiomeReference.getValidBiomes(BiomeReference.MESA_BIOMES)));
				
				//underground
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.stone_rocks, 1, 60, PVJConfig.worldgen.stoneRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.cobblestone_rocks, 1, 60, PVJConfig.worldgen.cobblestoneRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.andesite_rocks, 1, 60, PVJConfig.worldgen.andesiteRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.granite_rocks, 1, 60, PVJConfig.worldgen.graniteCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.diorite_rocks, 1, 60, PVJConfig.worldgen.dioriteRocksCaveDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
			}

			if(PVJConfig.master.enableTwigs)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.oak_twigs, 60, 150, PVJConfig.worldgen.oakTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.oak_twigs, 60, 150, PVJConfig.worldgen.oakTwigsSparseDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES_SPARSE)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.birch_twigs, 60, 150, PVJConfig.worldgen.birchTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.birch_twigs, 60, 150, PVJConfig.worldgen.birchTwigsSparseDensity, BiomeReference.getValidBiomes(BiomeReference.BIRCH_TREES_SPARSE)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.spruce_twigs, 60, 150, PVJConfig.worldgen.spruceTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.spruce_twigs, 60, 150, PVJConfig.worldgen.spruceTwigsSparseDensity, BiomeReference.getValidBiomes(BiomeReference.SPRUCE_TREES_SPARSE)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.jungle_twigs, 60, 150, PVJConfig.worldgen.jungleTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.JUNGLE_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.acacia_twigs, 60, 150, PVJConfig.worldgen.acaciaTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.ACACIA_TREES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.dark_oak_twigs, 60, 150, PVJConfig.worldgen.darkOakTwigsDensity, BiomeReference.getValidBiomes(BiomeReference.DARKOAK_TREES)));
				for(EnumLeafType leafType : EnumLeafType.values())
				{
					registerWorldGen(new WorldGenGroundCover(PVJBlocks.TWIGS.get(leafType.getID()), 60, 150, leafType.getTwigsDensity(), leafType.getTreeBiomes()));
				}
			}
			if(PVJConfig.master.enableBones)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.bones, 1, 100, PVJConfig.worldgen.bonesDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.bones, 1, 100, PVJConfig.worldgen.bonesDesertDensity, BiomeReference.getValidBiomes(BiomeReference.DESERT_BIOMES)));
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.bones, 1, 150, PVJConfig.worldgen.bonesNetherDensity, BiomeReference.getValidBiomes(BiomeReference.NETHER_BIOMES)));
			}
			if(PVJConfig.master.enableSeashells)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.seashells, 60, 80, PVJConfig.worldgen.seashellsDensity, BiomeReference.getValidBiomes(BiomeReference.BEACH_BIOMES)));
			}
			if(PVJConfig.master.enablePinecones)
			{
				registerWorldGen(new WorldGenGroundCover(PVJBlocks.pinecones, 60, 80, PVJConfig.worldgen.pineconesDensity, BiomeDictionary.getBiomes(Type.CONIFEROUS).toArray(new Biome[0])));
			}
		}

		registerWorldGen(new WorldGenPVJPlant(PVJBlocks.wild_wheat, 60, 90, PVJConfig.worldgen.wildWheatDensity, PVJBiomes.prairie));
		registerWorldGen(new WorldGenPVJPlant(PVJBlocks.wild_potato, 60, 90, PVJConfig.worldgen.wildPotatoDensity, Biomes.PLAINS));
		registerWorldGen(new WorldGenPVJPlant(PVJBlocks.wild_carrot, 60, 90, PVJConfig.worldgen.wildCarrotDensity, BiomeDictionary.getBiomes(Type.COLD).toArray(new Biome[0])));
		registerWorldGen(new WorldGenPVJPlant(PVJBlocks.wild_beetroot, 60, 90, PVJConfig.worldgen.wildBeetrootDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES)));
		
		registerWorldGen(new WorldGenCrackedSand(PVJBlocks.cracked_sand, Blocks.SAND, 60, 150, PVJConfig.worldgen.crackedSandDensity, BiomeReference.getValidBiomes(BiomeReference.DESERT_BIOMES)));
		registerWorldGen(new WorldGenCrackedSand(PVJBlocks.red_cracked_sand, Blocks.SAND, 60, 150, PVJConfig.worldgen.redCrackedSandDensity, BiomeReference.getValidBiomes(BiomeReference.MESA_BIOMES)));
		
		if(PVJConfig.master.enableOverworldPlants)
		{
			registerWorldGen(new WorldGenShortGrass(PVJBlocks.short_grass, PVJConfig.worldgen.shortGrassDensity, BiomeReference.getValidBiomes(BiomeReference.OVERWORLD_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.frost_lotus, 60, 255, PVJConfig.worldgen.frostLotusDensity, BiomeReference.getValidBiomes(BiomeReference.SNOWY_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.silverleaf, 60, 255, PVJConfig.worldgen.silverleafDensity, BiomeReference.getValidBiomes(BiomeReference.OAK_TREES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.chickweed, 60, 255, PVJConfig.worldgen.chickweedDensity, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES)));	
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.clovers, 60, 255, PVJConfig.worldgen.cloversDensity, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.crabgrass, 60, 255, PVJConfig.worldgen.crabgrassDensity, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.waxcap, 40, 190, PVJConfig.worldgen.waxcapDensity, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[0])));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.orange_mushroom, 40, 190, PVJConfig.worldgen.orangeMushroomDensity, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[0])));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.deathcap, 40, 190, PVJConfig.worldgen.deathcapDensity, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[0])));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.small_cactus, 40, 190, PVJConfig.worldgen.smallCactusDensity, BiomeReference.getValidBiomes(BiomeReference.DESERT_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.small_cactus, 40, 190, PVJConfig.worldgen.smallCactusDensity, BiomeReference.getValidBiomes(BiomeReference.MESA_BIOMES)));
			registerWorldGen(new WorldGenFloaters(true, PVJConfig.worldgen.lilypadRiverDensity, true)); //for rivers
			registerWorldGen(new WorldGenFloaters(false, PVJConfig.worldgen.lilypadLakesDensity, false)); //for lakes
			registerWorldGen(new WorldGenBracketFungus(PVJConfig.worldgen.bracketFungusDensity, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES)));
			registerWorldGen(new WorldGenRiverGrass(PVJConfig.worldgen.riverGrassDensity));
			registerWorldGen(new WorldGenCattail(PVJConfig.worldgen.cattailDensity, BiomeReference.getValidBiomes(BiomeReference.FRESHWATER_BIOMES)));
		}

		if(PVJConfig.master.enableNetherPlants)
		{
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.bloodnettle, 0, 255, PVJConfig.worldgen.bloodnettleDensity, BiomeReference.getValidBiomes(BiomeReference.NETHER_BIOMES)));
			registerWorldGen(new WorldGenPVJPlant(PVJBlocks.glowcap, 0, 255, PVJConfig.worldgen.glowcapDensity, BiomeReference.getValidBiomes(BiomeReference.NETHER_BIOMES)));
		}
		
		if(Reference.isBOPLoaded)
		{
			PVJWorldGenerationBOP.initWorldGenBOP();
		}
	}
	
	public static void registerWorldGen(IWorldGenerator worldgen)
	{
		GameRegistry.registerWorldGenerator(worldgen, 0);
	}
}
