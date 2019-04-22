package com.nain.easyloader.model

/**
 * @author julkar nain
 * @since 4/22/19
 */
open class User{
    lateinit var id: String
    lateinit var userName: String
    lateinit var name: String
    lateinit var profileImage : ProfileImage
}

open class ProfileImage{
    lateinit var small : String
    lateinit var medium : String
    lateinit var large : String
}