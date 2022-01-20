package com.me.kotlin

/**
 * 重写equals和hashCode方法<br/>
 * 对象的属性要用val，防止发生变化时，hashSet、hashMap无法正常移除该对象
 */
class Person(val age: Int, val name: String) {

    override fun equals(other: Any?): Boolean {
        val person = (other as? Person) ?: return false
        return person.age == this.age && person.name == this.name
    }

    override fun hashCode(): Int {
        return 1 + 3 * this.age + 7 * this.name.hashCode()
    }
}

fun main() {

    val personSet = HashSet<Person>()

    (0..5).forEach {
        personSet += Person(18, "zhangSan")
    }

    // 如果重写过equals和hashCode，则size=1
    println(personSet.size)

    // 若personSet中的对象的值发生过变更的话，无法正常移除
    val person = Person(25, "xnc")
    personSet += person
    // 可以创建新的对象代替原来的对象
    val newPerson = Person(person.age + 1, person.name)
    personSet -= person
    personSet += newPerson
}