package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commCalc_VK_Pay() {
        //arrange
        val amount_ = 62179
        val card_ = "VK Pay"
        val prevTrans_ = 62179

        //act
        val result = commCalc(
            amount = amount_,
            card = card_,
            prevTrans = prevTrans_
        )

        //assert
        assertEquals(0,result )
    }

    @Test
    fun commCalc_Visa_if() {
        //arrange
        val amount_ = 105000_0
        val card_ = "Visa"
        val prevTrans_ = 1007_00
        //act
        val result = commCalc(
            amount = amount_,
            card = card_,
            prevTrans = prevTrans_
        )
        //assert
        assertEquals(78750,result )
    }

    @Test
    fun commCalc_Visa_else() {
        //arrange
        val amount_ = 1000_00
        val card_ = "Visa"
        val prevTrans_ = 1457_00
        //act
        val result = commCalc(
            amount = amount_,
            card = card_,
            prevTrans = prevTrans_
        )
        //assert
        assertEquals(3500,result )
    }

    @Test
    fun commCalc_Maestro_if() {
        //arrange
        val amount_ = 1000_00
        val card_ = "Maestro"
        val prevTrans_ = 17525_00

        //act
        val result = commCalc(
            amount = amount_,
            card = card_,
            prevTrans = prevTrans_
        )

        //assert
        assertEquals(0,result )
    }

    @Test
    fun commCalc_Maestro_else() {
        //arrange
        val amount_ = 100300_00
        val card_ = "Maestro"
        val prevTrans_ = 17000_00

        //act
        val result = commCalc(
            amount = amount_,
            card = card_,
            prevTrans = prevTrans_
        )

        //assert
        assertEquals(62180,result )
    }

    @Test
    fun commCalc_when_else() {
        //arrange
        val amount_ = 100300_00
        val card_ = "Hello"
        val prevTrans_ = 17000_00

        //act
        val result = commCalc(
            amount = amount_,
            card = card_,
            prevTrans = prevTrans_
        )

        //assert
        assertEquals(0, result )
    }

    @Test
    fun messageRuble_() {
        //arrange
        val сommission_ = 62179

        //act
        val result = messageRuble(
            сommission = сommission_,
        )

        //assert
        assertEquals(621,result )
    }

    @Test
    fun messagePenny_() {
        //arrange
        val сommission_ = 62180

        //act
        val result = messagePenny(
            сommission = сommission_,
        )

        //assert
        assertEquals(79,result )
    }
}







