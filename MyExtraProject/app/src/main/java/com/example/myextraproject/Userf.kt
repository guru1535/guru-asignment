package com.example.myextraproject

import android.os.Parcel
import android.os.Parcelable

data class Userf(  val email1 : String,
                   val password : String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email1)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Userf> {
        override fun createFromParcel(parcel: Parcel): Userf {
            return Userf(parcel)
        }

        override fun newArray(size: Int): Array<Userf?> {
            return arrayOfNulls(size)
        }
    }
}
