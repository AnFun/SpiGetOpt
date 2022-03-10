package me.AnFun

import org.bukkit.plugin.java.JavaPlugin

class SpiGetOpt : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    class Option (val names : List<String>, val isBool : Boolean)

    public fun getOpt(arg : String, options : List<Option>): Int{
        // remove - from arg string
        arg.trimStart('-').lowercase()
        for ((index,option) in options.withIndex()) {
            for (name in option.names) {
                if (name.lowercase().equals(arg)) return index
            }
        }
        return -1;
    }

}