package com.nain.easyloader

import com.nain.easyloader.model.ProfileImage
import com.nain.easyloader.model.User
import org.json.JSONArray
import org.json.JSONObject

/**
 * @author julkar nain
 * @since 4/22/19
 */
object Utils {
    fun mapUserObject(jsonArray: JSONArray): List<User> {

        val list = mutableListOf<User>()
        val length = jsonArray.length() - 1

        for (i in 0..length) {
            val json = jsonArray[i] as JSONObject
            val jsonUser = json.get("user") as JSONObject
            val user = User()
            user.id = jsonUser.getString("id")
            user.userName = jsonUser.getString("username")
            user.name = jsonUser.getString("name")

            val jsonProfileImage = jsonUser.get("profile_image") as JSONObject

            user.profileImage = ProfileImage()
            user.profileImage.small = jsonProfileImage.getString("small")
            user.profileImage.medium = jsonProfileImage.getString("medium")
            user.profileImage.large = jsonProfileImage.getString("large")

            list.add(user)
        }

        return list
    }
}