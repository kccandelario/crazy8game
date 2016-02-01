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

        Menu.showP1HandSize shouldBe (p1cards)
        Menu.showP2HandSize shouldBe (p2cards)
        Menu.showP3HandSize shouldBe (p3cards)
		Menu.showP4Handsize shouldBe (p4cards)
		Menu.showDiscardSize shouldbe (discard)
		Menu.showDrawSize shouldbe (draw)
		hands.p1.hand!=hands.p2.hand shouldbe true
		hands.p2.hand!=hands.p3.hand shouldbe true
		hands.p3.hand!=hands.p4.hand shouldbe true
		hands.p4.hand!=hands.p1.hand shouldbe true
		Menu.showAllHands
      }   
    }
  }
}

class Show_Player_Order extends FunSpec with Matchers {
  
   describe("Displays the order of play") {
    describe("Shows who goes first, second etc.") {
      it("places the players in a queue") {

        val expectedResult = "p1, p2, p3, p4"

        Menu.showPlayerOrder shouldBe(expectedResult)
      }   
    }
  }
}

class Show_Player_Order extends FunSpec with Matchers {
  
   describe("Advances the order of play") {
    describe("move whoever was first to fourth, second to first, third to second, and fourth to third etc.") {
      it("dequeues the first player then enqueue that same player") {

        val expectedResult1 = "p2, p3, p4, p1"
		val expectedResult2 = "p3, p4, p1, p2"
		val expectedResult3 = "p4, p1, p2, p3"
		val expectedResult4 = "p1, p2, p3, p4"
        Menu.advancePlayerOrder shouldBe(expectedResult1)
		Menu.advancePlayerOrder shouldBe(expectedResult2)
		Menu.advancePlayerOrder shouldBe(expectedResult3)
		Menu.advancePlayerOrder shouldBe(expectedResult4)
      }   
    }
  }
}