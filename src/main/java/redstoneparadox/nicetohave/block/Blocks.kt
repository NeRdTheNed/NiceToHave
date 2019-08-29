package redstoneparadox.nicetohave.block

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry
import net.minecraft.block.*
import net.minecraft.block.Blocks
import redstoneparadox.nicetohave.util.oldconfig.OldConfig
import redstoneparadox.nicetohave.util.initializers.BlocksInitializer

object Blocks : BlocksInitializer() {

    val GOLD_BUTTON : Block? = register<Block>(CustomButtonBlock(1), "gold_button", null)
    val ANALOG_REDSTONE_EMITTER : Block? = register<Block>(AnalogRedstoneEmitterBlock(), "analog_redstone_emitter", null)
    val CHAIN_LINK_FENCE : Block? = register<Block>(ChainLinkFenceBlock(), "chain_link_fence", null)
    val TRIMMED_VINE : Block? = register<Block>(TrimmedVineBlock(), "trimmed_vine", null)

    //Ore Blocks
    val DIRT_GOLD_ORE : Block? = register(Block(copySettings(Blocks.DIRT)), "dirt_gold_ore", false)
    val SAND_GOLD_ORE : Block? = register(SandBlock(14406560, copySettings(Blocks.SAND)), "sand_gold_ore", false)
    val GRAVEL_GOLD_ORE : Block? = register(GravelBlock(copySettings(Blocks.GRAVEL)), "gravel_gold_ore", false)

    //Poles
    val OAK_POLE : PoleBlock? = registerPole(Blocks.OAK_WOOD, "oak")
    val SPRUCE_POLE : PoleBlock? = registerPole(Blocks.SPRUCE_WOOD, "spruce")
    val BIRCH_POLE : PoleBlock? = registerPole(Blocks.BIRCH_WOOD, "birch")
    val JUNGLE_POLE : PoleBlock? = registerPole(Blocks.JUNGLE_WOOD, "jungle")
    val ACACIA_POLE : PoleBlock? = registerPole(Blocks.ACACIA_WOOD, "acacia")
    val DARK_OAK_POLE : PoleBlock? = registerPole(Blocks.DARK_OAK_WOOD, "dark_oak")

    val STRIPPED_OAK_POLE : PoleBlock? = registerPole(Blocks.OAK_WOOD, "stripped_oak")
    val STRIPPED_SPRUCE_POLE : PoleBlock? = registerPole(Blocks.SPRUCE_WOOD, "stripped_spruce")
    val STRIPPED_BIRCH_POLE : PoleBlock? = registerPole(Blocks.BIRCH_WOOD, "stripped_birch")
    val STRIPPED_JUNGLE_POLE : PoleBlock? = registerPole(Blocks.JUNGLE_WOOD, "stripped_jungle")
    val STRIPPED_ACACIA_POLE : PoleBlock? = registerPole(Blocks.ACACIA_WOOD, "stripped_acacia")
    val STRIPPED_DARK_OAK_POLE : PoleBlock? = registerPole(Blocks.DARK_OAK_WOOD, "stripped_dark_oak")

    fun initBlocks() {
        if (OldConfig.getBool("blocks.poles")) {
            registerFlammableBlocks(arrayOf(OAK_POLE, SPRUCE_POLE, BIRCH_POLE, JUNGLE_POLE, ACACIA_POLE, DARK_OAK_POLE), FlammableBlockRegistry.Entry(5, 20))
            registerFlammableBlocks(arrayOf(STRIPPED_OAK_POLE, STRIPPED_SPRUCE_POLE, STRIPPED_BIRCH_POLE, STRIPPED_JUNGLE_POLE, STRIPPED_ACACIA_POLE, STRIPPED_DARK_OAK_POLE), FlammableBlockRegistry.Entry(5, 20))
        }
    }

}