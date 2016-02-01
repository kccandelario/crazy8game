package package menu_commands
import org.scalatest.FunSpec
import org.scalatest.Matchers

class Show_Game_Area extends FunSpec with Matchers {
  
   describe("Sets Game Board") {
    describe("Gives each player 7 cards, places on card in the discard pile and the rest in the draw pile") {
      it("deals out the cards") {

        val p1cards = 7
				val p2cards = 7
				val p3cards = 7
				val p4cards = 7
        val discard = 1        
        val draw = 23        

        Show_Game_Area.isValid(p1cards) shouldBe true
        Show_Game_Area.isValid(p2cards) shouldBe true
        Show_Game_Area.isValid(p3cards) shouldBe true
				Show_Game_Area.isValid(p4cards) shouldBe true
      }   
    }
  }
}

class Show_Player_Order extends FunSpec with Matchers {
  
   describe("Displays the order of play") {
    describe("Shows who goes first, second etc.") {
      it("places the players in a queue") {

        val expectedResult = "p1, p2, p3, p4"

        Show_Player_Order.isValid(expectedResult) shouldBe true
      }   
    }
  }
}

class Show_Player_Order extends FunSpec with Matchers {
  
   describe("Advances the order of play") {
    describe("move whoever was first to fourth, second to first, third to second, and fourth to third etc.") {
      it("dequeues the first player then enqueue that same player") {

        val expectedResult = "p2, p3, p4, p1"

        Show_Player_Order.isValid(expectedResult) shouldBe true
      }   
    }
  }
}