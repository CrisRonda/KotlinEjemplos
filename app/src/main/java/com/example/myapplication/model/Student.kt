package com.example.myapplication.model

import android.os.Parcel
import android.os.Parcelable

data class Student(var name: String?, var lastName: String?, var age: Int, var isDeveloper: Boolean = true) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //Valores en el mismo orden del constructor
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (isDeveloper) 1 else 0)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Student> {
        //Creará el objeto desde el parcel lamando al constructor secundario
        override fun createFromParcel(parcel: Parcel) = Student(parcel)

        //Ayuda a serializar Arrays de objetos de la clase especificada (Student)
        override fun newArray(size: Int) = arrayOfNulls<Student?>(size)

    }


}

