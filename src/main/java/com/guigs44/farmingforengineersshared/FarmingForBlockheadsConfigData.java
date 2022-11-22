package net.blay09.mods.farmingforblockheads;

import me.shedaniel.autoconfig.annotation.Config;
import net.blay09.mods.balm.api.config.BalmConfigData;
import net.blay09.mods.balm.api.config.Comment;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Config(name = FarmingForBlockheads.MOD_ID)
public class FarmingForBlockheadsConfigData implements BalmConfigData {

    private static final List<String> DEFAULT_MERCHANT_NAMES = Arrays.asList(
            "Swap-O-Matic",
            "Emerald Muncher",
            "Weathered Salesperson"
    );

    @Comment("List of names the merchant can have.")
    public List<String> merchantNames = DEFAULT_MERCHANT_NAMES;

    @Comment("The range within animals can be fed by the feeding trough.")
    public int feedingTroughRange = 8; // 1-16

    @Comment("The maximum amount of animals (per type) until the feeding trough stops feeding.")
    public int feedingTroughMaxAnimals = 8; // 1-max

    @Comment("The range at which the chicken nest picks up laid eggs.")
    public int chickenNestRange = 8; // 1-16

    @Comment("The chance to get a bonus crop when using Green Fertilizer.")
    public double fertilizerBonusCropChance = 1f; // 0-1

    @Comment("The chance to get a bonus growth when using Red Fertilizer.")
    public double fertilizerBonusGrowthChance = 1f; // 0-1

    @Comment("The chance for Fertilized Farmland to turn back into regular Farmland (per provided bonus).")
    public double fertilizerRegressionChance = 0f; // 0-1

    @Comment("Set this to true if you're a modpack dev to see Farming for Blockheads registry warnings in chat. Errors will always display.")
    public boolean showRegistryWarnings = false;

    public String getRandomMerchantName(Random rand) {
        List<? extends String> candidates = merchantNames;
        if (candidates.isEmpty()) {
            candidates = DEFAULT_MERCHANT_NAMES;
        }

        return candidates.get(rand.nextInt(candidates.size()));
    }

}
