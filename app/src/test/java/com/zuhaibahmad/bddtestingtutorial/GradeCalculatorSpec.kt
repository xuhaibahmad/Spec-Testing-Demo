package com.zuhaibahmad.bddtestingtutorial

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import io.mockk.every
import io.mockk.spyk

class GradeCalculatorSpec : BehaviorSpec({

    Given("a grade calculator") {
        val calculator = spyk(GradeCalculator())

        every { calculator.totalMarks } returns 100
        val total = calculator.totalMarks

        When("obtained marks are 90 or above") {
            val grade = calculator.getGrade(93, total)

            Then("grade is A") {
                grade.shouldBe("A")
            }
        }
        When("obtained marks are between 80 and 89") {
            val grade = calculator.getGrade(88, total)

            Then("grade is B") {
                grade.shouldBe("B")
            }
        }
        When("obtained marks are between 70 and 79") {
            val grade = calculator.getGrade(78, total)

            Then("grade is C") {
                grade.shouldBe("C")
            }
        }
        When("obtained marks are between 60 and 69") {
            val grade = calculator.getGrade(68, total)

            Then("grade is D") {
                grade.shouldBe("D")
            }
        }
        When("obtained marks are below 60") {
            val grade = calculator.getGrade(59, total)
            Then("grade is F") {
                grade.shouldBe("F")
            }
        }
    }
})