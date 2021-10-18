package townydiscord.vervaratownydiscord;

import com.palmergames.bukkit.towny.event.NewNationEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GetTownyEvents implements Listener {


    @EventHandler
    public void OnNewNationEvent(NewNationEvent e){
        var name = e.getNation().getName();

        System.out.println();
    }
}
