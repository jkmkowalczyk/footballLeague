package application.utils;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerValidator {

    public List<String> validate(String name, String surname, String number, String team, String rate) {
        List<String> errors = new ArrayList<>();

        if (name == null || name.isEmpty())
            errors.add("name can not be empty");

        if (surname == null || surname.isEmpty())
            errors.add("surname can not be empty");

        if (number == null || number.isEmpty())
            errors.add("number can not be empty");
        else try {
            Integer.valueOf(number);
        } catch (Exception e) {
            errors.add("number must be a numeric value");
        }

        if (team == null || team.isEmpty())
            errors.add("team can not be empty");

        if (rate == null || rate.isEmpty())
            errors.add("rate can not be empty");
        else try {
            BigDecimal playerRate = new BigDecimal(rate);
            if (playerRate.compareTo(BigDecimal.valueOf(10)) >= 0) {
                errors.add("rate must be smaller than 10");
            }
        } catch (Exception e) {
            errors.add("rate must be a numeric value");
        }

        return errors;
    }
}