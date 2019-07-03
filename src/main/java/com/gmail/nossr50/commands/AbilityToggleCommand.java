package com.gmail.nossr50.commands;

import com.gmail.nossr50.datatypes.player.McMMOPlayer;
import com.gmail.nossr50.mcMMO;
import com.gmail.nossr50.util.Permissions;
import org.bukkit.command.CommandSender;

public class AbilityToggleCommand extends ToggleCommand {

    public AbilityToggleCommand(mcMMO pluginRef) {
        super(pluginRef);
    }

    @Override
    protected boolean hasOtherPermission(CommandSender sender) {
        return Permissions.mcabilityOthers(sender);
    }

    @Override
    protected boolean hasSelfPermission(CommandSender sender) {
        return Permissions.mcability(sender);
    }

    @Override
    protected void applyCommandAction(McMMOPlayer mcMMOPlayer) {
        mcMMOPlayer.getPlayer().sendMessage(pluginRef.getLocaleManager().getString("Commands.Ability." + (mcMMOPlayer.getAbilityUse() ? "Off" : "On")));
        mcMMOPlayer.toggleAbilityUse();
    }

    @Override
    protected void sendSuccessMessage(CommandSender sender, String playerName) {
        sender.sendMessage(pluginRef.getLocaleManager().getString("Commands.Ability.Toggle", playerName));
    }
}
