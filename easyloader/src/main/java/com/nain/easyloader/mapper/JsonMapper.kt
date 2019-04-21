package com.nain.easyloader.mapper

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

object JsonMapper {
    fun map(instance: Any, jsonObject: JSONObject): Any {
        val clazz = instance.javaClass

        for (field in clazz.getFields()) {
            val fieldName = field.getName()

            if (fieldName.equals("$"+"change") || fieldName.equals("serialVersionUID")){
                continue
            }
            var value: Any? = null
            try {
                value = jsonObject.get(fieldName)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            field.set(instance, value)

        }

        return instance
    }

    fun map(list: MutableList<Any?>, instance: Any, jsonArray: JSONArray) : List<Any?>{
        val clazz = instance.javaClass

        val length = jsonArray.length()-1
        for (i in 0..length){
            val obj = clazz.getConstructor().newInstance()
            list.add(map(obj, jsonArray.get(i) as JSONObject))
        }

        return list
    }
}