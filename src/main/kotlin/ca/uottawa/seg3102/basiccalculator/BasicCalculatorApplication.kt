package ca.uottawa.seg3102.basiccalculator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BasicCalculatorApplication

fun main(args: Array<String>) {
	runApplication<BasicCalculatorApplication>(*args)
}
