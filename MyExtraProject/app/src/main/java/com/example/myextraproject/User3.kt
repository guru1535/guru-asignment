package com.example.myextraproject

import android.os.Parcel
import android.os.Parcelable

data class User3(

    val newpassword : String,
    val confirmpassword : String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(newpassword)
        parcel.writeString(confirmpassword)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User3> {
        override fun createFromParcel(parcel: Parcel): User3 {
            return User3(parcel)
        }

        override fun newArray(size: Int): Array<User3?> {
            return arrayOfNulls(size)
        }
    }
}
