package application.utils;

import application.dto.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerValidator {

    public boolean validate(Player player) {
        return player.getName() != null
                && player.getSurname() != null
                && player.getTeam() != null
                && player.getNumber() != null
                && player.getRate() != null;
    }


}
