package me.AnFun

import org.bukkit.block.data.type.Switch
import org.bukkit.plugin.java.JavaPlugin

class SpiGetOpt : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    public fun getOpt(args: List<String>, clazz: Class<*>){
        val builtClass = clazz.getDeclaredConstructor().newInstance()
        var index = 0;
        while (index < args.size){
            for (field in clazz.fields) {
                if (field.name == args[index].trimStart('-').lowercase()) {
                    // set the val idk
                    when (field.type) {
                        String::class.java ->
                            if (index+1 < args.size) field.set(builtClass,getString(args))

                        Int::class.java ->
                            if (index+1 < args.size) field.set(builtClass,getInt())
                        Long::class.java ->
                            if (index+1 < args.size) field.set(builtClass,getLong())
                        Double::class.java ->
                            if (index+1 < args.size) field.set(builtClass,getDouble())
                        Float::class.java ->
                            if (index+1 < args.size) field.set(builtClass,getFloat())

                        //Enum::class.java -> "god"
                        Boolean::class.java -> field.set(builtClass,true)

                    }

                    field.set(builtClass,field)
                }
            }
            index++
        }
    }

    fun getString(args: List<String>): String {
        var retString = ""

        return retString
    }

    fun getInt(): Int {
        return 0
    }

    fun getLong(): Long {
        return 0
    }

    fun getDouble(): Double {
        return 0.0
    }

    fun getFloat(): Float {
        return 0.0f
    }

    /*fun getEnum(): Enum {

    }*/


}