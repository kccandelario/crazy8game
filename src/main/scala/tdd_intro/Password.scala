package tdd_intro

object Password {
  def isValid (password : String) : Boolean = { 
    if (password.length >=6) return true
    else return false
  }
}