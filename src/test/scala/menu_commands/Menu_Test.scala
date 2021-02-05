package menu_commands

import org.scalatest.FunSpec
import org.scalatest.Matchers


class Menu_Test extends FunSpec with Matchers {

   describe("Monopoly Deal Simulation") {
    describe("has a menu") {

      //******* SHOW GAME AREA *******
      it("can show the game area, including the players, player hands, money piles, and property collections") {

        val expectedResult =
            "Game State:\n" +
            "------------------------Player 1----------------------------\n" +
            "Cards In Hand: [Card 1][Card 2][Card 3][Card 4][Card 5].....\n" +
            "Money in Pile (Total = $Amt): [Card 1][Card 2][Card 3]......\n" +
            "Properties (# Complete): [2/3 Red][1/4 Railroads]...........\n" +
            "------------------------------------------------------------\n" +
            "------------------------Player 2----------------------------\n" +
            "Cards In Hand: [Card 1][Card 2][Card 3][Card 4][Card 5].....\n" +
            "Money in Pile (Total = $Amt): [Card 1][Card 2][Card 3]......\n" +
            "Properties (# Complete): [1/3 Green][2/2 Dark Blue].........\n" +
            "------------------------------------------------------------\n" +
            "------------------------Player 3----------------------------\n" +
            "Cards In Hand: [Card 1][Card 2][Card 3][Card 4][Card 5].....\n" +
            "Money in Pile (Total = $Amt): [Card 1][Card 2][Card 3]......\n" +
            "Properties (# Complete): [1/2 Brown][1/3 Light Blue]........\n" +
            "------------------------------------------------------------\n" +
            "------------------------Player 4----------------------------\n" +
            "Cards In Hand: [Card 1][Card 2][Card 3][Card 4][Card 5].....\n" +
            "Money in Pile (Total = $Amt): [Card 1][Card 2][Card 3]......\n" +
            "Properties (# Complete): [3/4 Railroads][1/3 Yellow]........\n" +
            "------------------------------------------------------------\n" +
            "\n"

        Menu.showGameArea should be(expectedResult)
      }

      //******* SHOW PLAYER ORDER *******
      it("can show the player order") {
        val expectedResult = "Player1, PLayer2, Player3, Player4"
        Menu.showPlayerOrder should be(expectedResult)
      }

      //******* ADVANCE ORDER *******
      it("can advance the player order") {
        val expectedResult_0_advances = "Player1, PLayer2, Player3, Player4"
        val expectedResult_1_advances = "Player2, PLayer3, Player4, Player1"
        val expectedResult_2_advances = "Player3, PLayer4, Player1, Player2"
        val expectedResult_4_advances = "Player1, PLayer2, Player3, Player4"

        Menu.showPlayerOrder should be(expectedResult_0_advances)

        Menu.advancePlayerOrder should be(expectedResult_1_advances)

        Menu.advancePlayerOrder
        Menu.showPlayerOrder should be(expectedResult_2_advances)

        Menu.advancePlayerOrder   // 3 advances

        Menu.advancePlayerOrder
        Menu.showPlayerOrder should be(expectedResult_4_advances)
        Menu.showPlayerOrder should be(expectedResult_0_advances)
      }


    }
  }
}
