package ca.uottawa.seg3102.basiccalculator.controllers
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class WebController {
    @ModelAttribute
    fun addAttributes(model: Model) {
        model.addAttribute("error", "")
        model.addAttribute("firstNumber", 0.0)
        model.addAttribute("secondNumber", 0.0)
        model.addAttribute("result","")
    }
    @RequestMapping("/")
    fun home(): String {
        return "home"
    }

    @GetMapping(value = ["/calculate"])
    fun calculate(
            @RequestParam(value = "firstNumber", required = false) firstNumber: Double,
            @RequestParam(value = "secondNumber", required = false) secondNumber: Double,
            @RequestParam(value = "operation", required = false) operation: String,
            model: Model
    ): String {
        var result: Double
        when (operation) {
            "add" -> {
                try {
                    result = firstNumber.toDouble() + secondNumber.toDouble()
                    model.addAttribute("firstNumber", firstNumber.toDouble())
                    model.addAttribute("secondNumber", secondNumber.toDouble())
                    model.addAttribute("result", result)
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "AdditionError")
                    model.addAttribute("firstNumber", firstNumber.toDouble())
                    model.addAttribute("secondNumber", secondNumber.toDouble())
                    model.addAttribute("result", "")
                }
            }
            "subtract" -> {
                try {
                    result = firstNumber.toDouble() - secondNumber.toDouble()
                    model.addAttribute("firstNumber", firstNumber.toDouble())
                    model.addAttribute("secondNumber", secondNumber.toDouble())
                    model.addAttribute("result", result)
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "SubtractionError")
                    model.addAttribute("firstNumber", firstNumber.toDouble())
                    model.addAttribute("secondNumber", secondNumber.toDouble())
                    model.addAttribute("result", "")
                }
            }
            "multiply" -> {
                try{
                    result = firstNumber.toDouble() * secondNumber.toDouble()
                    model.addAttribute("firstNumber", firstNumber.toDouble())
                    model.addAttribute("secondNumber", secondNumber.toDouble())
                    model.addAttribute("result", result)
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "MultiplicationError")
                    model.addAttribute("firstNumber", firstNumber.toDouble())
                    model.addAttribute("secondNumber", secondNumber.toDouble())
                    model.addAttribute("result", "")
                }
            }
            "divide" -> {
                try{
                    result = firstNumber.toDouble() / secondNumber.toDouble()
                    model.addAttribute("firstNumber", firstNumber.toDouble())
                    model.addAttribute("secondNumber", secondNumber.toDouble())
                    model.addAttribute("result", result)
                } catch (exp: NumberFormatException) {
                    model.addAttribute("error", "DivisionError")
                    model.addAttribute("firstNumber", firstNumber.toDouble())
                    model.addAttribute("secondNumber", secondNumber.toDouble())
                    model.addAttribute("result", "")

                }
            }
            else -> {
                model.addAttribute("error", "OperationFormatError")
                model.addAttribute("firstNumber", firstNumber.toDouble())
                model.addAttribute("secondNumber", secondNumber.toDouble())
                model.addAttribute("result", "")
            }
        }
        return "home"
    }

}