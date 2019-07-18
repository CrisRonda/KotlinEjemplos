package com.example.myapplication.activities

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.myapplication.R
import com.example.myapplication.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_permissions.*
import android.Manifest
import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat

class PermissionsActivity : ToolbarActivity() {
    private val requestCameraPermission = 100
    private val requestCameraPicture = 200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)
        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)
        (toolbar as Toolbar).setNavigationOnClickListener { onBackPressed() }

        buttonPicture.setOnClickListener { getPictureFromCameraAskingPermission() }
        buttonOutPermission.setOnClickListener { getPictureFromCamera() }
    }

    private fun getPictureFromCamera() {
        val pictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (pictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(pictureIntent,requestCameraPicture)
        } else {
            //Sin Aplicacion de camara

        }
    }

    private fun getPictureFromCameraAskingPermission() {
        //Añadir permiso en el manifest
        //Comprobar el permiso de la camara
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            //Si no es aceptado para versiones 6.0 [API 23] en adelante
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), requestCameraPermission)
        } else {
            //SI ha sido aceptado antes e incluye para las versiones anteriores de 6.0
            openCamera()
        }
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, requestCameraPicture)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            requestCameraPicture -> {
                //Comprobar si la foto se tomo
                if (resultCode == Activity.RESULT_OK) {
                    //Obtenemos los extras del intent recibido
                    val extras = data!!.extras
                    //Formamos el bitmap de los extras pues es una foto
                    var imageBitmap = extras!!.get("data") as Bitmap
                    //Cargamos la foto como bitmap
                    imageViewPicture.setImageBitmap(imageBitmap)
                } else {
                    Toast.makeText(this, "Algo salio mal, intentalo de nuevo", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            requestCameraPermission -> {
                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera()
                } else {
                    Toast.makeText(this, "Permiso denegado por el usuario", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
