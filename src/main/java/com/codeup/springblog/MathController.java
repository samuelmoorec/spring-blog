package com.codeup.springblog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(path = "/{action1}/{num1}/{action2}/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String math(@PathVariable String action1,@PathVariable Double num1,@PathVariable String action2,@PathVariable Double num2){
        if (action1.equals("add")){
            return action1 + "ing " + num1 + " " + action2 + " " + num2 + " equals " + (num1 + num2);
        }else if (action1.equals("subtract")){
            return action1 + "ing " + num1 + " " + action2 + " " + num2 + " equals " + (num1 - num2);
        }else if (action1.equals("multiply")){
            return action1 + "ing " + num1 + " " + action2 + " " + num2 + " equals " + (num1 * num2);
        }else if (action1.equals("divide")){
            return action1 + "ing " + num1 + " " + action2 + " " + num2 + " equals " + (num1 / num2);
        }else{
            return "Invalid Input";
        }
    }


}
