package menu_commands
import scala.collection.mutable.ListBuffer
import scala.util.Random


object Menu{
	def showGameArea: Int = { //Just shows the number of cards in each player's hand
		hands.show
	}
	def showAllHands: String = { //Shows the number of cards in each player's hand, the type of cards,
		hands.showFullHand // the number of cards in the discard pile, and draw pile. 
	}
	def showPlayerOrder: String ={ //Shows the current player order
		return PlayerOrder.show
	}
	def advancePlayerOrder: String = { //Advances the player order one turn, then displays the new order
		PlayerOrder.advance
		return PlayerOrder.show
	}
}



// function for creating a new UNSHUFFLED deck. 
def makeNewDeck(): List[String]= {
	var suits=List("c","h","d","s")
	var cards= List("2","3","4","5","6","7","8","9","10","J","Q","K","A")
	var newDeck= new ListBuffer[String]()
	var index=0
	for (c<-cards){
		for(s<-suits){
			newDeck+=c+s
		}
	}
	return(newDeck.toList)
	}
// Takes a deck and shuffles it
def shuffle(deck:List[String]): List[String]={
	var n=deck.length-1
	var len=deck.length-1
	var g=scala.util.Random
	var b=0
	var pos1=""
	var pos2=""
	var newDeck= deck
	while(n!= -1) {
		b=g.nextInt(len)
		pos1=newDeck(n)
		pos2=newDeck(b)
		newDeck=newDeck.updated(n,pos2)
		newDeck=newDeck.updated(b,pos1)
		n-=1
	}
	return newDeck
	}
// Function that deals a specified number of cards to a player.
// Can also be used to add or remove cards from the discard or draw pile. 
def deal(deck: List[String], person: Player, cardsToDeal: Int): List[String] ={
	var newDeck= deck.to[ListBuffer]
	var length=newDeck.length-1
	var cards=cardsToDeal
	while(cards>(0)){
		person.hand+=newDeck(length)
		newDeck-=newDeck(length)
		length-=1
		cards-=1
	}
	newDeck.toList
	}
// handles each player's hands, as well as the cards in 
// the draw and discard piles
object hands{
	var startingDeck=makeNewDeck()
	var deck=shuffle(startingDeck)
	var p1= new Player("p1")
	var p2= new Player("p2")
	var p3= new Player("p3")
	var p4= new Player("p4")
	var discard= new Player("Discard Pile")
	deck=deal(deck, p1, 7)
	deck=deal(deck, p2, 7)
	deck=deal(deck, p3, 7)
	deck=deal(deck, p4, 7)
	deck=deal(deck,discard,1)
	var players=List(p1,p2,p3,p4)
	def showFullHand = {
		var result= "Cards In Hand: " +"\n"
		var result2= "Cards in Discard Pile: "
		var result3= "Cards in Draw Pile: " + deck.length.toString
		result2+= discard.hand.length.toString
		for(p<-players)
			result+=p.name + "=" + p.hand.toList.toString + " Number of Cards in Hand: " + p.hand.length.toString + "\n"
		result += result2 + "\n" + result3
		result.substring(0,result.length)
		}
	def show = {
		p1.hand.length
		p2.hand.length
		p3.hand.length
		p4.hand.length
		}
	}





// PlayerOrder and Player works
object PlayerOrder extends scala.collection.mutable.Queue[Player] {
  this += new Player("p1")
  this += new Player("p2")
  this += new Player("p3")
  this += new Player("p4")
  //advances player order by 1 turn
  def advance {
    this += this.dequeue
  }
  
  def show : String = {
    var result = ""    
    for (p <- this.toArray) 
      result += p.name + ", "
    result.substring(0, result.length-2)
  }
}


// defines a player, starting them with an empty hand. 
// cards can be added to a player's hand using the deal function.
class Player (val name : String) {
  var hand= new ListBuffer[String]()
}

Menu.showGameArea
Menu.showAllHands
Menu.showPlayerOrder
Menu.advancePlayerOrder