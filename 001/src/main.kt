val scan = java.util.Scanner(System.`in`).useLocale(java.util.Locale.US)

open class Bug(val rank: Int, val name:String) {
    open fun getSugarLimit(): Int{
        return rank
    }

    fun getId(): String{
        return "{rank}.{name}"
    }
}

class  BugCivilian(rank: Int, name:String): Bug(rank, name) {
    override fun getSugarLimit(): Int{
        return super.getSugarLimit() / 2
    }
}

class Dog(name: String) {
    init {
        print("Создан новый объект типа Dog с именем $name")
    }
}

class Car() {
    fun ride(km: Int) {
        println("Поехали!")
        for (i in km downTo 1) {
            println("Осталось $i километров")
        }
        println("Приехали!")
    }
}

fun makeCatVoice(e: Cat){
    e.voice()
}
//open class Cat {
//    open fun voice() {
//        println("Meow meow meow!!!")
//    }
//}
//
//class HomeCat(val name: String): Cat() {
//    override fun voice() {
//        println("Meoooooow! Feed me, $name!")
//    }
//}

open class Cat {
    open fun hunt () {
        println("Я охочусь на мышей, ведь я кот!")
    }
}

class HomeCat: Cat() {
    fun hunt(predator: Boolean) {
        if (predator) {
            super.hunt()
        } else {
            println("Ты че сдурел? Какие мыши? Иди корми меня, ленивая задница!")
        }
    }
}

fun enableMyComputer(computer: Computer) {
    computer.enable()
}

fun main(args: Array<String>) {
    val usualCat = Cat()        // Создаем обычного кота

    val name = scan.next()      // Считываем имя
    val homeCat = HomeCat(name) // Передаём в конструктор

    val num = scan.nextInt()

    repeat(num) {
        makeCatVoice(usualCat)
        makeCatVoice(homeCat)
    }
}

fun check(s1: String, s2: String, ignoreCase: Boolean = false): Boolean = s1[0].equals(s2[0], ignoreCase)

fun isCaseEquals(a: Char, b: Char): Boolean {
    return a.isUpperCase() == b.isUpperCase()
}

fun isCapitalized(s: String): Boolean {
    return s[0].isUpperCase()
}

fun calcNullValues(input: Array<Int?>): Array<Int>{
    val arr = Array<Int>(2, {0})
    for (item in input) {
        when {
            item == null -> arr[0]++
            else ->  arr[1] += item
        }
    }

    return arr
}

fun calcNullValues1(input: Array<Int?>): Array<Int> {
    return arrayOf(input.count{it==null}, input.sumBy { it ?: 0 })
}

fun calculateWordStat1(input:String): String{
    var s = "" to 0
    val li = input.split(" ")
    for (el in li.toSet()) if (s.second<li.count{it==el}) s = el to li.count{it==el}
    return s.first
}

fun calculateWordStat(input: String): String {
    val arr = input.split(" ")
    var count1 = 0
    var count2: Int
    var word: String = arr[0]
    for (item1 in arr) {
        count2 = 0
        for (item2 in arr) {
            if (item2 == item1) {
                count2++
            }
        }
        if (count2 > count1) {
            word = item1
            count1 = count2
        }
    }

    return word
}

fun getCubeList(n:Int): Array<Int>{
    return Array<Int>(n, {i -> i * i * i})
}

fun calculateBugMentions(input:List<String>): Int{
    var count = 0
    for (word in input) {
        if (word == "BUG") {
            count++
        }
    }
    return count
}

fun getYearEra(year: Int): String{
    when {
        year < 1970 -> return "before"
        year == 1970 -> return "equals"
        year > 1970 && year < 2000 -> return "after(XX century)"
        year >= 2000 && year < 2100 -> return "after (XXI century)"
        else -> return "distant future"
    }
}

fun calculateEvenDigits(input: String): Int{
    var sum = 0
    for (char in input) {
        val num = char.toString().toInt()
        if (num % 2 == 0) {
            sum += num
        }
    }
    return sum
}
