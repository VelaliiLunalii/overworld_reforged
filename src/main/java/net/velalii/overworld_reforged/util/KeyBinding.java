package net.velalii.overworld_reforged.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String KEY_CATEGORY_OVERWORLD_REFORGED = "key.category.overworld_reforged";
    public static final String KEY_OVELIAS_BLESSING = "key.overworld_reforged.ovelias_blessing";
    public static final KeyMapping OVELIAS_BLESSING_KEY = new KeyMapping(KEY_OVELIAS_BLESSING, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, KEY_CATEGORY_OVERWORLD_REFORGED);
}