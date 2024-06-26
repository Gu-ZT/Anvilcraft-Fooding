package dev.anvilcraft.fooding;

import dev.anvilcraft.fooding.data.AnvilCraftFoodingDatagen;
import dev.anvilcraft.fooding.init.ModBlocks;
import dev.anvilcraft.fooding.init.ModCreativeModeTab;
import dev.anvilcraft.fooding.init.ModItems;
import dev.dubhe.anvilcraft.api.registry.AnvilCraftRegistrate;

public class AnvilCraftFooding {
    public static final String MOD_ID = "anvilcraft_fooding";

    public static final AnvilCraftRegistrate REGISTRATE = AnvilCraftRegistrate.create(MOD_ID);

    public static void init() {
        // common init
        ModItems.register();
        ModBlocks.register();
        ModCreativeModeTab.register();

        // datagen init
        AnvilCraftFoodingDatagen.init();

        // fabric exclusive, squeeze this in here to register before stuff is used
        REGISTRATE.registerRegistrate();
    }
}
