package main

import container_factory.ContainerFactoryInterface
import container_factory.can_factory.CanFactory
import container_factory.glass_factory.GlassFactory
import drink_builder.DrinkBuilder
import liquids_factories.AbstractLiquidFactory
import liquids_factories.coffee_factory.CoffeeFactory
import liquids_factories.tea_factory.TeaFactory

object Main {
  lateinit var liquidFactory: AbstractLiquidFactory
  lateinit var containerFactory: ContainerFactoryInterface

  @JvmStatic
  fun main(args: Array<String>) {
    chooseLiquid()
    chooseContainer()

    val drink = DrinkBuilder()
      .setLiquid(liquidFactory.createObject())
      .setContainer(containerFactory.createContainer())
      .getDrink()

    with(drink) {
      println("Here's your ${liquid!!.name} in the ${container!!.name}")
    }

    println("Do you want to take another one for you friend?")

    val answer = readLine()

    when (answer!!.toLowerCase()) {
      "yes", "y", "yeah", "of course" -> {
        val drinkForFriend = drink.clone()

        with(drinkForFriend) {
          println("Here's ${liquid!!.name} in the ${container!!.name} for your friend! Thank you and have a nice day!")
        }
      }

      "n", "no" -> println("Well, thank you and have a nice day!")

      else -> println("I don't understand what do you mean by \"$answer\" but anyway have a nice day!")
    }
  }

  private fun chooseLiquid() {
    println("Hello! What drink do you want today? Coffee or Tea?")

    askWhile {
      when (it.toLowerCase()) {
        "coffee" -> {
          liquidFactory = CoffeeFactory.instance
          true
        }

        "tea" -> {
          liquidFactory = TeaFactory.instance
          true
        }

        "ocelot" -> {
          println("You're pretty good")
          false
        }

        "snake" -> {
          println("Snake? Snake?! Snaaaaake?!")
          false
        }

        else -> {
          println("Sorry, but we don't serve \"$it\" =(")
          false
        }
      }
    }
  }

  private fun chooseContainer() {
    println("Please, select container: Glass or Can")

    askWhile {
      when (it.toLowerCase()) {
        "glass" -> {
          containerFactory = GlassFactory.instance
        }

        "can" -> {
          containerFactory = CanFactory.instance
        }

        else -> {
          println("Sorry, but we don't have \"$it\" container =(")
          return@askWhile false
        }
      }

      return@askWhile true
    }
  }

  private fun askWhile(callback: (answer: String) -> Boolean) {
    var isValid = false

    while (!isValid) {
      val answer = readLine()

      answer!!.let {
        isValid = callback(it)
      }
    }
  }
}
