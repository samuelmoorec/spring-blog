package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class DiceRollController {


    @GetMapping("/roll-dice")
    public String diceRoll(){

        return "DiceRoll";
    }

    @RequestMapping(path = "/roll-dice/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String diceOutcome(@PathVariable Long number){
        int random = (int) (Math.random()*6)+1;
        if (number == random){
            return "GuessedRight";
        }else{
            return "GuessedWrong";
        }


    }
}
