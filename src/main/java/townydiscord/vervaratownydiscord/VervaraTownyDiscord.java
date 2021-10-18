package townydiscord.vervaratownydiscord;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.entities.User;
import github.scarsz.discordsrv.util.DiscordUtil;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import townydiscord.vervaratownydiscord.DiscordInitialisation.DiscordSRVListener;

public final class VervaraTownyDiscord extends JavaPlugin implements Listener {


    private final DiscordSRVListener discordsrvListener = new DiscordSRVListener(this);
    @Override
    public void onEnable() {
        // Plugin startup logic
        DiscordSRV.api.subscribe(discordsrvListener);
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        DiscordSRV.api.unsubscribe(discordsrvListener);
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event) {
        String discordId = DiscordSRV.getPlugin().getAccountLinkManager().getDiscordId(event.getPlayer().getUniqueId());
        if (discordId == null) {
            event.getPlayer().sendMessage(ChatColor.RED + "You are not linked, please link your minecraft account to discord :)");
            return;
        }

        User user = DiscordUtil.getJda().getUserById(discordId);
        if (user == null) {
            event.getPlayer().sendMessage(ChatColor.YELLOW + "Couldn't find the user you're linked to, open a ticket");
            return;
        }

    }

}
